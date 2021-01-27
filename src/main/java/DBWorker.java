import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBWorker {
    private String user;
    private String password;
    private String url;

    public DBWorker() throws IOException {
        Properties props = new Properties();
        FileInputStream propertyFile = new FileInputStream("src\\main\\resources\\restaurantProps.properties");
        props.load(propertyFile);
        propertyFile.close();
        user = props.getProperty("User");
        password = props.getProperty("Password");
        url = props.getProperty("URL");
    }

    public DBWorker(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
