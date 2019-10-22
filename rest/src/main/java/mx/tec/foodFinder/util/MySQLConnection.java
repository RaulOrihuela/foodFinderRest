package mx.tec.foodFinder.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {
    public static Connection getConnection(String dbName) throws SQLException{
        Connection connection = null;
        try {
            String ipAddress = "localhost",port = "3306",user  = "root" ,password  = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            connection = DriverManager.getConnection(
                    "jdbc:mysql://".concat(ipAddress).concat(":").concat(port).concat("/")
                            .concat(dbName).concat("?user=").concat(user)
                            .concat("&password=").concat(password)
                            .concat("&serverTimezone=America/Mexico_City&useSSL=false&allowPublicKeyRetrieval=true")
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static Connection getConnection(String dbName, String user, String password) throws SQLException{
        Connection connection = null;
        try {
            String ipAddress = "localhost",port = "3306";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            connection = DriverManager.getConnection(
                    "jdbc:mysql://".concat(ipAddress).concat(":").concat(port).concat("/")
                            .concat(dbName).concat("?user=").concat(user)
                            .concat("&password=").concat(password)
                            .concat("&serverTimezone=America/Mexico_City&useSSL=false&allowPublicKeyRetrieval=true")
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
