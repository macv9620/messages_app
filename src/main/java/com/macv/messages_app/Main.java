package com.macv.messages_app;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection con = dataBaseConnection.getConnection()){

        } catch (SQLException e){
            System.out.println(e);
        }

    }
}
