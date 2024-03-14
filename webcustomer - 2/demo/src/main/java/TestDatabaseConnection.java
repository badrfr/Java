
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        // Database connection details
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/inventory?useSSL=false";
        String username = "root";
        String password = "root";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");

            // Attempt to connect to the database
            try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
                System.out.println("Connected to the database successfully.");

                // Query the customer table
                String query = "SELECT customer_id, cust_name, city, grade, salesman_id FROM customer";
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(query)) {

                    System.out.println("Customer ID | Name | City | Grade | Salesman ID");
                    // Loop through the result set and print each record
                    while (resultSet.next()) {
                        int customerID = resultSet.getInt("customer_id");
                        String name = resultSet.getString("cust_name");
                        String city = resultSet.getString("city");
                        int grade = resultSet.getInt("grade");
                        int salesmanID = resultSet.getInt("salesman_id");

                        System.out.println(customerID + " | " + name + " | " + city + " | " + grade + " | " + salesmanID);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the JDBC driver. Make sure the driver is on the classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not connect to the database. Check the connection details and ensure the database is running.");
            e.printStackTrace();
        }
    }
}
