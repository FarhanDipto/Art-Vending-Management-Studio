/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author This Pc
 */
public class ConnectionProvider {
    public static Connection con;

    public static Connection getCon() {

        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=123456;databaseName=Art_management";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            if (con != null) {
                System.out.println("Connected");
                return con;

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
