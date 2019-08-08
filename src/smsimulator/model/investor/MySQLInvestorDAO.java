package smsimulator.model.investor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import smsimulator.model.DataSourceSingleton;

public class MySQLInvestorDAO {
    
    public ArrayList<Investor> getInvestors() {
        DataSourceSingleton dsource = DataSourceSingleton.getInstance();
        
        String query = "select * from investor;";
        
        ResultSet rs = dsource.select(query);
        
        ArrayList<Investor> investors = new ArrayList<Investor>();
        
        try{
            while (rs.next()){
                int    id     = rs.getInt("id");
                String name   = rs.getString("name");
                double budget = rs.getDouble("budget");
                
                investors.add(new Investor(id, name, budget));
            }
            
            // dsource.closing();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return investors;
    }
    
    
    
    public boolean saveInvestors(ArrayList<Investor> investors){
        DataSourceSingleton dsource = DataSourceSingleton.getInstance();
        
        boolean result = false;
        
        for (int i = 0 ; i < investors.size() ; i++){
            
            int    id     = investors.get(i).getId();
            String name   = investors.get(i).getName();
            double budget = investors.get(i).getBudget();
            // String budget = Double.toString(investors.get(i).getBudget());

            String query = "insert into investor(id, name, budget) values("+id+", '"+name+"', "+budget+");";
            
            result = dsource.save(query);
        }
        
        // dsource.closing();
        
        return result;
        
    }
    
    
    public boolean deleteAllFromInvestor(){
        DataSourceSingleton dsource = DataSourceSingleton.getInstance();
        boolean result = false;
        result = dsource.deleteAllFromTable("investor");
        // dsource.closing();
        return result;
    }
    
    
}