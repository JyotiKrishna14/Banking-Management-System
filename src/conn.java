import java.sql.*;
public class conn {
    Connection con;
    Statement s;
    public conn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","2445");
            s = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
