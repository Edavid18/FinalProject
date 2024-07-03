/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import Products.ListProd;
import Products.Product;
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
public class AdminPageController implements Initializable {

    @FXML
    private VBox itemsPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        ListProd prod = new ListProd();
        
        for (int i = 0; i < prod.listProd.size(); i++) {
            addItem(prod.listProd.get(i).name, prod.listProd.get(i).price, 
                    prod.listProd.get(i).amount, prod.listProd.get(i).image,
                    prod.listProd.get(i).id);
            System.out.println(prod.listProd.get(i).id);
        }
        }catch(Exception E){
        }
        
    }    
    
    private void addItem(String name, String price, String desc, String route, String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/adminPageItems.fxml"));
        AnchorPane is = loader.load();
        
        AdminPageItemsController controller = loader.getController();
        controller.changeLabels(name, price, desc, route, id);

        /*if (itemsPane.getChildren().isEmpty()) {
            itemsPane.getChildren().add(shoppingCartItem); // If empty, just add the item
        }else {
            itemsPane.getChildren().add(itemsPane.getChildren().size() - 1, shoppingCartItem); // Adds above the last item
        }*/ 
        itemsPane.getChildren().add(is);
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
