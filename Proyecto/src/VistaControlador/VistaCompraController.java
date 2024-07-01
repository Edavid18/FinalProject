/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.ImageView;

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
    @FXML
    private Button buy;
    
    public String id;
    @FXML
    private ImageView image;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        // TODO
        
        
      }  
    
    public void VistaGen(String name, double precio,String id, String ruta){
      String valor = String.valueOf(precio);
      Nameproduct.setText(name);
      
      price.setText(valor);
      
      Image imagen = new Image(ruta);
      image.setImage(imagen);
      
      
    }
    
    public void cambiar(String name, double precio,String id,String ruta){
    try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaCompra.fxml"));
        Parent root = loader.load();
        VistaCompraController controlador = loader.getController();
        this.id=id;
        
       
        controlador.VistaGen(name,precio,id,ruta);
        
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
        
        
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    
    
    
}
    

    
    
}
