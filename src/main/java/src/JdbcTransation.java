package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransation {

    private static String SQL_OWNER =
            "INSERT INTO Owner(Id, Name) VALUES (?, ?)";

    private static String SQL_Dog =
            "INSERT INTO Dog(Id, Name, OwnerId) VALUES (?, ?, ?)";


    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatementOwner = null;
        PreparedStatement preparedStatementDog = null;

        try {
            connection = DriverManager.getConnection(
                    DbConfig.INSTANCE.getUrl(),
                    DbConfig.INSTANCE.getLogin(),
                    DbConfig.INSTANCE.getPassword()
            );
            connection.setAutoCommit(false);

            preparedStatementOwner = connection.prepareStatement(SQL_OWNER);
            preparedStatementOwner.setInt(2, 1);
            preparedStatementOwner.setString(2, "Janusz");

            preparedStatementDog = connection.prepareStatement(SQL_Dog);
            preparedStatementDog.setInt(1, 1);
            preparedStatementDog.setString(2, "dadadawdwadawdwaawdawdawwdadawdawdawdawdawdawdwadawdawdawwdawdawdawdawdawdawdadawdawdawdawdawdawdawdawdadawda");
            preparedStatementDog.setInt(3, 2);

            preparedStatementOwner.execute();
            preparedStatementDog.execute();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatementOwner != null) {
                preparedStatementOwner.close();
            }
            if (preparedStatementDog != null) {
                preparedStatementOwner.close();
            }
            if (connection != null) {
                connection.close();
            }
        }


    }


}
