import java.io.IOException;
import java.sql.*;


public class Test {
    public static void main(String[] args) throws SQLException, IOException {
        DBWorker worker = new DBWorker();
        Statement statement = worker.getConnection().createStatement();
        statement.executeUpdate("insert into menu (name, price) " +
                "values ('Meal#1',24.5), ('Meal#2',14.9), ('Meal#3',34.9) ");
        ResultSet rs = statement.executeQuery("select * from menu where name not like 'Meal%'");
        System.out.println("\n\tDrinks: ");
        while (rs.next()) {
            System.out.println(rs.getString("name") +
                    ":\t" + rs.getDouble("price"));
        }
        rs = statement.executeQuery("select * from menu where name like 'Meal%'");
        System.out.println("\n\tMeals: ");
        while (rs.next()) {
            System.out.println(rs.getString("name") +
                    ":\t" + rs.getDouble("price"));
        }
    }
}
