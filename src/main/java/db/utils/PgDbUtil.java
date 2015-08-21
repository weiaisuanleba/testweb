package db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dell on 2015/7/21.
 */
public class PgDbUtil {

    private static final String DB_CONFIG = "db_config.json";

    private PgDbUtil(){}

    static {
        String configStr = ConfigUtil.getStringByFile(DB_CONFIG);
        System.out.println(configStr);
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            String url = "jdbc:postgresql://172.17.185.210:5432/itone";
            Connection con = DriverManager.getConnection(url, "postgres", "itone1qa2ws3ed");
            Statement st = con.createStatement();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){

        return null;
    }

}
