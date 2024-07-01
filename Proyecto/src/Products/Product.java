/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Products;

import java.awt.Image;

/**
 *
 * @author eliasvidal
 */
public class Product {
    
    public String name;
    public String price;
    public String image;
    public String description;
    public String stock;
    public String id;

    public Product(String name, String price, String image, String description, String category, String stock, String id) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.stock = stock;
        this.id = id;
    }
    
    public Product(){
        this.name = "";
        this.price = "";
        this.image = "";
        this.description = "";
        this.stock = "";
        this.id = "";
    }
    
}
