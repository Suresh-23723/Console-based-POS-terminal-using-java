package Order_Entry;

import Database.*;
import Item_Management.*;
import Tax_Calculation.TaxCalculator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class OrderEntry extends MyConnection{

//    public Order createOrder(ArrayList<Item> items) {
//        Date d = new Date();
//        double total = this.getTotalAmount(items);
//        Order o = new Order(items,total,d);
//        int r = addOrder(total);
//        if(r == 1)
//            System.out.println("Order created and added to the database successfully");
//        else
//            System.out.println("Order created but does not added to the database");
//        return o;
//    }

    public int addOrder() {
        //logic to add an order to the database;
        int r = -1;
        try {
            connect();
            String query = "insert into orders (total_amount) values (0.0)";
            Statement st = con.createStatement();
            r = st.executeUpdate(query);
            st.close();
            con.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return r;
    }

    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> ans = new ArrayList<>();
        try {
            connect();
            String query = "select * from orders";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                ans.add(new Order(rs.getInt(1),rs.getDouble(2),rs.getTimestamp(3)));
            }
            st.close();
            con.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return ans;
    }
    public Order getOrder(int orderId) {
        //logic to get an Order using Id
        Order o = null;
        try {
            connect();
            String query = "select * from orders where order_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,orderId);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                o = new Order(orderId,rs.getDouble(2),rs.getTimestamp(3));
            }
            pst.close();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return o;
    }

    public int addItemId(int order_id,int item_id)
    {
        int r = 0;
        try
        {
            connect();
            String query = "insert into ordered_items (order_id,item_id) values(?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,order_id);
            pst.setInt(2,item_id);
            r = pst.executeUpdate();
            pst.close();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }
    public int setTotalAmount(int o_id) {
        double sum = 0.0;
        int r = 0;
        TaxCalculator tc = new TaxCalculator();
        try{
            connect();
            String query = "select sum(price) as sum from items join ordered_items on items.item_id = ordered_items.item_id where order_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,o_id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            sum = rs.getDouble(1);
            sum = tc.calculateTax(sum);
            pst.close();
            String query1 = "update orders set total_amount = ? where order_id = ?";
            pst = con.prepareStatement(query1);
            pst.setDouble(1,sum);
            pst.setInt(2,o_id);
            r = pst.executeUpdate();
            pst.close();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }
}

