package smsimulator.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataSourceSingleton {
    
    private String db = "jdbc:mysql://sinfronteras.ws:3306/smsdb";
    private String un = "aleman";
    private String pw = "v1s1Bdmh";

    
    // NOW I'M MAKING THIS GUYS GLOBAL, TO BE ABLE TO ACCESS THEM FROM ANY OF THE METHODS
    private Connection conn;
    private Statement  stmt;
    
    
    
    /* ********* Singleton implementation *********
     * Create a static private instance
     */
    static private DataSourceSingleton instance = new DataSourceSingleton();
    
    /* Singleton implementation:
     * Private constructor
     * This means that no one can instantiate it but itself
     */
    private DataSourceSingleton() {
        // NOW THE CONSTRUCTOR ONLY HAS TO CREATE THE CONNECTION AND THE STATEMENT
        try{
            // Get a connection to the database
            conn = DriverManager.getConnection(db, un, pw);

            // Get a statement from the connection
            stmt = conn.createStatement() ;
            
        }catch(SQLException se){
            System.out.println( "SQL Exception:" );
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }catch(Exception e){
            System.out.println(e) ;
        }
    }
    
    /* Singleton implementation:
     * Add a static public getter for the instance
     */
    public static DataSourceSingleton getInstance() {
        return instance;
    }    
    /* ***************************************** */
    
    
    
    // THIS IS GOING TO BE A GENERIC METHOD TO DO ANY SELECT STATEMENT THAT WE PASS IN USING THE QUERY VARIABLE
    public ResultSet select(String query) {
        // Execute the query
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query) ;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    // THIS IS GOING TO BE A GENERIC METHOD TO DO ANY INSERT STATEMENT THAT WE PASS IN USING THE QUERY VARIABLE
    public boolean save(String query) {
        try {
            stmt.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean deleteAllFromTable(String tableName) {
        try {
            stmt.execute("delete from "+tableName+";");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    // AND FINALLY WE HAVE A SEPARATE METHOD TO CLOSE THE STATEMENT AND THE CONNECTION
    public void closing() {
        try {
            stmt.close();
            conn.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   
}