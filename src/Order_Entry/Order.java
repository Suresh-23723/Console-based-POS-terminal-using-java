package Order_Entry;

import Item_Management.Item;

import java.sql.Timestamp;
import java.util.*;


public class Order {

    private int orderId;
    private ArrayList<Item> items;
    private double totalAmount;
    private Date orderDate;

    public Order(ArrayList<Item> items, double totalAmount, Date orderDate) {
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public Order(int orderId, double totalAmount, Timestamp timeStamp) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.orderDate = new Date(timeStamp.getTime());
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void addItem(Item i) {
        this.items.add(i);
    }

    public void removeItem(Item i) {
        this.items.remove(i);
    }

    public void removeItem(ArrayList<Item> list) {
        for(Item i : list) {
            this.items.remove(i);
        }
    }
}
