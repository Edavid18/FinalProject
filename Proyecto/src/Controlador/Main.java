/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import VistaControlador.VistaCompraController;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

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
            loader.setLocation(Main.class.getResource("/Vista/VistaCompra.fxml"));
            Pane ventana = (Pane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            Stage stage = new Stage();
            VistaControlador.VistaCompraController ins = loader.getController();
            ins.VistaGen("Caña", 1000);
             
             
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
         //pedirValoresYImprimir();
    }
   
   public static void pedirValoresYImprimir() {
        // Array para almacenar los 5 valores
        String[] valores = new String[5];
        
        // Bucle para pedir los 5 valores
        for (int i = 0; i < 5; i++) {
            valores[i] = JOptionPane.showInputDialog(null, "Introduce el valor " + (i + 1) + ":");
        }
        
        // Imprimir los valores en la consola
        System.out.println("Los valores introducidos son:");
        for (String valor : valores) {
            System.out.println(valor);
        }

    
}
   
   
   
}