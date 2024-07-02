/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Products;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author eliasvidal
 */
public class ListProd {
    
    public ListProd(){
        getInfoFile();
    }
    
    public ArrayList<Product> listProd = new ArrayList<>();
    
    public void Message(String message){
        System.out.println(message);
    }
    
    public void Print(){
        for (int i = 0; i < listProd.size(); i++) {
            System.out.println(listProd.get(i));
        }
    }
    
    public boolean searchProd(String id){
        for (int i = 0; i < listProd.size(); i++) {
            if (listProd.get(i).id.equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public void getInfoFile(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("/Users/eliasvidal/Documents/GitHub/FinalProject/Proyecto/src/Products/products.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr); //makes fr readable, it sort of translates it.
            
            String linea;
            int i=0;
            Product prod = new Product();
            while ((linea = br.readLine()) != null) {
                    switch(i){
                    case 0:
                        boolean found = searchProd(linea.trim());
                        if (!found) {
                            prod.id = linea.trim();
                            i++;
                            break;
                        }else{
                            Message("one or more ID's in the text file already exist!");
                            return;
                        }
                    case 1:
                        prod.name = linea;
                        i++;
                        break;
                    
                    case 2:
                        prod.price = linea.trim();
                        i++;
                        break;
                        
                    case 3:
                        prod.image = linea.trim();
                        i++;
                        break;
                    
                    case 4:
                        prod.amount = linea.trim();
                        listProd.add(prod);
                        prod = new Product();
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
