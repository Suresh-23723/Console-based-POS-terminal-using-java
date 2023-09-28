package Main;

import Item_Management.*;
import Order_Entry.*;
import Tax_Calculation.*;
import User_Management.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to ABC Shop");
        int q = -1;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 1 if you are Admin");
        System.out.println("Enter 2 if you are Customer");
        System.out.print("Please select the user:");
        int user = s.nextInt();
        while(true)
        {
            if(user == 1)
            {
                System.out.println("Enter 1 to Order Entry");
                System.out.println("Enter 2 to Payment");
            }
            else
            {
                System.out.println("Enter 1 to Item Management and Categorization");
                System.out.println("Enter 2 to User Management");
            }
        }
    }
}
