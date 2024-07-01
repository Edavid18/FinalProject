/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Authentication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author eliasvidal
 */
public class Authentication {

    node cab;
    
    public String userLoggedIn;
    
    public Authentication(){
        getInfoFile();
    }
    
    public void Message(String mes) {
        System.out.println(mes);
    }
    
     public node searchUser(String user){
        if(cab==null)
            return null;
        else{
            node p=cab;
            do{
                if (p.username.equals(user)) {
                    return p;
                }
                p = p.after;
            }while(p!=cab);
            return null;
        }
    }

    
    public node createNode(String user, String pw, String ph, String name, String lname){
        
        node p = searchUser(user);
        
        try {
            if (p != null) {
                Message("Email already registered.");
                return null;
            } else {
                node q = new node(user, pw, ph, name, lname);
                return q;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean addNewNodeEnd(TextField username, TextField password, TextField phone, TextField name, TextField lastName){
        String user = username.getText();
        String pw = password.getText();
        String ph = phone.getText();
        String nm = name.getText();
        String lnm = lastName.getText();
        
        node q = createNode(user, pw, ph, nm, lnm);
        
        if (q != null) {
            if (cab == null) {
                cab = q;
                q.after = cab;
                q.before = cab;
                Message("Element registered. List was empty");
                return true;
            } else {
                node l = cab.before;
                l.after = q;
                q.before = l;
                q.after = cab;
                cab.before = q;
                return true;
            }
        }
        return false;
        
    }
    
    public void addNodeEnd(node q){   
        if(cab==null){
            cab=q;            
            q.after = cab;
            q.before = cab;
            Message("Cab era null, ahora es lo que estaba de primero en el archivo");
        }else{
            node l = cab.before;
            l.after = q;
            q.before = l;
            q.after = cab;
            cab.before = q;
        }
    }

    public void registerInFile(TextField username, TextField password, TextField phone, TextField name, TextField lastName) {
        FileWriter file = null;
        PrintWriter printw = null;
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/Authentication/users.txt");
            printw = new PrintWriter(file);
            
            boolean newNode = addNewNodeEnd(username, password, phone, name, lastName);
            System.out.println("in register in file");
            PrintList();
            
            if (newNode) {
                node p = cab;

                do{
                    printw.println(p.username);
                    printw.println(p.password);
                    printw.println(p.phone);
                    printw.println(p.name);
                    printw.println(p.lastName);
                    p = p.after;
                }while(p!=cab);
                
                System.out.println("after writing on file");
                PrintList();

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
    
    public void PrintList(){
        node x = cab;
        do {
            System.out.println(x.username);
            x = x.after;
        } while (x!=cab);
    }
    
    public void overWriteFile(){
        FileWriter file = null;
        PrintWriter printw = null;
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/Authentication/users.txt");
            printw = new PrintWriter(file);
            
            
            node p = cab;
            if(p!=null){
                do{
                    printw.println(p.username);
                    printw.println(p.password);
                    printw.println(p.phone);
                    printw.println(p.name);
                    printw.println(p.lastName);
                    p = p.after;
                }while(p!=cab);
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
    
    public boolean LogIn(TextField username, TextField password){
        String user = username.getText();
        String pw = password.getText();
        
        System.out.println("in login");
        PrintList();
        
        node q = cab;
        if (q != null) {
            do{
                if (user.equals(q.username) && pw.equals(q.password)) {
                    Message("Logged in!");
                    userLoggedIn = user;
                    return true;
                }else if (user.equals(q.username) && !(pw.equals(q.password))){
                    Message("The password is incorrect");
                    return false;
                }
                q = q.after;
            }while(q!=cab);
            Message("The user does not seem to exist.");
            return false;
        }else{
            Message("There is no user registered.");
            return false;
        }
    }
    
    public void getInfoFile(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/Authentication/users.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr); //makes fr readable, it sort of translates it.
            
            String linea;
            int i=0;
            node q = new node();
            while ((linea = br.readLine()) != null) {
                    switch(i){
                    case 0:
                        node b = searchUser(linea.trim());
                        if (b == null) {
                            q.username = linea.trim();
                            i++;
                            break;
                        }else{
                            Message("one or more ID's in the text file already exist!");
                            return;
                        }
                    case 1:
                        q.password = linea.trim();
                        i++;
                        break;
                    
                    case 2:
                        q.phone = linea.trim();
                        i++;
                        break;
                    
                    case 3:
                        q.name = linea.trim();
                        i++;
                        break;
                    
                    case 4:
                        q.lastName = linea.trim();
                        addNodeEnd(q);
                        q = new node();
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
    
}
