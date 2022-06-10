package Services;

import java.sql.Connection;

public class ConnectDB {
    //read all config DATABASE_NAME, USERNAME, PASSWORD,
    //HOST, PORT from ReadConfig.java




    public static String dbName = ReadConfig.getConfigValue("DATABASE_NAME");
    public static String userName = ReadConfig.getConfigValue("DATABASE_USERNAME");
    public static String password = ReadConfig.getConfigValue("DATABASE_PASSWORD");

    public static String host = ReadConfig.getConfigValue("DATABASE_HOST");

    public static String port = ReadConfig.getConfigValue("DATABASE_PORT");
    public static String url = "jdbc:mysql://"+host+":"+port+"/";

    //connect to database
    public static Connection conn = null;
    public static Connection getConnection() {
        try {
            conn = java.sql.DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
