import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;



public class MySQLAdsDao implements Ads {
    private Connection connection;


    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            // driver manager allows us to know which database we're trying access in this case it's Mysql.
            // establishes the connection using the parameters from our config class
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
        try {
            // This method allows the listing of all ads
            Statement stmt = connection.createStatement();
            //Allows us to create Sql statements and us them as strings
            String selectAds = "SELECT * FROM ads";
            //What we're selecting is stored in selectads
            ResultSet rs = stmt.executeQuery(selectAds);
            //Here we're using execute query.
            // resultset allows us to view the results and above we pass select ads using stmt to execute the query.
            List<Ad> adsList = new ArrayList<>();

            while (rs.next()) {
                adsList.add(new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description")));
                //return the results and adds them to my arraylist adsList
            }
            return adsList;
        } catch (Exception e) {
            throw new RuntimeException("Error creating statement.");
        }
    }


    @Override
    public Long insert(Ad ad) {
        try {
            Statement stmt = connection.createStatement();
            //Same thing here where stmt allows query Mysql strings to be ran.
            String insertQuery = String.format("INSERT INTO ads (user_id, title, description) VALUES ('%s', '%s', '%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());


            stmt.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            // Here we excuteUpdate query since we're adding.

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                System.out.println("It works an has been inserted");
            }
            return rs.getLong(1);
        } catch (Exception e) {
            throw new RuntimeException("Error adding ads");
        }

    }
}