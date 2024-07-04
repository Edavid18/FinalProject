/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingCart;

import static Controlador.Main.Shoplist;
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
    
    public node getLast(){
        node b = top;
        while(b!=null){
            if (b.after == null) {
                return b;
            }
            b = b.after;
        }
        return null;
    }
    
    
    public void print(){
        node b = top;
        while(b!=null){
            System.out.println(b.idSale);
            b = b.after;
        }
    }
    
    public node getBefore(node q){
        node b = top;
        while(b != null){
            if (b.after == q) {
                return b;
            }
            b = b.after;
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
                p = p.after;
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
            q.after = top;
            top.before = q;
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
                    q.after = top;
                    top.before = q;
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
    
    public double getSubTotal(){
        node b = top;
        double total = 0;
        while (b != null) {
                if (prodExists(b.idProd) != null) {
                    if (b.idUser.equals(list.userLoggedIn)) {
                        Product prod = prodExists(b.idProd);
                        double price = Double.parseDouble(prod.price);
                        total = total + price;
                    }
                }
                b = b.after;
            }
        return total;
    }
    
    public double getTotal(String desc){
        if (desc.equals("Ruben")) {
            double subTot = getSubTotal();
            double off = subTot * 0.4;
            double tot = subTot-off;
            
            return tot;
        }else{
            return getSubTotal();
        }
    }
    
    public boolean addDesc(String desc){
        if (getSubTotal() > getTotal(desc)) {
            return true;
        }else{
            return false;
        }
    }
    
    public void registerInFile(String idProd, String idUser, String amount) {
        FileWriter file = null;
        PrintWriter printw = null;
        
        try {
            file = new FileWriter("/D:/FinalProject/Proyecto/src/ShoppingCart/shoppingList.txt");
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
                    p = p.after;
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
            file = new FileWriter("/D:/FinalProject/Proyecto/src/ShoppingCart/buyItem.txt");
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
            file = new FileWriter("/D:/FinalProject/Proyecto/src/ShoppingCart/shoppingList.txt");
            printw = new PrintWriter(file);
            
            node p = top;
            while(p!=null){
                printw.println(p.idSale);
                printw.println(p.idUser);
                printw.println(p.idProd);
                printw.println(p.date);
                printw.println(p.amount);
                p = p.after;
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
            b = b.after;
        }
        System.out.println("top1" + top);
       
        if (toDelete != null) {
            node bef = getBefore(toDelete);
            
            if (toDelete == top) {
                if (toDelete.after == null) {
                    top = null;
                    System.out.println("top after deleted" + top);
                }else{
                    top = toDelete.after;
                    toDelete.after = null;
                    top.before = null;
                    toDelete = null;
                }
            }else if(toDelete.after == null){
                toDelete.before.after = null;
                toDelete.before = null;
                toDelete = null;
            }else{
                toDelete.before.after = toDelete.after;
                toDelete.after.before = toDelete.before;
                toDelete.after = null;
                toDelete.before = null;
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
            archivo = new File("/D:/FinalProject/Proyecto/src/ShoppingCart/shoppingList.txt");
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
            file = new FileWriter("/D:/FinalProject/Proyecto/src/ShoppingCart/idSale.txt");
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
            archivo = new File("/D:/FinalProject/Proyecto/src/ShoppingCart/idSale.txt");
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
