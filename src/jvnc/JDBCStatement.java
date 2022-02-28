/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jvnc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class JDBCStatement {
    public static void main(String[] args)throws SQLException {
        try {
            Connection con=ConnectionJDBC.getJDBCConnection();
            Statement statement= con.createStatement();
            String sql="SELECT * FROM TEST";
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next())
            {
                System.out.println(rs.getString("Id"));//Field Name
                System.out.println(rs.getString("ten"));//Field Name
                System.out.println(rs.getString("Phone"));//Field Name
                System.out.println(rs.getString("UserName"));//Field Name
                System.out.println(rs.getString("Passwordd"));//Field Name
                System.out.println(rs.getString("About"));//Field Name
                System.out.println(rs.getString("Roles"));//Field Name
                System.out.println(rs.getString("Favourites"));//Field Name
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
