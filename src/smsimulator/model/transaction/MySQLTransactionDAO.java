package smsimulator.model.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import smsimulator.model.DataSourceSingleton;
import smsimulator.model.company.Company;
import smsimulator.model.investor.Investor;

public class MySQLTransactionDAO implements TransactionDAO {
    
    
    @Override
    public ArrayList<Transaction> getTransactions(ArrayList<Investor> investors, ArrayList<Company> companies) {
        DataSourceSingleton dsource = DataSourceSingleton.getInstance();
        
        String query = "select * from transaction;";
        
        ResultSet rs = dsource.select(query);
        
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        
        try{
            while (rs.next()){
                int    id                = rs.getInt("id");
                int    investorID        = rs.getInt("investorID");
                int    companyID         = rs.getInt("companyID");
                double transSharePrice   = rs.getDouble("transSharePrice");
                String date              = rs.getString("date_trans");
                
                Investor investor = investors.get(investorID-1);
                Company  company  = companies.get(companyID-1);
                
                transactions.add(new Transaction(id, investor, company, transSharePrice, date));
            }
            
            // dsource.closing();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return transactions;
    }
    
    
    @Override
    public boolean saveTransactions(ArrayList<Transaction> transactions){
        DataSourceSingleton dsource = DataSourceSingleton.getInstance();
        
        boolean result = false;
        
        
        for (int i = 0 ; i < transactions.size() ; i++){
            
            int    id              = transactions.get(i).getId();
            int    investorID      = transactions.get(i).getInvestor().getId();
            int    companyID       = transactions.get(i).getCompany().getId();
            double transSharePrice = transactions.get(i).getTrasSharePrice();
            String date            = transactions.get(i).getDate();
        
            String query = "insert into transaction(id, investorID, companyID, transSharePrice, date_trans) values ("+id+", "+investorID+", "+companyID+", "+transSharePrice+", '"+date+"');";
            
            result = dsource.save(query);
        }

        // dsource.closing();
        
        return result;
        
    }
    
    
    @Override
    public boolean deleteAllFromTransaction(){
        DataSourceSingleton dsource = DataSourceSingleton.getInstance();
        boolean result = false;
        result = dsource.deleteAllFromTable("transaction");
        // dsource.closing();
        return result;
    }
    
    
}