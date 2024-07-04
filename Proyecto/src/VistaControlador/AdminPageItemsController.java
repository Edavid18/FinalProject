/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author eliasvidal
 */
public class AdminPageItemsController implements Initializable {

    @FXML
    private ImageView imgSrc;
    @FXML
    private Label ProdName;
    @FXML
    private Label price;
    @FXML
    private Label desc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void changeLabels(String productName, String price, String description, String route, String id){
        ProdName.setText(productName);
        this.price.setText(price);
        desc.setText(description);

        Image imagen = new Image(route);
        imgSrc.setImage(imagen);
    }
}
