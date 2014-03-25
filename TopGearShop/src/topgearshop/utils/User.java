/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package topgearshop.utils;

/**
 *
 * @author klkita
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    
    public User(String f, String l, String e, String p){
        this.firstName = f;
        this.lastName = l;
        this.email = e;
        this.phone = p;
    }
    
}
