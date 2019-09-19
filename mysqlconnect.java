package hw1;
import java.sql.*;
import static java.lang.System.out;
/**
 *
 * @author mike
 * Professor Mike sent me this file via email to use when we were debugging my 3-tier architecture
 * I have modified it to work with my database
 */
public class mysqlconnect {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
  public static void main(String args[]) throws ClassNotFoundException {
        String db = "cs157a";
        String user;
        user = "root";
        String password = "j.mercado1";
        try {
           
            java.sql.Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs157a?serverTimezone=EST5EDT", user, password);
            out.println(db + " database successfully opened.");
           
            out.println("Initial entries in table \"emp\":");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
            while (rs.next()) {
                out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) );
            }
            rs.close();
            stmt.close();
            con.close();
        } catch(SQLException e) {
            out.println("SQLException caught: " + e.getMessage());
        }
    }
   
}