package Test;

import Item_Management.Item;
import Item_Management.ItemManagement;

import java.util.*;

public class ItemTest{
    public static void runItemManagement() {
        ItemManagement im = new ItemManagement();
        System.out.println("Welcome to Item Management");
        Scanner s = new Scanner(System.in);
        while (true)
        {
            char ch;
            System.out.println("Enter 1 to add an item to the shop");
            System.out.println("Enter 2 to update an item to the shop");
            System.out.println("Enter 3 to delete an item from the shop");
            System.out.println("Enter q to exit Item Management");
            ch = s.next().charAt(0);
            switch (ch) {
                case '1':
                    String name, category;
                    double price;
                    System.out.print("Enter the item name :");
                    name = s.next();
                    System.out.print("Enter the item price :");
                    price = s.nextDouble();
                    System.out.print("Enter the category :");
                    category = s.next();
                    Item item = new Item(name, price, category);
                    int r = im.addItem(item);
                    if (r == 1)
                        System.out.println("Item Added successfully");
                    else
                        System.out.println("Item not added");
                    break;
                case '2':
                    ArrayList<Item> arr = im.getAllItems();
                    System.out.println("Item Id    Item Name");
                    for (Item i : arr)
                        System.out.println("\t" + i.getItemId() + "\t" + i.getName());
                    int id;
                    System.out.print("Enter the item id needed to be updated :");
                    id = s.nextInt();
                    System.out.print("Enter the item name :");
                    name = s.next();
                    System.out.print("Enter the item price :");
                    price = s.nextDouble();
                    System.out.print("Enter the category :");
                    category = s.next();
                    item = new Item(id, name, price, category);
                    r = im.updateItem(item);
                    if (r == 1)
                        System.out.println("Item updated successfully");
                    else
                        System.out.println("Item not updated");
                    break;
                case '3':
                    arr = im.getAllItems();
                    System.out.println("Item Id    Item Name");
                    for (Item i : arr)
                        System.out.println("\t" + i.getItemId() + "\t" + i.getName());
                    System.out.print("Enter the item id needed to be deleted :");
                    id = s.nextInt();
                    r = im.deleteItem(id);
                    if (r == 1)
                        System.out.println("Item deleted successfully");
                    else
                        System.out.println("Item not deleted");
                    break;
                case 'q':
                    System.out.println("Thanks for using Item Management");
                    return;
                default:
                    System.out.println("Please enter the valid option");
                    break;
            }
        }
    }
}

