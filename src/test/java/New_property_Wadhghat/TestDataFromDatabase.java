package New_property_Wadhghat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDataFromDatabase {

    // Variables to store values from the database
    static public String url;
    static public String userid;
    static public String password;
    static public String node;
    static public String sector;

    public static void GetDataFromDB() throws SQLException {
        // JDBC URL for SQL Server
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=CMSData";  // Update with your DB URL
        String dbUsername = "sa";  // Replace with your DB username
        String dbPassword = "123456";  // Replace with your DB password

        // SQL query to retrieve data from the Credentials table
        String query = "SELECT userid, password, url, node, sector FROM Credentials WHERE id = 1";  // Modify as needed

        // Establish connection to the database
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Execute the query and get the result
            ResultSet rs = stmt.executeQuery();

            // Check if there's data and retrieve it
            if (rs.next()) {
                userid = rs.getString("userid");
                password = rs.getString("password");
                url = rs.getString("url");
                node = rs.getString("node");
                sector = rs.getString("sector");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            // Fetch data from the database
            GetDataFromDB();

            // Print the retrieved data
            System.out.println("User ID: " + userid);
            System.out.println("Password: " + password);
            System.out.println("URL: " + url);
            System.out.println("Node: " + node);
            System.out.println("Sector: " + sector);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
