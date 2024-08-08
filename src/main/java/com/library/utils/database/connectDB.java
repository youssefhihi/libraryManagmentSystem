package main.java.com.library.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
    private static final String URL = "jdbc:mysql://localhost:3306/library_management";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                System.out.println("Connected to the com.library.database!");
            }

        } catch (SQLException e) {
            System.out.println("Error while connecting to the com.library.database");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        } finally {
            // Close the connection when done
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
