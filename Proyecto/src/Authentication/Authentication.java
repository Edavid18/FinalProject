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
                Message("Id already registered.");
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
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/LogIn/users.txt");
            printw = new PrintWriter(file);
            
            boolean newNode = addNewNodeEnd(username, password, phone, name, lastName);
            
            if (newNode) {
                node p = cab;

                do{
                    printw.println(p.username);
                    printw.println(p.password);
                    p = p.after;
                }while(p!=cab);

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
    
    public void overWriteFile(){
        FileWriter file = null;
        PrintWriter printw = null;
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/LogIn/users.txt");
            printw = new PrintWriter(file);
            
            node p = cab;
            if(p!=null){
                do{
                    printw.println(p.username);
                    printw.println(p.password);
                    p = p.after;
                }while(p!=cab);
            }

                Message("Data deleted in file.");
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
    
    public void LogIn(TextField username, TextField password){
        String user = username.getText();
        String pw = password.getText();
        
        node q = cab;
        if (q != null) {
            do{
                if (user.equals(q.username) && pw.equals(q.password)) {
                    Message("Logged in!");
                    return;
                }
                q = q.after;
            }while(q!=cab);
            Message("The user does not seem to exist.");
        }else{
            Message("There is no user registered.");
        }
    }
    
    public void getInfoFile(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/LogIn/users.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr); //makes fr readable, it sort of translates it.
            
            String linea;
            int i=0;
            node q = new node();
            while ((linea = br.readLine()) != null) {
                    switch(i) {
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
