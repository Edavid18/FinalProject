/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WishList;

/**
 *
 * @author eliasvidal
 */
public class node {
    
    public String idProd;
    public String idUser;
    public String amount;
    public String idWish;
    public node next;
    
    public node(String idp, String idu, String amount, String idw){
        idProd = idp;
        idUser = idu;
        this.amount = amount;
        idWish = idw;
        next = null;
    }
    
    public node(){
        idProd = "";
        idUser = "";
        amount = "";
        idWish = "";
        next = null;
    }
    
}
