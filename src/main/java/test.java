
import java.sql.*;

/**
 * @author postgresqltutorial.com
 */
class App {

    private final String url = "jdbc:postgresql://localhost:5432/test_db";
    private final String user = "root";
    private final String password = "root";
    Statement stmt = null;
    ResultSet rs = null;

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM color_table");
            while (rs.next()) {
                String lastName = rs.getString("name");
                System.out.println(lastName + "\n");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        app.connect();
    }
}