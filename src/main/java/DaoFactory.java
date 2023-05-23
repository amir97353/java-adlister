public class DaoFactory {
    private static Ads adsDao;
//adsDao is an instance of our ads interfere.
    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(new Config());
            //Here we make our instance of our Ads called adsDao = to MysqlAdsDao which is where we define what happens inside the interface Ads. This gives  you accesses to the methods .all and insert. that are defined inside mysqladsDao this happens inside your do get/ do post methods
            //.DaoFactory.getAdsDao.all
        }
        return adsDao;
    }
}
