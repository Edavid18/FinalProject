/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import Controlador.Main;
import Date.fecha;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EVER
 */
public class CatalogueController implements Initializable {

    @FXML
    private ScrollPane RootPanel;
    @FXML
    private AnchorPane rootpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    // FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaCompra.fxml"));
     VistaCompraController obj = new VistaCompraController();
     
    @FXML
    private void goToShoppingCart(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ShoppingCart.fxml"));
        Parent root = loader.load();
        ShoppingCartController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
       // stage.initModality(Modality.APPLICATION_MODAL); sirve para no salir hasta terminar el programa
        stage.setScene(scene);
        
        stage.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        }
        catch(IOException ex){
           
        }
    }
    
    @FXML
    private void Cana1(MouseEvent event) {
        obj.cambiar("Sexo",100,"1001","/images/canas1/shimano-ocea-plugger.jpg");
    }

    @FXML
    private void Cana2(MouseEvent event) {
        obj.cambiar("Sexo2",300,"1002","/images/canas1/shimano-ocea-plugger.jpg");
    }

    @FXML
    private void goToLogIn(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/LogIn.fxml"));
        Parent root = loader.load();
        LogInController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
       // stage.initModality(Modality.APPLICATION_MODAL); sirve para no salir hasta terminar el programa
        stage.setScene(scene);
        
        stage.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        }
        catch(IOException ex){
           
        }
    }
    
}
