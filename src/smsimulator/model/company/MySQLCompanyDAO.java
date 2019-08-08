package smsimulator.model.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import smsimulator.model.DataSourceSingleton;

public class MySQLCompanyDAO implements CompanyDAO {
    
    public ArrayList<Company> getCompanies() {
        DataSourceSingleton dsource = DataSourceSingleton.getInstance();
        
        String query = "select * from company;";
        
        ResultSet rs = dsource.select(query);
        
        ArrayList<Company> companies = new ArrayList<Company>();
        
        try{
            while (rs.next()){
                int    id         = rs.getInt("id");
                String name       = rs.getString("name");
                int    shares     = rs.getInt("shares");
                double sharePrice = rs.getDouble("sharePrice");
                
                companies.add(new Company(id, name, shares, sharePrice));
            }
            
            // dsource.closing();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return companies;
    }
    
    
    
    public boolean saveCompanies(ArrayList<Company> companies){
        DataSourceSingleton dsource = DataSourceSingleton.getInstance();
        
        boolean result = false;
        
        
        for (int i = 0 ; i < companies.size() ; i++){
            
            int    id         = companies.get(i).getId();
            String name       = companies.get(i).getName();
            int    shares     = companies.get(i).getShares();
            Double sharePrice = companies.get(i).getsharePrice();
            
            // String sharePrice = Double.toString(companies.get(i).getsharePrice());
            // DecimalFormat df = new DecimalFormat("#.##");
            // System.out.println(df.format(sharePrice));
            // String string2deci = df.format(sharePrice);
        
            // System.out.println(id);
            String query = "insert into company(id, name, shares, sharePrice) values ("+id+", '"+name+"', "+shares+", "+sharePrice+");";
            
            result = dsource.save(query);
        }

        // dsource.closing();
        
        return result;
        
    }
    
    
    public boolean deleteAllFromCompany(){
        DataSourceSingleton dsource = DataSourceSingleton.getInstance();
        boolean result = false;
        result = dsource.deleteAllFromTable("company");
        // dsource.closing();
        return result;
    }
    
}