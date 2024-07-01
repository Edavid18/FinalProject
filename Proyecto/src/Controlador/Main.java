/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import Date.fecha;
import ShoppingCart.ShoppingCart;
import static VistaControlador.LogInController.list;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 *
 * @author milof
 */

public class Main extends Application{

    /**
     * @param args the command line arguments
     */
    public void start(Stage primaryStage) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/Vista/LogIn.fxml"));
            Pane ventana = (Pane) loader.load();
            
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            fecha date = new fecha();
            date.changeMonth();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
