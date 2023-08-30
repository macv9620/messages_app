package com.macv.messagesApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl{

    public static void postMessageDB(Message message) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection con = dataBaseConnection.getConnection()){
            PreparedStatement ps = null;
            try{
                String insertQuery = "INSERT INTO messages (message, message_author) VALUES (?,?)";

                ps = con.prepareStatement(insertQuery);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getMessageAuthor());
                int res = ps.executeUpdate();
                System.out.println(res + " message created successfully");
                UIMenu.showMenu();
            }catch (SQLException e){
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static List<Message> getMessagesDB() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        List<Message> messagesList = new ArrayList<>();
        try(Connection con = dataBaseConnection.getConnection()) {
            ResultSet resultSet;
            PreparedStatement preparedStatement;
            try{
                String query = "SELECT * FROM messages";
                preparedStatement = con.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    Message ms = new Message();
                    ms.setIdMessage(resultSet.getInt("id"));
                    ms.setMessage(resultSet.getString("message"));
                    ms.setMessageAuthor(resultSet.getNString("message_author"));
                    ms.setMessageDate(resultSet.getString("message_date"));

                    messagesList.add(ms);
                }
            }catch (SQLException e){
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return messagesList;
    }

    public static List<Message> getMessagesDB(int messageId) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        List<Message> messagesList = new ArrayList<>();
        try(Connection con = dataBaseConnection.getConnection()) {
            ResultSet resultSet;
            PreparedStatement preparedStatement;
            try{
                String query = "SELECT * FROM messages WHERE id=(?)";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, messageId);
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    Message ms = new Message();
                    ms.setIdMessage(resultSet.getInt("id"));
                    ms.setMessage(resultSet.getString("message"));
                    ms.setMessageAuthor(resultSet.getNString("message_author"));
                    ms.setMessageDate(resultSet.getString("message_date"));

                    messagesList.add(ms);
                }
            }catch (SQLException e){
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return messagesList;
    }

    public static int deleteMessageDB(int id) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        PreparedStatement st = null;
        int result = 0;
        try(Connection con = dataBaseConnection.getConnection()){
            String query = "DELETE FROM messages WHERE id=(?)";
            st = con.prepareStatement(query);
            st.setInt(1, id);
            result = st.executeUpdate();
            if (result != 0){
                System.out.println(result + " message deleted successfully");
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return result;
    }

    public static int updateMessageDB(int id, Message message) {
        int affectedRows = 0;
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection con = dataBaseConnection.getConnection()){
            PreparedStatement preparedStatement = null;

            String query = "UPDATE messages SET message=(?), message_author=(?) WHERE id=(?)";

            preparedStatement =  con.prepareStatement(query);
            preparedStatement.setString(1, message.getMessage());
            preparedStatement.setString(2, message.getMessageAuthor());
            preparedStatement.setInt(3, id);

            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return affectedRows;
    }
}
