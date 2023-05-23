import java.util.List;
import java.sql.*;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;
public class MySQLAdsDao implements Ads{
  private Connection connection;
  private Config config = new Config();

  public MySQLAdsDao () {
    try {
      DriverManager.registerDriver(new Driver());
      String url = config.getUrl();
      String username = config.getUsername();
      String password = config.getPassword();

      connection = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      throw new RuntimeException("Did not connect to database");
    }

  }


  @Override
    public List<Ad> all() {
        return null;
    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }
}
