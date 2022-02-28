/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jvnc;

import CONECTCLASS.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author kvan2
 */
public class UserDao {
    public List<User> getALLUsers(){
        List<User> users= new ArrayList<User>();
        Connection connection=ConnectionJDBC.getJDBCConnection();
        String sql="SELECT * FROM Test1";
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("Name"));
                user.setPhone(rs.getString("Phone"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setAbout(rs.getString("About"));
                user.setFauvourites(rs.getString("Fauvourites"));
                user.setRole(rs.getString("Role"));
                
                users.add(user);
            }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return users;
        }
    public void addUser(User user){
        Connection connection = ConnectionJDBC.getJDBCConnection();
        String sql="Insert into Test1(Name,Phone,UserName,Password,About,Role,Fauvourites) VALUES(Name,Password,Phone,UserName,About,Role,Fauvourites)";
        try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           
           preparedStatement.setString(1, user.getName());
           preparedStatement.setString(2, user.getPhone());
           preparedStatement.setString(3, user.getUserName());
           preparedStatement.setString(4, user.getPassword());
           preparedStatement.setString(5, user.getAbout());
           preparedStatement.setString(6, user.getRole());
           preparedStatement.setString(7, user.getFauvourites());
           int rs=preparedStatement.executeUpdate(sql);
            System.out.println(rs);
        }catch (SQLException e){
                e.printStackTrace();
        }
    }
    public void UpdateUser(User user){
        Connection connection = ConnectionJDBC.getJDBCConnection();
        String sql="UPDATE Test1 SET Name=?, Phone=?, UserName=?, Password=?, About=?,"
                + " Role=?,Fauvourites=? WHERE ID=? ";
        try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, user.getName());
           preparedStatement.setString(2, user.getPhone());
           preparedStatement.setString(3, user.getUserName());
           preparedStatement.setString(4, user.getPassword());
           preparedStatement.setString(5, user.getAbout());
           preparedStatement.setString(6, user.getRole());
           preparedStatement.setString(7, user.getFauvourites());
           preparedStatement.setInt(7, user.getId());
           
           
           int rs=preparedStatement.executeUpdate();
            System.out.println(rs);
        }catch (SQLException e){
                e.printStackTrace();
        }
    }
    public void DeleteUser(int id){
         Connection connection = ConnectionJDBC.getJDBCConnection();
         String sql="delete from Test1 where id = ?";
         try {
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1, id);
             int rs=preparedStatement.executeUpdate();
             System.out.println(rs);
         }catch (SQLException e){
                e.printStackTrace();
        }
    }
}
