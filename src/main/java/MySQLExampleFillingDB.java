import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExampleFillingDB {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://127.0.0.1:3307/it_market";
        String dbUser = "root";
        String dbPass = "$Elnur&Kasimov1972";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            Statement statement = connection.createStatement();
            statement.execute("CREATE DATABASE EXAMPLE");
            statement.execute("use example");
            String creationTable = "CREATE TABLE people (people_id bigint  not null auto_increment ,  name varchar(100),  age int not null,  PRIMARY KEY(people_id))";
            statement.execute(creationTable);
            String fillingTable = "insert into people(name, age) values" +
                    "('Chimadurov Ruslan', 56)," +
                    "('Stepanova Tetyana', 34)," +
                    "('Havrilitse Vadim', 32)," +
                    "('Petrenko Vladimir', 28)," +
                    "('Omelyashko Olexey', 30)," +
                    "('Zerko Andrew', 26)," +
                    "('Yakovenko Vyacheslav', 24)";
            statement.execute(fillingTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}