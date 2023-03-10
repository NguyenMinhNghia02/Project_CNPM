package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hai
 */
public class MysqlConnection {
    public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "quan_ly_nha_van_hoa";
        String userName = "postgres";
        String password = "1";
        return getMysqlConnection(hostName, dbName, userName, password);
    }
    
    public static Connection getMysqlConnection(String hostName, String dbName, String userName, String password) 
        throws SQLException, ClassNotFoundException{
        //Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:postgresql://localhost:5432/quan_ly_nha_van_hoa";;
        Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
//        if(conn != null) System.out.println("Connected!");
//        else System.out.println("Failed");
        return conn;
    }
}
