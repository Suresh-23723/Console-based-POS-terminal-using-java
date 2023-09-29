package Test;


import Order_Entry.*;
import Payment.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PaymentTest {
    public static void runPaymentManagement() {
        PaymentManagement pm = new PaymentManagement();
        System.out.println("Welcome to Payment Management");
        Scanner s = new Scanner(System.in);
        while (true)
        {
            char ch;
            System.out.println("Enter 1 to add payment details to an order");
            System.out.println("Enter 2 to delete payment details of an order");
            System.out.println("Enter q to exit Item Management");
            ch = s.next().charAt(0);
            switch (ch) {
                case '1':
                    String paymentMode;
                    double price;
                    int order_id;
                    OrderEntry oe = new OrderEntry();
                    System.out.println("Order_Id   Order_Amount   Order_Date");
                    ArrayList<Order> arr = oe.getAllOrders();
                    for(Order o : arr) {
                        System.out.println("\t"+o.getOrderId()+"\t"+o.getTotalAmount()+"\t"+o.getOrderDate());
                    }
                    System.out.print("Enter the order_id :");
                    order_id = s.nextInt();
                    price = oe.getOrder(order_id).getTotalAmount();
                    System.out.print("Enter the payment mode :");
                    paymentMode = s.next();
                    Payment payment = new Payment(order_id,price,paymentMode);
                    int r = pm.addPayment(payment);
                    if (r == 1)
                        System.out.println("Payment Added successfully");
                    else
                        System.out.println("Payment not added");
                    break;
                case '2':
                    ArrayList<Payment> allPayments = pm.getAllPayments();
                    System.out.println("Payment_ID\tOrder_Id\tAmount\tPayment_Mode");
                    for(Payment p : allPayments) {
                        System.out.println("\t"+p.getPaymentId()+"\t"+p.getOrderId()+"\t"+p.getAmount()+"\t"+p.getPaymentMode());
                    }
                    System.out.println("Enter the payment ID to delete the payment");
                    int p_id = s.nextInt();
                    r = pm.deletePayment(p_id);
                    if(r == 1)
                        System.out.println("Payment deleted successfully");
                    else
                        System.out.println("Payment not deleted");
                    break;
                case 'q':
                    System.out.println("Thanks for using Payment Management");
                    return;
                default:
                    System.out.println("Please enter the valid option");
                    break;
            }
        }
    }
}
