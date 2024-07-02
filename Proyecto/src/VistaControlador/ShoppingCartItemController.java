/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import static Controlador.Main.Shoplist;
import Products.Product;
import ShoppingCart.node;
import static VistaControlador.LogInController.list;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eliasvidal
 */
public class ShoppingCartItemController implements Initializable {

    @FXML
    private ImageView imgSrc;
    @FXML
    private Label ProdName;
    @FXML
    private Label price;
    @FXML
    private Label desc;

    public String id;
    
    private ShoppingCartController shoppingCartController;
    
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

        this.id = id;
    }
    
    public void setShoppingCartController(ShoppingCartController shoppingCartController) {  // Add this method
        this.shoppingCartController = shoppingCartController;
    }

    @FXML
    private void delete(ActionEvent event) {
        Shoplist.deleteProduct(id);
        shoppingCartController.refreshItems();
    }
    
}
