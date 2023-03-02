/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Artwork;
/**
 *
 * @author This Pc
 */
public class ArtworkDao {
    public static void save(Artwork artwork){
        String query="insert into artwork(name,category,price)values('"+artwork.getName()+"','"+artwork.getCategory()+"','"+artwork.getPrice()+"')";
   DbOperations.setDataorDelete(query,"Artwork added successfully");
    }
    public static ArrayList<Artwork> getAllRecords(){
       ArrayList<Artwork> arrayList = new ArrayList<>();
       
       try{
           ResultSet rs = DbOperations.getData("select *from Artwork");
           while(rs.next()){
               Artwork artwork = new Artwork();
               artwork.setId(rs.getInt("id"));
               artwork.setName(rs.getString("name"));
               artwork.setCategory(rs.getString("category"));
               artwork.setPrice(rs.getString("price"));
               arrayList.add(artwork);
           }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
       
       return arrayList;
    }
   
     public static void update(Artwork artwork){
         String query = "update artwork set name ='"+artwork.getName()+"',category='"+artwork.getCategory()+"',price='"+artwork.getPrice()+"' where id = '"+artwork.getId()+"'";
         DbOperations.setDataorDelete(query,"Artwork update successfully`");
     }   
     
     public static void delete(String id){
         String query = "delete from artwork where id = '"+id+"'";
         DbOperations.setDataorDelete(query,"artwork deleted successfully");
     }
        
     public static ArrayList<Artwork> getAllRecordsByCategory(String category){
         ArrayList<Artwork> arrayList = new ArrayList<>();
         try{
             ResultSet rs = DbOperations.getData("select *from artwork where category='"+category+"'");
             while(rs.next())
             {
                 Artwork artwork = new Artwork();
                 artwork.setName(rs.getString("name"));
                 arrayList.add(artwork);
             }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e);
         }
         return arrayList;
     }
    
     
      public static ArrayList<Artwork> filterArtworkByname(String name,String category){
         ArrayList<Artwork> arrayList = new ArrayList<>();
         try{
             ResultSet rs = DbOperations.getData("select *from artwork where name like='%"+name+"%' and category = '"+category+"'");
             while(rs.next())
             {
                 Artwork artwork = new Artwork();
                 artwork.setName(rs.getString("name"));
                 arrayList.add(artwork);
             }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e);
         }
         return arrayList;
     }
      
      public static Artwork getArtworkByname(String name){
          Artwork artwork = new Artwork();
          try{
              ResultSet rs = DbOperations.getData("select *from artwork where name='"+name+"'"); 
              while(rs.next())
              {
                  artwork.setName(rs.getString(2));
                  artwork.setCategory(rs.getString(3));
                  artwork.setPrice(rs.getString(4));
              }
          }
          catch(Exception e)
          {
             JOptionPane.showMessageDialog(null, e); 
          }
          return artwork;
      }
              
     
}
