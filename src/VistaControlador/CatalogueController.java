/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private void Cana1(MouseEvent event) {
        obj.cambiar("Sexo",100,"10001","/images/canas1/shimano-ocea-plugger.jpg",rootpane);
    }
    
}
