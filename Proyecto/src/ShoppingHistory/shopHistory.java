/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingHistory;

import Products.ListProd;
import Products.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author eliasvidal
 */
public class shopHistory {
    
    public shopHistory(){
        getInfoFile();
    }
    
    node top;
    
    public node getLast(){
        node b = top;
        while(b != null){
            if (b.next == null) {
                return b;
            }
            b = b.next;
        }
        return null;
    }
    
    public node getTopList(){
        return top;
    }
    
    public node searchSale(String idSale){
        if(top==null)
            return null;
        else{
            node p = top;
            while(p!=null){
                if (p.idSale.equals(idSale)) {
                    return p;
                }
                p = p.next;
            }
            return null;
        }
    }
    
    public Product prodExists(String idProd){
        ListProd prod = new ListProd();
        ArrayList<Product> listProd = prod.listProd;
        for (int i = 0; i < listProd.size(); i++) {
            if (listProd.get(i).id.equals(idProd)) {
                return listProd.get(i);
            }
        }
        return null;
    }
    
    public node createNode(String idSale, String idProd, String idUser, String amount, String date){
        
        try {
            node q = new node(idSale, idProd, idUser, date, amount);
            return q;

        } catch (Exception e) {
            return null;
        }
    }
    
    public void addNode(node q){   
        if(top==null){
            top=q;
        }else{
            q.next = top;
            top = q;
        }
    }
    
    public boolean addNewNodeEnd(String ids, String idProd, String idUser, String amount, String date){
        
        node q = createNode(ids, idProd, idUser, amount, date);
        
        if(prodExists(idProd) != null){
            if (q != null) {
                if (top == null) {
                    top = q;
                    return true;
                } else {
                    q.next = top;
                    top = q;
                    return true;
                }
            }
            return false;
        }else{
            System.out.println("idprod was not found");
            return false;
        }
    }
    
    public void registerInFile(String ids, String idProd, String idUser, String amount, String date) {
        FileWriter file = null;
        PrintWriter printw = null;
        
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/ShoppingHistory/shopHistory.txt");
            printw = new PrintWriter(file);
            
            boolean newNode = addNewNodeEnd(ids, idProd, idUser, amount, date);
            
            if (newNode) {
                node p = top;

                while(p!=null){
                    printw.println(p.idSale);
                    printw.println(p.idUser);
                    printw.println(p.idProd);
                    printw.println(p.date);
                    printw.println(p.amount);
                    p = p.next;
                }
                
            }else{
            }
        } catch (Exception e) {
        } finally {
            try {
                if (null != file) {
                    file.close();
                }
            } catch (Exception e2) {
            }
        }
    }
    
    public ArrayList<Integer> getAllSales(){
        ArrayList<Integer> salesInMonths = new ArrayList<Integer>();
        node b = top;
        int jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, ago = 0, sept = 0, oct = 0, nov = 0, dic = 0;
        while(b != null){
            switch(b.date){
                case "1": 
                    jan++;
                    b = b.next;
                    break;
                    
                case "2": 
                    feb++;
                    b = b.next;
                    break;
                    
                case "3": 
                    mar++;
                    b = b.next;
                    break;
                    
                case "4": 
                    apr++;
                    b = b.next;
                    break;
                    
                case "5": 
                    may++;
                    b = b.next;
                    break;
                    
                case "6": 
                    jun++;
                    b = b.next;
                    break;
            
                case "7": 
                    jul++;
                    b = b.next;
                    break;
                    
                case "8": 
                    ago++;
                    b = b.next;
                    break;
                
                case "9": 
                    sept++;
                    b = b.next;
                    break;
                
                case "10": 
                    oct++;
                    b = b.next;
                    break;
                    
                case "11": 
                    nov++;
                    b = b.next;
                    break;
                    
                case "12": 
                    dic++;
                    b = b.next;
                    break;
                
            }
        }
        
        salesInMonths.add(jan);
        salesInMonths.add(feb);
        salesInMonths.add(mar);
        salesInMonths.add(apr);
        salesInMonths.add(may);
        salesInMonths.add(jun);
        salesInMonths.add(jul);
        salesInMonths.add(ago);
        salesInMonths.add(sept);
        salesInMonths.add(oct);
        salesInMonths.add(nov);
        salesInMonths.add(dic);
        
        return salesInMonths;
        
    }
    
    public void getInfoFile(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/ShoppingHistory/shopHistory.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr); //makes fr readable, it sort of translates it.
            
            String linea;
            int i=0;
            node sale = new node();
            while ((linea = br.readLine()) != null) {
                    switch(i){
                    case 0:
                        node found = searchSale(linea.trim());
                        if (found == null) {
                            sale.idSale = linea.trim();
                            i++;
                            break;
                        }else{
                            return;
                        }
                        
                    case 1:
                        sale.idUser = linea.trim();
                        i++;
                        break;
                    
                    case 2:
                        sale.idProd = linea.trim();
                        i++;
                        break;
                        
                    case 3:
                        sale.date = linea.trim();
                        i++;
                        break;
                        
                    case 4:
                        sale.amount = linea.trim();
                        addNode(sale);
                        sale = new node();
                        i=0;
                        break;
                    }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null, "Información: \n"+e.getMessage(), 
                "Error!",
                JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(
                    null, "Información: \n"+e2.getMessage(), 
                    "Error!",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
}
