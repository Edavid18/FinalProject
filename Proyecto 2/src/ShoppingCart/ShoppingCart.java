/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingCart;

import Date.fecha;
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
public class ShoppingCart {
    
    public ShoppingCart(){
        getInfoFile();
        getInfoSale();
    }
    
    node top;
    String idSale;
    fecha date = new fecha();
    
    public void Message(String message){
            System.out.println(message);
    }
    
    public node getTopList(){
        return top;
    }
    
    public void print(){
        node b = top;
        while(b!=null){
            System.out.println(b);
            b = b.next;
        }
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
            System.out.println(listProd.get(i).id);
            System.out.println(idProd);
            if (listProd.get(i).id.equals(idProd)) {
                return listProd.get(i);
            }
        }
        return null;
    }
    
    public void whoBought(String idUser){
        
    }
    
    public node getLast(){
        if (top != null) {
            node b = top;
            while(b != null){
                if (b.next == null) {
                    return b;
                }
                b = b.next;
            }
        }
        return null;
    }
    
    public node createNode(String idProd, String idUser){
        
        node p = searchSale(idSale);
        
        try {
            if (p != null) {
                Message("Sale already registered.");
                return null;
            } else {
                node q = new node(idSale, idProd, idUser, date.date);
                changeIdSale();
                getInfoSale();
                return q;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public void addNodeEnd(node q){   
        if(top==null){
            top=q;
            Message("Cab era null, ahora es lo que estaba de primero en el archivo");
        }else{
            node l = getLast();
            l.next = q;
        }
    }
    
    public boolean addNewNodeEnd(String idProd, String idUser){
        
        node q = createNode(idProd, idUser);
        
        if(prodExists(idProd) != null){
            if (q != null) {
                if (top == null) {
                    top = q;
                    Message("Element registered. List was empty");
                    return true;
                } else {
                    node l = getLast();
                    l.next = q;
                    return true;
                }
            }
            return false;
        }else{
            System.out.println("idprod was not found");
            return false;
        }
    }
    
    public void registerInFile(String idProd, String idUser) {
        FileWriter file = null;
        PrintWriter printw = null;
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/ShoppingCart/shoppingList.txt");
            printw = new PrintWriter(file);
            
            boolean newNode = addNewNodeEnd(idProd, idUser);
            
            if (newNode) {
                node p = top;

                while(p!=null){
                    printw.println(p.idSale);
                    printw.println(p.idUser);
                    printw.println(p.idProd);
                    printw.println(p.date);
                    p = p.next;
                }

                Message("Data saved in file.");
            }else{
                Message("No new data saved.");
            }
        } catch (Exception e) {
            Message("Error1!");
        } finally {
            try {
                if (null != file) {
                    file.close();
                }
            } catch (Exception e2) {
                Message("Error when closing!");
            }
        }
    }
    
    public void getInfoFile(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/ShoppingCart/shoppingList.txt");
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
                            Message("one or more ID's in the text file already exist!");
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
                        addNodeEnd(sale);
                        sale = new node();
                        i=0;
                        break;
                    }
            }
            Message("Datos válidos cargados al archivo");
            
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
    
    public void changeIdSale(){
        FileWriter file = null;
        PrintWriter printw = null;
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/ShoppingCart/idSale.txt");
            printw = new PrintWriter(file);
            
            int inIdSale = Integer.parseInt(idSale);
            int tempIdSale = inIdSale + 1;
            String newIdSale = String.valueOf(tempIdSale);
            
            printw.println(newIdSale);
            
        } catch (Exception e) {
            Message("Error1!");
        } finally {
            try {
                if (null != file) {
                    file.close();
                }
            } catch (Exception e2) {
                Message("Error when closing!");
            }
        }
    }
    
    public void getInfoSale(){
        System.out.println("llegó aquí");
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        System.out.println("ahora llegó acá");
        try {
            archivo = new File("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/ShoppingCart/idSale.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr); //makes fr readable, it sort of translates it.
            
            String linea;
            while ((linea = br.readLine()) != null) {
                idSale = linea.trim();
            }
            System.out.println("Datos válidos cargados al archivo pero con sexo");
            
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
