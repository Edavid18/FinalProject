/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingCart;

import Date.fecha;
import Products.ListProd;
import Products.Product;
import VistaControlador.SignUpController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
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
            System.out.println(b.idSale);
            b = b.next;
        }
    }
    
    public node getBefore(node q){
        node b = top;
        while(b != null){
            if (b.next == q) {
                return b;
            }
            b = b.next;
        }
        return null;
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
    
    public node createNode(String idProd, String idUser, String amount){
        
        node p = searchSale(idSale);
        
        try {
            if (p != null) {
                Message("Sale already registered.");
                return null;
            } else {
                node q = new node(idSale, idProd, idUser, date.date, amount);
                changeIdSale();
                getInfoSale();
                return q;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public void addNode(node q){   
        if(top==null){
            top=q;
            Message("Cab era null, ahora es lo que estaba de primero en el archivo");
        }else{
            q.next = top;
            top = q;
        }
    }
    
    public boolean addNewNodeEnd(String idProd, String idUser, String amount){
        
        node q = createNode(idProd, idUser, amount);
        
        if(prodExists(idProd) != null){
            if (q != null) {
                if (top == null) {
                    top = q;
                    Message("Element registered. List was empty");
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
    
    public void registerInFile(String idProd, String idUser, String amount) {
        FileWriter file = null;
        PrintWriter printw = null;
        
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/ShoppingCart/shoppingList.txt");
            printw = new PrintWriter(file);
            
            boolean newNode = addNewNodeEnd(idProd, idUser, amount);
            
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
                
                print();
                
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
    
    public void registerOneItemInFile(String idProd, String idUser, String amount) {
        FileWriter file = null;
        PrintWriter printw = null;
        
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/ShoppingCart/buyItem.txt");
            printw = new PrintWriter(file);
            
            printw.println(idUser);
            printw.println(idProd);
            printw.println(date.date);
            printw.println(amount);
            
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
    
    public void overWriteFile(){
        FileWriter file = null;
        PrintWriter printw = null;
        
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/ShoppingCart/shoppingList.txt");
            printw = new PrintWriter(file);
            
            node p = top;
            while(p!=null){
                printw.println(p.idSale);
                printw.println(p.idUser);
                printw.println(p.idProd);
                printw.println(p.date);
                printw.println(p.amount);
                p = p.next;
            }
            

            Message("Data overwritten.");
        } catch (Exception e) {
            Message("Error al overwrite!");
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
    
    public void deleteProduct(String idSale){
        node b = top;
        node toDelete = null;
        while(b != null){
            if (b.idSale.equals(idSale)) {
                toDelete = b;
                break;
            }
            b = b.next;
        }
        System.out.println("top1" + top);
       
        if (toDelete != null) {
            node bef = getBefore(toDelete);
            
            if (toDelete == top) {
                if (toDelete.next == null) {
                    top = null;
                    System.out.println("top after deleted" + top);
                }else{
                    top = toDelete.next;
                    toDelete.next = null;
                    toDelete = null;
                }
            }else if(toDelete.next == null){
                bef.next = null;
                toDelete = null;
            }else{
                bef.next = toDelete.next;
                toDelete.next = null;
                toDelete = null;
            }
        }
        System.out.println("top after after deleted" + top);
        overWriteFile();
        
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
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
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
