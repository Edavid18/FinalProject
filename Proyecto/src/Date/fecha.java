/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Date;

import Authentication.node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author eliasvidal
 */
public class fecha {
    
    public String date;
    
    public fecha(){
        getInfoFile();
    }
    
    public void Message(String message){
        System.out.println(message);
    }
    
    public void changeMonth(){
        System.out.println("Current month: " + date);
        FileWriter file = null;
        PrintWriter printw = null;
        try {
            file = new FileWriter("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/Date/date.txt");
            printw = new PrintWriter(file);
            
            String newDate;
            int intDate = Integer.parseInt(date);
            
            if (intDate == 12) {
                intDate = 1;
            }else{
                intDate = intDate + 1;
            }  
            
            newDate = String.valueOf(intDate);
            printw.println(newDate);
            
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
            archivo = new File("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/Date/date.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr); //makes fr readable, it sort of translates it.
            
            String linea;
            node q = new node();
            while ((linea = br.readLine()) != null) {
                date = linea.trim();
            }
            System.out.println("Datos válidos cargados al archivo fecha");
            
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
