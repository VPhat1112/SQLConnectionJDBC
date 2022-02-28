/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

/**
 *
 * @author ADMIN
 */
import java.sql.SQLException;
import CONECTCLASS.User;
import java.util.List;
import jvnc.UserDao;

/**
 *
 * @author kvan2
 */
public class UserService {
    private UserDao userDao;
    
    public UserService(){
        userDao=new UserDao();
    }
    
    public List<User> getALLUsers(){
        return userDao.getALLUsers();
    }
    public void addUser(User user){
        userDao.addUser(user);
    }
    public void DeleteUser(int id){
        userDao.DeleteUser(id);
    }
}
