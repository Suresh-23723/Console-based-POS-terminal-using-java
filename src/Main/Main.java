package Main;


import Test.*;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to ABC Shop");
        Scanner s = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter 1 if you are Admin");
            System.out.println("Enter 2 if you are Customer");
            System.out.println("Enter q to quit");
            System.out.print("Please select the user:");
            int user = s.next().charAt(0);
            switch(user)
            {
                case '1':
                    boolean key = true;
                    while (key) {
                        System.out.println("Enter 1 to Item Management and Categorization");
                        System.out.println("Enter 2 to User Management");
                        System.out.println("Enter 3 to quit");
                        int service = s.nextInt();
                        switch (service) {
                            case 1:
                                ItemTest.runItemManagement();
                                break;
                            case 2:
                                UserTest.runUserManagement();
                                break;
                            case 3:
                                System.out.println("Exiting from Admin services");
                                key = false;
                                break;
                            default:
                                System.out.println("Enter a proper input");
                                break;
                        }
                    }
                    break;
                case '2':
                    key = true;
                    while (key) {
                        System.out.println("Enter 1 to Order Entry");
                        System.out.println("Enter 2 to Payment");
                        System.out.println("Enter 3 to quit");
                        int service = s.nextInt();
                        switch (service) {
                            case 1:
                                OrderTest.runOrderManagement();
                                break;
                            case 2:
                                PaymentTest.runPaymentManagement();
                                break;
                            case 3:
                                System.out.println("Exiting from user services");
                                key = false;
                                break;
                            default:
                                System.out.println("Enter a proper input");
                                break;
                        }
                    }
                break;
                case 'q':
                    System.out.println("Thanks for using ABC shop");
                    return;
                default:
                    System.out.println("Enter a proper input");
                    break;
            }
        }
    }
}
