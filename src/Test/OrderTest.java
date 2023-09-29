package Test;

import Order_Entry.*;
import Item_Management.*;
import java.util.*;
public class OrderTest {
    public static void runOrderManagement() {
        OrderEntry oe = new OrderEntry();
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Order Management\n");
        while(true) {
            System.out.println("Enter 1 to add an order to the database");
            System.out.println("Enter 2 to get all orders from the database");
            System.out.println("Enter 3 to add items to the order");
            System.out.println("Enter q to exit\n");

            char ch = s.next().charAt(0);
            switch(ch) {
                case '1':
                    int r = oe.addOrder();
                    if(r == 1)
                        System.out.println("The order added successfully");
                    else
                        System.out.println("The order does not added");
                    break;
                case '2':
                    System.out.println("Order_Id   Order_Amount   Order_Date");
                    ArrayList<Order> arr = oe.getAllOrders();
                    for(Order o : arr) {
                        System.out.println("\t"+o.getOrderId()+"\t"+o.getTotalAmount()+"\t"+o.getOrderDate());
                    }
                    break;
                case '3':
                    System.out.println("Enter the order_id :");
                    int o_id = s.nextInt();
                    ItemManagement im = new ItemManagement();
                    ArrayList<Item> items = im.getAllItems();
                    System.out.println("Item Id  Item Name");
                    for(Item i : items)
                    {
                        System.out.println("\t"+i.getItemId()+"\t"+i.getName());
                    }
                    int i_id;
                    do {
                        System.out.println("Enter the item ID of the product you want to order");
                        System.out.println("Enter -1 to stop");
                        i_id = s.nextInt();
                        if(i_id!=-1)
                            oe.addItemId(o_id,i_id);
                    }while(i_id != -1);
                    r = oe.setTotalAmount(o_id);
                    if(r == 1)
                        System.out.println("Items added successfully");
                    else
                        System.out.println("Items did not added successfully");
                    break;
                case 'q':
                    System.out.println("Thanks for using Order Management");
                    return;
            }
        }
    }
}
