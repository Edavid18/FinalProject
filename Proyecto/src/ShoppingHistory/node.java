/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingHistory;

/**
 *
 * @author eliasvidal
 */
public class node {
    
    public String idSale;
    public String idProd;
    public String idUser;
    public String date;
    public String amount;
    public node next;
    
    public node(String ids, String idp, String idu, String d, String amount){
        idSale = ids;
        idProd = idp;
        idUser = idu;
        date = d;
        this.amount = amount;
        next = null;
    }
    
    public node(){
        idSale = "";
        idProd = "";
        idUser = "";
        date = "";
        amount = "";
        next = null;
    }
    
}
