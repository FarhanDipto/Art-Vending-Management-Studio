/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.User;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author This Pc
 */
public class UserDao {
    public static void save(User user){
        String query = "insert into users(name,email,mobileNumber,address,password,securityquestion,answer,status)values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        DbOperations.setDataorDelete(query, "Registered Successfully. Wait for Admin Approval");
    }
    
    
     public static User login(String email,String password){
        User user = null;
        try{
            ResultSet rs= DbOperations.getData("select *from users where email='"+email+"' and password='"+password+"'");
            while (rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }
               
            
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
                    
                    }
        return user;
    }
     
     public static User getSEcurityQuestion(String email){
         User user = null;
         
         try {
             ResultSet rs = DbOperations.getData("Select *from users  where email = '"+email+ "'");
             while(rs.next()){
                 user = new User();
                 user.setSecurityQuestion(rs.getString("securityQuestion"));
                 user.setAnswer(rs.getString("answer"));
             }
         }
         
         catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
         return user;
     }
     
     public static void update(String email, String newPassword) {
        String query = "update users set password = '" + newPassword + "' where email='" + email + "'";
        DbOperations.setDataorDelete(query,"Password Change Successfully");
    }
      public static ArrayList<User> getAllRecords(String email){
         ArrayList<User> arrayList = new ArrayList<>();
         try{
             ResultSet rs = DbOperations.getData("select *from users where email like '%"+email+"%'");
             while(rs.next()){
                 User user = new User();
                 user.setId(rs.getInt("id"));
                 user.setName(rs.getString("name"));
                 user.setEmail(rs.getString("email"));
                 user.setMobileNumber(rs.getString("mobileNumber"));
                 user.setAddress(rs.getString("address"));
                 user.setSecurityQuestion(rs.getString("securityquestion"));
                 user.setStatus(rs.getString("status"));
                 arrayList.add(user);
             }
              
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return arrayList;
     }
     public static void changeStatus(String email, String status){
         String query = "update users set status='"+status+"' where email ='"+email+"'";
         DbOperations.setDataorDelete(query, "Status changed successfully");
         
     }
     
}
