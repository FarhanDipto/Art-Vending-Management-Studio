/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author This Pc
 */
public class tables {
    public static void main(String[] args) {
        try{
            //String userTable =create table users(id int Auto_)
            String adminDetails ="insert into users(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','12345678900','BD','admin','What is favourite pet?','dog','true')";
            
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
}
