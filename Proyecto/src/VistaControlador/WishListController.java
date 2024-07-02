/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import static Controlador.Main.wish;
import Products.Product;
import WishList.node;
import static VistaControlador.LogInController.list;
import WishList.wishList;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eliasvidal
 */
public class WishListController implements Initializable {

    @FXML
    private VBox itemsPane;

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
            node b = wish.getTopList();

            while (b != null) {
                if (wish.prodExists(b.idProd) != null) {
                    if (b.idUser.equals(list.userLoggedIn)) {
                        Product prod = wish.prodExists(b.idProd);
                        addItem(prod.name, prod.price, b.amount, prod.image, b.idWish, b.idProd);
                    }
                }
                b = b.next;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void refreshItems() {
        loadItems();
    }
    
    private void addItem(String name, String price, String amount, String route, String id, String idp) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/WishListItem.fxml"));
        AnchorPane shoppingCartItem = loader.load();
        
        WishListItemController controller = loader.getController();
        controller.changeLabels(name, price, amount, route, id, idp);
        controller.setWishListController(this);

        /*if (itemsPane.getChildren().isEmpty()) {
            itemsPane.getChildren().add(shoppingCartItem);
        } else {
            itemsPane.getChildren().add(itemsPane.getChildren().size() - 1, shoppingCartItem);
        }*/
        itemsPane.getChildren().add(shoppingCartItem);
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
        
        }catch(IOException ex){
        }
    }
    
}
