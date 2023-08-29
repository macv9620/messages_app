import com.macv.messagesApp.DataBaseConnection;
import com.macv.messagesApp.UIMenu;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UIMenu.showMenu();
        /*DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection con = dataBaseConnection.getConnection()){

        } catch (SQLException e){
            System.out.println(e);
        }*/

    }
}
