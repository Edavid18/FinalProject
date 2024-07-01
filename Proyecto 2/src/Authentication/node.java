/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Authentication;

/**
 *
 * @author eliasvidal
 */
public class node {
    String username;
    String password;
    String phone;
    String name;
    String lastName;
    node after;
    node before;
    
    public node(String u, String p, String ph, String n, String l){
        username = u;
        password = p;
        phone = ph;
        name = n;
        lastName = l;
        after = null;
        before = null;
    }
    
    public node(){
        username = "";
        password = "";
        phone = "";
        name = "";
        lastName = "";
        after = null;
        before = null;
    }
}
