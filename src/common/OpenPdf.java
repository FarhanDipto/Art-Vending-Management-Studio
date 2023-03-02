/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import javax.swing.JOptionPane;
import java.io.File;
/**
 *
 * @author This Pc
 */
public class OpenPdf {
    public static void  openById(String id){
        try{
          if((new File("E:\\"+id+".pdf")).exists()){
              Process p= Runtime
                      .getRuntime().exec("rundll32 url.dll,FileProtocolhandler E:\\"+id+".pdf");
          }
          else
             JOptionPane.showMessageDialog(null, "File does not exist"); 
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
    
    
}
