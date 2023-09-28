package Item_Management;

import java.sql.*;
import java.util.*;
import Database.*;

public class ItemManagement extends MyConnection {

    public ArrayList<Item> getAllItems() {
        //logic to fetch all the items from the database;
        connect();
        ArrayList<Item> arr = new ArrayList<>();
        try {
            String query = "select * from items";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                arr.add(new Item(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
            }
            st.close();
            con.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return arr;
    }


    public ArrayList<Item> getItemsByCategory(String category) {
        //logic to fetch all the items by category from the database;
        ArrayList<Item> arr = new ArrayList<>();
        try {
            connect();
            String query = "select * from items where category=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,category);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                arr.add(new Item(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
            }
            pst.close();
            con.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return arr;
    }


    public int addItem(Item item) {
        //logic to add item to the database
        int r = -1;
        try {
            connect();
            String query = "insert into items (name,price,category) values(?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,item.getName());
            pst.setDouble(2,item.getPrice());
            pst.setString(3,item.getCategory());
            r = pst.executeUpdate(); // r is the number of rows affected
            pst.close();
            con.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return r;
    }


    public int updateItem(Item item) {
        //logic to update an item in the database
        int r = -1;
        try {
            connect();
            String query = "update items set name = ?,price = ?,category = ? where item_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,item.getName());
            pst.setDouble(2,item.getPrice());
            pst.setString(3,item.getCategory());
            pst.setInt(4,item.getItemId());
            r = pst.executeUpdate();
            pst.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return r;
    }

    public int deleteItem(int itemId) {
        //logic to delete an item from the database
        int r = -1;
        try{
            connect();
            String query = "delete from items where item_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,itemId);
            r = pst.executeUpdate();
            pst.close();
            con.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return r;
    }

    public double getPrice(int item_id) {
        double p = 0.0;
        try {
            connect();
            String query = "select price from items where item_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,item_id);
            ResultSet rs = pst.executeQuery();
            boolean rb = rs.next();
            p = rs.getDouble(1);
            pst.close();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }
}
