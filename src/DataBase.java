import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String username = "root";
        String password = "root";
        String query = "select  * from city limit 5";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, username, password);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(query)) {

                System.out.println("Connection established.....");
                while (rs.next())
                {
                    String city = rs.getString("city");
                    System.out.println(city);
                }
                System.out.println("All cities retrieved successfully");
            } catch (SQLException e) {
                System.err.println("Error executing query:");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
           e.printStackTrace();
        }
    }
}


