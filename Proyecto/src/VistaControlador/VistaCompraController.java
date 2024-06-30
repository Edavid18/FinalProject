/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 *
 * @author milof
 */
public class VistaCompraController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Pane panelinfo;
    @FXML
    private Label Nameproduct;
    @FXML
    private Label price;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        // TODO
        
        
      }  
    
    public void VistaGen(String name, double precio){
      String valor = String.valueOf(precio);
      Nameproduct.setText(name);
      price.setText(valor);
      
    }
    
    
}
