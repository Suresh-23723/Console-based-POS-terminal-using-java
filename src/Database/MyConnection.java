package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    public Connection con = null;
    public void connect() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","Suresh@mysql6524");
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
