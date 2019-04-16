package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectorDB {
  /*  private final String userName = "artic";
    private final String password = "artic";
    private final String connectionUrl = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(connectionUrl,userName, password);
    }
    public void closeConnection (Connection connection){
        if (connection == null) return;
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
*/

    private final String userName;
    private final String password;
    private final String connectionUrl;

    private static ConnectorDB instance;

    static {
        try {
            instance = new ConnectorDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConnectorDB getInstance() {
        return instance;
    }

    private ConnectorDB() throws IOException {
//        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com\\company\\access.properties");

        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com\\company\\access.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            connectionUrl = properties.getProperty("connectUrl");
            userName = properties.getProperty("connectUserName");
            password = properties.getProperty("connectPasswor");
        }
    }

    public Connection openConnection() throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(connectionUrl
                , userName, password);
    }

}