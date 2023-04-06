package app;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 * 
 * This is an example JDBC Connection that has a single query for the Movies Database
 * This is similar to the project workshop JDBC examples.
 *
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 */
public class JDBCConnection {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/Homeless58.db";

    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    /**
     * Get all of the Movies in the database
     */
    public ArrayList<HomeData> getHomeless2016() {
        ArrayList<HomeData> tableData = new ArrayList<HomeData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT l.lga_name, h.homeless_m, h.homeless_f, (h.homeless_f + h.homeless_m) as Total FROM lga l JOIN homeless_group_2016 h ON l.lga_code = h.group_id";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);


            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!

                String lga_name     = results.getString("lga_name");
                String homeless_f      = results.getString("homeless_f");
                String homeless_m      = results.getString("homeless_m");
                int homeless_total   = results.getInt("Total");
        
                // For now we will just store the movieName and ignore the id
                HomeData homedata = new HomeData();

                homedata.setLGA(lga_name);
                homedata.setHomeless_f(homeless_f);
                homedata.setHomeless_m(homeless_m);
                homedata.setHomelessTotal(homeless_total);

            
                tableData.add(homedata);
                
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return tableData;
    }

    public ArrayList<HomeData> getHomeless2018() {
        ArrayList<HomeData> tableData = new ArrayList<HomeData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT l.lga_name, h.homeless_m, h.homeless_f, (h.homeless_f + h.homeless_m) as Total FROM lga l JOIN homeless_group_2018 h ON l.lga_code = h.group_id";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);


            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
            while (results.next()) {
                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!

                String lga_name     = results.getString("lga_name");
                String homeless_f      = results.getString("homeless_f");
                String homeless_m      = results.getString("homeless_m");
                int homeless_total   = results.getInt("Total");
        
                // For now we will just store the movieName and ignore the id
                HomeData homedata = new HomeData();

                homedata.setLGA(lga_name);
                homedata.setHomeless_f(homeless_f);
                homedata.setHomeless_m(homeless_m);
                homedata.setHomelessTotal(homeless_total);

            
                tableData.add(homedata);
                
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return tableData;
    }



  /**
     * Get all of the homeless females 2016 in the database
     */
    public ArrayList<HomeData> getgender2016() {
        ArrayList<HomeData> women2016 = new ArrayList<HomeData>();
        
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT lga_name, atrisk_f, atrisk_m FROM lga l, homeless_group_2016 h WHERE l.lga_code = h.group_id";
            
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

           

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
           while (results.next()) {

                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String lga              = results.getString("lga_name");
                String atrisk_f     = results.getString("atrisk_f");
                String atrisk_m     = results.getString("atrisk_m");
             //   String type         = results.getString("mvtype");

            
             HomeData homedata = new HomeData();

             homedata.setLGA(lga);
             homedata.setatrisk_f(atrisk_f);
             homedata.setatrisk_m(atrisk_m);

            
                women2016.add(homedata);
                
            }
        
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return women2016;
    }

    public ArrayList<HomeData> getgender2018() {
        ArrayList<HomeData> women2018 = new ArrayList<HomeData>();
        
        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT lga_name, atrisk_f, atrisk_m FROM lga l, homeless_group_2018 h WHERE l.lga_code = h.group_id";
            
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

           

            // Process all of the results
            // The "results" variable is similar to an array
            // We can iterate through all of the database query results
           while (results.next()) {

                // We can lookup a column of the a single record in the
                // result using the column name
                // BUT, we must be careful of the column type!
                String lga              = results.getString("lga_name");
                String atrisk_f     = results.getString("atrisk_f");
                String atrisk_m     = results.getString("atrisk_m");
             //   String type         = results.getString("mvtype");

            
             HomeData homedata = new HomeData();

             homedata.setLGA(lga);
             homedata.setatrisk_f(atrisk_f);
             homedata.setatrisk_m(atrisk_m);

            
                women2018.add(homedata);
                
            }
        
            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the movies
        return women2018;
    }


public ArrayList<HomeData> getage2016() {
    ArrayList<HomeData> age2016 = new ArrayList<HomeData>();
    
    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        String query = "SELECT lga_name, underTen, underTwenty, underThirty, underFourty, underFifty, overSixty FROM lga l, homeless_group_2016 h WHERE l.lga_code = h.group_id;";
        
        
        // Get Result
        ResultSet results = statement.executeQuery(query);

       

        // Process all of the results
        // The "results" variable is similar to an array
        // We can iterate through all of the database query results
       while (results.next()) {

            // We can lookup a column of the a single record in the
            // result using the column name
            // BUT, we must be careful of the column type!
            String lga              = results.getString("lga_name");
           // String atrisk_f     = results.getString("atrisk_f");
          //  String atrisk_m     = results.getString("atrisk_m");
            String age1         = results.getString("underTen");
            String age2         = results.getString("underTwenty");
            String age3         = results.getString("underThirty");
            String age4         = results.getString("underFourty");
            String age5         = results.getString("underFifty");
            String age6         = results.getString("overSixty");


        
         HomeData homedata = new HomeData();

         homedata.setLGA(lga);
       //  homedata.setatrisk_f(atrisk_f);
      //   homedata.setatrisk_m(atrisk_m);
         homedata.setAge1(age1);
         homedata.setAge2(age2);
         homedata.setAge3(age3);
         homedata.setAge4(age4);
         homedata.setAge5(age5);
         homedata.setAge6(age6);
        
            age2016.add(homedata);

       }


        // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    // Finally we return all of the movies
    return age2016;
}

public ArrayList<HomeData> getage2018() {
    ArrayList<HomeData> age2018 = new ArrayList<HomeData>();
    
    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        String query = "SELECT lga_name, underTen, underTwenty, underThirty, underFourty, underFifty, overSixty FROM lga l, homeless_group_2018 h WHERE l.lga_code = h.group_id;";
        
        
        // Get Result
        ResultSet results = statement.executeQuery(query);

       

        // Process all of the results
        // The "results" variable is similar to an array
        // We can iterate through all of the database query results
       while (results.next()) {

            // We can lookup a column of the a single record in the
            // result using the column name
            // BUT, we must be careful of the column type!
            String lga              = results.getString("lga_name");
          //  String atrisk_f     = results.getString("atrisk_f");
          //  String atrisk_m     = results.getString("atrisk_m");
            String age1         = results.getString("underTen");
            String age2         = results.getString("underTwenty");
            String age3         = results.getString("underThirty");
            String age4         = results.getString("underFourty");
            String age5         = results.getString("underFifty");
            String age6         = results.getString("overSixty");


        
         HomeData homedata = new HomeData();

         homedata.setLGA(lga);
       //  homedata.setatrisk_f(atrisk_f);
       //  homedata.setatrisk_m(atrisk_m);
         homedata.setAge1(age1);
         homedata.setAge2(age2);
         homedata.setAge3(age3);
         homedata.setAge4(age4);
         homedata.setAge5(age5);
         homedata.setAge6(age6);
        
            age2018.add(homedata);

       }
       

        // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    // Finally we return all of the movies
    return age2018;
}









}


