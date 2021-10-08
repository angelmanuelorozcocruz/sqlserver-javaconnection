import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServerConnection {
    public static void main(String[] args) throws Exception {
        // Create a variable of type String for connect.
        String connectionUrl = "jdbc:sqlserver://DESKTOP-H755IA0\\SQLEXPRESS2019:1433;databaseName=master;userName=sa;password=DBAAMOC.1997.#";
        // Try connect with a try catch statement.
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            // Create a variable of type String for perfom the query.
            String querySql = "SELECT * FROM master.dbo.MSreplication_options";
            // Create a varible of type ResulSet for return the values of the query.
            ResultSet rs = stmt.executeQuery(querySql);
            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("optname") + " " + rs.getString("value") + " "
                        + rs.getString("major_version") + " " + rs.getString("minor_version") + " "
                        + rs.getString("revision") + " " + rs.getString("install_failures"));
            }
            // Handle any error that may have occurred.
        } catch (SQLException sqle) {
            // TODO: handle exception
            sqle.printStackTrace();
        }
    }
}
