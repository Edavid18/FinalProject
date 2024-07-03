/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import static Controlador.Main.history;
import Products.Product;
import ShoppingHistory.node;
import static VistaControlador.LogInController.list;
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
public class ShoppingHistoryController implements Initializable {

    @FXML
    private VBox itemsPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            itemsPane.getChildren().clear();
            //shoppingCartItems.clear();
            node b = history.getTopList();

            while (b != null) {
                if (history.prodExists(b.idProd) != null) {
                    if (b.idUser.equals(list.userLoggedIn)) {
                        Product prod = history.prodExists(b.idProd);
                        addItem(prod.name, prod.price, b.amount, prod.image, b.idSale);
                    }
                }
                b = b.next;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
    private void addItem(String name, String price, String desc, String route, String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/adminPageItems.fxml"));
        AnchorPane shoppingCartItem = loader.load();
        
        AdminPageItemsController controller = loader.getController();
        controller.changeLabels(name, price, desc, route, id);

        /*if (itemsPane.getChildren().isEmpty()) {
            itemsPane.getChildren().add(shoppingCartItem); // If empty, just add the item
        }else {
            itemsPane.getChildren().add(itemsPane.getChildren().size() - 1, shoppingCartItem); // Adds above the last item
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
        
        }
        catch(IOException ex){
           
        }
    }
    
}
