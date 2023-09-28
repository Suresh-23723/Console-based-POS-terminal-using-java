package Test;

import User_Management.*;
import java.util.*;

public class UserTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        UserManager um = new UserManager();
        System.out.println("Welcome to User Management\n");
        char ch;
        while(true)
        {
            System.out.println("\nEnter 1 to add user to the database");
            System.out.println("Enter 2 to update an user to the database");
            System.out.println("Enter 3 to authenticate User");
            System.out.println("Enter q to quit User Management");

            ch = s.next().charAt(0);
            switch (ch) {
                case '1':
                    System.out.println("Enter the username: ");
                    String username = s.next();
                    System.out.println("Enter the password: ");
                    String password = s.next();
                    System.out.println("Enter the role of the user: ");
                    String role = s.next();
                    User user = new User(username,password,role);
                    int r = um.addUser(user);
                    if(r == 1)
                        System.out.println("User added successfully");
                    else
                        System.out.println("User did not added successfully");
                    break;
                case '2':
                    ArrayList<User> arr = um.getAllUser();
                    System.out.println("User Id  User Name");
                    for(User u : arr)
                    {
                        System.out.println("\t"+u.getUserId()+"\t"+u.getUserName());
                    }
                    System.out.println("Enter the userId :");
                    int userId = s.nextInt();
                    System.out.println("Enter the username: ");
                    username = s.next();
                    System.out.println("Enter the password: ");
                    password = s.next();
                    System.out.println("Enter the role of the user: ");
                    role = s.next();
                    user = new User(userId,username,password,role);
                    r = um.updateUser(user);
                    if(r == 1)
                        System.out.println("User updated successfully");
                    else
                        System.out.println("User did not updated successfully");
                    break;
                case '3':
                    System.out.println("Enter the username: ");
                    username = s.next();
                    System.out.println("Enter the password: ");
                    password = s.next();
                    user = um.authenticateUser(username,password);
                    if(user == null)
                        System.out.println("Authentication failed and no users found");
                    else
                        System.out.println("Authentication success");
                    break;
                case 'q':
                    System.out.println("\nThanks for using User Management");
                    return;
                default:
                    System.out.println("Enter the correct option");
            }
        }
    }

}
