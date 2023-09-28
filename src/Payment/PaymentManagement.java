package Payment;

import java.sql.*;
import java.util.*;
import Database.*;

public class PaymentManagement extends MyConnection{

    public int addPayment(Payment payment) {
        //logic to add a payment details to the database;
        int r = -1;
        try{
            connect();
            String query = "insert into payments (order_id,amount,paymentMode) values(?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,payment.getOrderId());
            pst.setDouble(2,payment.getAmount());
            pst.setString(3, payment.getPaymentMode());
            r = pst.executeUpdate(); // r is the number of rows affected;
            pst.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return r;
    }

    public int deletePayment(int payment_id) {
        //logic to delete a payment details from database;
        int r = -1;
        try{
            connect();
            String query = "delete from payments where payment_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,payment_id);
            r = pst.executeUpdate(); // r is the number of rows affected
            pst.close();
            con.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return r;
    }

    public ArrayList<Payment> getAllPayments() {
        ArrayList<Payment> arr = new ArrayList<>();
        try{
            connect();
            String query = "select * from payments";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                Payment payment = new Payment(rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getString(4));
                arr.add(payment);
            }
            st.close();
            con.close();
        }catch(Exception e)
        {
            System.out.print(e);
        }
        return arr;
    }
}
