/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WishList;

import Date.fecha;
import Products.ListProd;
import Products.Product;
import static VistaControlador.LogInController.list;
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
public class wishList {
    
    public wishList(){
        getInfoFile();
        getInfoWish();
    }
    
    node top;
    String idWish;
    
    public void Message(String message){
            System.out.println(message);
    }
    
    public node getTopList(){
        return top;
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
    
    public void print(){
        node b = top;
        while(b!=null){
            System.out.println(b);
            b = b.next;
        }
    }
    
    public node searchWishAdded(String idProd, String idUser){
        node b = top;
        while(b!=null){
            if (idProd.equals(b.idProd) && (idUser.equals(b.idUser))) {
                return b;
            }
            b = b.next;
        }
        return null;
    }
    
    public node searchWish(String idwish){
        if(top==null)
            return null;
        else{
            node p = top;
            while(p!=null){
                if (p.idWish.equals(idwish)) {
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
    
    public node createNode(String idProd, String idUser, String amount){
        node p = searchWish(idWish);
        
        try {
            if (p != null) {
                Message("Sale already registered.");
                return null;
            } else {
                node q = new node(idProd, idUser, amount, idWish);
                changeIdWish();
                getInfoWish();
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
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/WishList/wishList.txt");
            printw = new PrintWriter(file);
            
            node s = searchWishAdded(idProd, idUser);
            
            
            if (s == null) {
                
                boolean newNode = addNewNodeEnd(idProd, idUser, amount);
                
                
            }else{
                Message("No new data saved.");
            }
            
            node p = top;

            while(p!=null){
                printw.println(p.idWish);
                printw.println(p.idProd);
                printw.println(p.idUser);
                printw.println(p.amount);
                p = p.next;
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
    
    public void deleteProduct(String idWish){
        node b = top;
        node toDelete = null;
        while(b != null){
            if (b.idWish.equals(idWish)) {
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
    
    public void overWriteFile(){
        FileWriter file = null;
        PrintWriter printw = null;
        
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/WishList/wishList.txt");
            printw = new PrintWriter(file);
            
            node p = top;
            while(p!=null){
                printw.println(p.idWish);
                printw.println(p.idProd);
                printw.println(p.idUser);
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
    
    public void getInfoFile(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/WishList/wishList.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr); //makes fr readable, it sort of translates it.
            
            String linea;
            int i=0;
            node sale = new node();
            while ((linea = br.readLine()) != null) {
                    switch(i){
                    case 0:
                        sale.idWish = linea.trim();
                        i++;
                        break;
                        
                    case 1:
                        sale.idProd = linea.trim();
                        i++;
                        break;
                        
                    case 2:
                        sale.idUser = linea.trim();
                        i++;
                        break;
                        
                    case 3:
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
    
    public void changeIdWish(){
        FileWriter file = null;
        PrintWriter printw = null;
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/WishList/idWish.txt");
            printw = new PrintWriter(file);
            
            int inIdWish = Integer.parseInt(idWish);
            int tempIdWish = inIdWish + 1;
            String newIdWish = String.valueOf(tempIdWish);
            
            printw.println(newIdWish);
            
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
    
    public void getInfoWish(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/WishList/idWish.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr); //makes fr readable, it sort of translates it.
            
            String linea;
            while ((linea = br.readLine()) != null) {
                idWish = linea.trim();
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
    