package com.macv.messagesApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public Connection getConnection() {
        Connection con = null;
        try{
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/db_messages?useTimeZone=true&serverTimeZone=UTC",
                    "root",
                    "Mpt412839"
            );
            /*if (con != null){
                System.out.println("Conexión establecida");
            }*/
        } catch (SQLException e){
            System.out.println(e);
        }
        return con;
    }
}
