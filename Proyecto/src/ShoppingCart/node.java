/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingCart;

/**
 *
 * @author eliasvidal
 */
public class node {
    
    public String idSale;
    public String idProd;
    public String idUser;
    public String date;
    public node next;
    
    public node(String ids, String idp, String idu, String d){
        idSale = ids;
        idProd = idp;
        idUser = idu;
        date = d;
        next = null;
    }
    
    public node(){
        idSale = "";
        idProd = "";
        idUser = "";
        date = "";
        next = null;
    }
    
}
