/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import static Controlador.Main.Shoplist;
import static Controlador.Main.wish;
import static VistaControlador.LogInController.list;
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
public class WishListItemController implements Initializable {

    @FXML
    private Label ProdName;
    @FXML
    private Label price;
    @FXML
    private Label desc;
    @FXML
    private ImageView image;
    
    public String amount;
    public String id;
    public String idp;
    
    private WishListController wishListController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void changeLabels(String productName, String price, String amount, String route, String id, String idp){
      ProdName.setText(productName);
      this.price.setText(price);
      desc.setText(amount);
      
      this.amount = amount;
      this.id = id;
      this.idp = idp;
      
      Image imagen = new Image(route);
      image.setImage(imagen);
    }
    
    public void setWishListController(WishListController wishListController) {  // Add this method
        this.wishListController = wishListController;
    }

    @FXML
    private void addToCart(ActionEvent event) {
        Shoplist.registerInFile(idp, list.userLoggedIn, amount);
        wish.deleteProduct(id);
        wishListController.refreshItems();
    }

    @FXML
    private void delete(ActionEvent event) {
        wish.deleteProduct(id);
        wishListController.refreshItems();
    }
    
}
