/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import static Controlador.Main.Shoplist;
import Products.Product;
import ShoppingCart.ShoppingCart;
import ShoppingCart.node;
import static VistaControlador.LogInController.list;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eliasvidal
 */
public class ShoppingCartController implements Initializable {

    @FXML
    private VBox itemsPane;
    
    private ArrayList<AnchorPane> shoppingCartItems = new ArrayList<>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadItems();
    }
    
    private void loadItems() {
        try {
            itemsPane.getChildren().clear();
            //shoppingCartItems.clear();
            node b = Shoplist.getTopList();

            while (b != null) {
                if (Shoplist.prodExists(b.idProd) != null) {
                    if (b.idUser.equals(list.userLoggedIn)) {
                        Product prod = Shoplist.prodExists(b.idProd);
                        addItem(prod.name, prod.price, b.amount, prod.image, b.idSale);
                    }
                }
                b = b.after;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void addItem(String name, String price, String desc, String route, String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ShoppingCartItem.fxml"));
        AnchorPane shoppingCartItem = loader.load();
        
        ShoppingCartItemController controller = loader.getController();
        controller.changeLabels(name, price, desc, route, id);
        controller.setShoppingCartController(this);

        itemsPane.getChildren().add(shoppingCartItem);
    }
    
    public void refreshItems() {
        loadItems();
    }

    @FXML
    private void goBackToCatalogue(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Catalogue.fxml"));
        Parent root = loader.load();
        CatalogueController controlador = loader.getController();
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
    private void goToCheckout(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/checkout.fxml"));
        Parent root = loader.load();
        CheckoutController controlador = loader.getController();
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
