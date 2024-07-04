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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author milof
 */
public class BoatsController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    @FXML
    private ScrollPane RootPanel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    VistaCompraController obj = new VistaCompraController();

    @FXML
    private void FS1800(MouseEvent event) {
        obj.cambiar("FS 1800", 43500, "6008", "/images/botes2/LW_fs1800.png");
    }

    @FXML
    private void LWBay(MouseEvent event) {
        obj.cambiar("LW Bay 22", 33500, "6009", "/images/botes2/LW_bay22.png");
    }

    @FXML
    private void VW1670(MouseEvent event) {
        obj.cambiar("VW 1670", 60000, "6003", "/images/botes2/WV1670.png");
    }

    @FXML
    private void Roughneck2070(MouseEvent event) {
        obj.cambiar("Roughneck 2070", 27000, "6005", "/images/botes2/Roughneck2070.png");

    }

    @FXML
    private void lbrs270(MouseEvent event) {
        obj.cambiar("LB RS270 red", 73000, "6015", "/images/botes2/lb-rs27.png");

    }

    @FXML
    private void sf232(MouseEvent event) {
        obj.cambiar("SF 232", 74000, "600", "/images/botes2/SF-232.png");

    }

    @FXML
    private void rs270(MouseEvent event) {
        obj.cambiar("RS 270 Blue", 74600, "6014", "/images/botes/lb-rs27ew.png");
    }

    @FXML
    private void Mt1885(MouseEvent event) {
        obj.cambiar("MT 1885", 43000, "6013", "/images/botes2/Mt 1885.png");

    }

    @FXML
    private void lb115(MouseEvent event) {
        obj.cambiar("LB 115", 48000, "6007", "/images/botes2/lb-115.png");
    }

    @FXML
    private void Stringer198(MouseEvent event) {
        obj.cambiar("Stringer198", 45000, "6001", "/images/botes/Stinger-198-Metallic-Blue.png");
    }

    @FXML
    private void Fishingmachine(MouseEvent event) {
        obj.cambiar("Fishing Macihe", 35000, "6002", "/images/botes/fishingmachine.png");
    }

    @FXML
    private void thevw1670(MouseEvent event) {
        obj.cambiar("The VW", 60000, "6003", "/images/botes/lb-wv1670.png");
    }

    @FXML
    private void lblegacy(MouseEvent event) {
        obj.cambiar("LB Legacy", 22325, "6004", "/images/botes/lb-legacy.png");
    }

    @FXML
    private void rougneck2070(MouseEvent event) {
        obj.cambiar("Roughneck 2070", 27000, "6005", "/images/botes/lb-roughneck-2070.png");
    }

    @FXML
    private void fishandsly(MouseEvent event) {
        obj.cambiar("Fish and Sky", 50000, "6006", "/images/botes/lb-fs1900.png");
    }

    @FXML
    private void sd224(MouseEvent event) {
        obj.cambiar("SD 224 Ultra", 75800, "6020", "/images/botes2/SD224.png");
    }

    @FXML
    private void mercury(MouseEvent event) {
        obj.cambiar("Mercury Avator 7.5",3499.99,"5001","/images/canas1/mercury.jpg");

    }

    @FXML
    private void login(ActionEvent event) {
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

    @FXML
    private void carro(MouseEvent event) {
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
    private void deseo(MouseEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/WishList.fxml"));
        Parent root = loader.load();
        WishListController controlador = loader.getController();
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
