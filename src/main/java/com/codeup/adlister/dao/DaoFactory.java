package com.codeup.adlister.dao;


import com.codeup.adlister.models.User;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    //adsDao and userDao are referencing the interfaces and below we're pointing to the classes where the abstract methods are defined (the abstarct methods are in the interfaces Users and Ads) which in this case is the MySqlAdsDao and MySqlUsersDao
    // Above is the data type Ads that comes from our Ads interface and is named adsDao so we can reference it below.
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
            // The constructor inside MySqLAdsDao requires Config as a parameter to establish the connection to Mysql. So above we make instantiate the Config object to use it as a parameter.

        }
        return adsDao;
    }
    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
            // The constructor inside MySqLAdsDao requires Config as a parameter to establish the connection to Mysql. So above we make instantiate the Config object to use it as a parameter.

        }
        return usersDao;
    }

}
