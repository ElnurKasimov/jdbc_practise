import java.sql.*;

public class MySQLExampleQueries {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://127.0.0.1:3307/it_market";
        String dbUser = "root";
        String dbPass = "$Elnur&Kasimov1972";

        try {

            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            Statement statement = connection.createStatement();

            String query = "SELECT firstName, lastName, age FROM developers";
            ResultSet rs1 = statement.executeQuery(query);
            while (rs1.next()) {
                String lastName = rs1.getString("lastName");
                String firstName = rs1.getString("firstName");
                int age = rs1.getInt("age");
                System.out.print("lastName: " + lastName + ", ");
                System.out.print("firstName: " + firstName + ", ");
                System.out.println("age: " + age);
            }

            ResultSet rs2 = statement.executeQuery("SELECT name, age FROM example.people");
            while (rs2.next()) {
                String name = rs2.getString("name");
                int age = rs2.getInt("age");
                System.out.println(name + ", " + age + " years old");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}