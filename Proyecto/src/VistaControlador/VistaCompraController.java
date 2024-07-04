/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package VistaControlador;

import static Controlador.Main.Shoplist;
import static Controlador.Main.wish;
import ShoppingCart.ShoppingCart;
import static VistaControlador.LogInController.list;
import WishList.wishList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author milof
 */
public class VistaCompraController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Pane panelinfo;
    @FXML
    private Label Nameproduct;
    @FXML
    private Label price;
    
    public String id;
    @FXML
    private ImageView image;
    @FXML
    private ComboBox<String> amount;
    
    
    @FXML
    private Button wishListButton;
    @FXML
    private Label aded;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        // TODO
        amount.getItems().addAll("1", "2", "3", "4", "5");
        amount.setValue("1");
        
      }  
    
    public void VistaGen(String name, double precio,String id, String ruta){
      String valor = String.valueOf(precio);
      Nameproduct.setText(name);
      
      price.setText(valor);
      this.id=id;
      
      Image imagen = new Image(ruta);
      image.setImage(imagen);
      
      
    }
    
    public void cambiar(String name, double precio,String id,String ruta){
    try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaCompra.fxml"));
        Parent root = loader.load();
        VistaCompraController controlador = loader.getController();
       
        controlador.VistaGen(name,precio,id,ruta);
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
        
        }
        catch(IOException ex){
            System.out.println(ex);
        }
}

    @FXML
    private void addToCart(ActionEvent event) {
        Shoplist.registerInFile(id, list.userLoggedIn, amount.getValue());
        aded.setText("New Item Added to Cart");
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(1),ae-> aded.setText("")));
        time.play();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Timeline cierre = new Timeline(new KeyFrame(Duration.seconds(1),ae->stage.close()));
        cierre.play();
    }

    @FXML
    private void addToWishList(ActionEvent event) {
        wish.registerInFile(id, list.userLoggedIn, amount.getValue());
        aded.setText("New Item Added to WishList");
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(1),ae-> aded.setText("")));
        time.play();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Timeline cierre = new Timeline(new KeyFrame(Duration.seconds(1),ae->stage.close()));
        cierre.play();
    }

    private void buy(ActionEvent event) {
        Shoplist.registerOneItemInFile(id, list.userLoggedIn, amount.getValue());
    }
    

    
    
}
