import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DruidJDBCQuery
{
  public static void main(String[] args) throws Exception
  {
    String avaticaURL = "jdbc:avatica:remote:url=http://<broker-ip>:8082/druid/v2/sql/avatica/";
    Properties connectionProperties = new Properties();

    try (Connection connection = DriverManager.getConnection(avaticaURL, connectionProperties)) {
      try (
          final Statement statement = connection.createStatement();
          final ResultSet resultSet = statement.executeQuery("Select count(*) from clickInfoDruid2");
      ) {
        while (resultSet.next()) {
          System.out.println(resultSet.getInt(1));
        }
      }
    }
  }
}
