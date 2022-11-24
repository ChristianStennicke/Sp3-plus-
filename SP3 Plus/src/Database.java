import java.sql.Connection;
public class Database
{


    private Connection connection;
    String url = "jdbc:mysql://localhost/world?" + "autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "Yke99wmg";


    String login_query = "SELECT * FROM MsUser WHERE username = ? AND password = ?";
}
