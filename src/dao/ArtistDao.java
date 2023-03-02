/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Artist;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ArtistDao {
    public static void save(Artist artist){
        String query = "insert into Artist(artist_name,category,art_name) values('"+artist.getArtist_name()+"', '"+artist.getCategory()+"', '"+artist.getArt_name()+"')";
        DbOperations.setDataorDelete(query,"artist added successfully");
    }
    
     public static ArrayList<Artist> getAllRecords(){
       ArrayList<Artist> arrayList = new ArrayList<>();
       
       try{
           ResultSet rs = DbOperations.getData("select *from Artist");
           while(rs.next()){
               Artist artist = new Artist();
               artist.setId(rs.getInt("id"));
               artist.setArtist_name(rs.getString("artist_name"));
               artist.setCategory(rs.getString("category"));
               artist.setArt_name(rs.getString("art_name"));
               arrayList.add(artist);
           }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
       
       return arrayList;
    }
      public static void update(Artist artist){
         String query = "update artwork set name ='"+artist.getArtist_name()+"',category='"+artist.getCategory()+"',price='"+artist.getArt_name()+"' where id = '"+artist.getId()+"'";
         DbOperations.setDataorDelete(query,"Artwork update successfully`");
     }   
     
     public static void delete(String id){
         String query = "delete from artwork where id = '"+id+"'";
         DbOperations.setDataorDelete(query,"artwork deleted successfully");
     }
        
    
}
