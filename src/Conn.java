import java.sql.*;
public class Conn {
    Connection con;
    Statement statement;
    public Conn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","2445");
            statement = con.createStatement();
        } catch (Exception e) {
            System.out.println("Hello");
            e.printStackTrace();
        }
    }
}
