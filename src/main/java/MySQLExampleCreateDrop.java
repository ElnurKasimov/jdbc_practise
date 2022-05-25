import java.sql.*;

public class MySQLExampleCreateDrop {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://127.0.0.1:3307/it_market";
        String dbUser = "root";
        String dbPass = "$Elnur&Kasimov1972";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            Statement statement = connection.createStatement();
            //  creating database

            String creationDB = "CREATE DATABASE EXAMPLE";
           statement.execute(creationDB);
           //creating table
            String activate = "use example";
            statement.execute(activate);
            String creationTable = "CREATE TABLE people (people_id bigint  not null auto_increment ,  name varchar(100),  age int not null,  PRIMARY KEY(people_id))";
            statement.execute(creationTable);

            // deleting table
           // statement.execute("use example");   если эта база данныхне активна, то таблица не удалиться
            //statement.execute("drop table people");
            // как вариант использовать полный путь до базы без активации базы
            statement.execute("drop table example.people");

            // deleting database
            statement.execute("drop database example");

        //connection.commit(); непонятно нужна ли эта команда.....без нее все работает

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}