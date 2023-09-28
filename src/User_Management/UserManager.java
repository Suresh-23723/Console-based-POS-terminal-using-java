package User_Management;

import Database.*;
import java.util.*;
import java.sql.*;

public class UserManager extends MyConnection{

    public User authenticateUser(String userName,String password) {
        //logic to fetch user and logic to authenticate user credentials
        try {
            connect();
            String query = "select * from users where username = ? and password = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,userName);
            pst.setString(2,password);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRole(rs.getString(4));
                return user;
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int addUser(User user) {
        //logic to add a user to the database
        int r = -1;
        try {
            connect();
            String query = "insert into users (username,password,role) values(?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,user.getUserName());
            pst.setString(2,user.getPassword());
            pst.setString(3, user.getRole());
            r = pst.executeUpdate(); // r is the number of rows affected;
            pst.close();
            con.close();
        }catch (Exception e){
            System.out.print(e);
        }
        return r;
    }

    public ArrayList<User> getAllUser() {
        //logic to get all the user
        ArrayList<User> arr = new ArrayList<>();
        try {
            connect();
            String query = "select * from users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                arr.add(new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return arr;
    }
    public int updateUser(User user) {
        //logic to update user information in the database
        int r = -1;
        try {
            connect();
            String query = "update users set username = ?,password = ?,role = ? where user_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,user.getUserName());
            pst.setString(2,user.getPassword());
            pst.setString(3, user.getRole());
            pst.setInt(4,user.getUserId());
            r = pst.executeUpdate(); // r is the number of rows affected;
            pst.close();
            con.close();
        }catch (Exception e){
            System.out.print(e);
        }
        return r;
    }

    //more methods for user management
}
