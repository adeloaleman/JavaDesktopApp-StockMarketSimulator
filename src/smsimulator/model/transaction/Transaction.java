package smsimulator.model.transaction;

import smsimulator.model.company.Company;
import smsimulator.model.investor.Investor;


public class Transaction {
    public  static int      idAutoIncrement;
    private final  int      id;
    private final  Investor investor;
    private final  Company  company;
    private final  double   transSharePrice;
    private final  String   date;
    
    
    public Transaction(Investor investor, Company company, double transSharePrice, String date){
        idAutoIncrement++;
        this.id              = idAutoIncrement;
        this.investor        = investor;
        this.company         = company;
        this.transSharePrice = transSharePrice;
        this.date            = date;
    }
    
    public Transaction(int id, Investor investor, Company company, double transSharePrice, String date){
        idAutoIncrement++;
        this.id              = id;
        this.investor        = investor;
        this.company         = company;
        this.transSharePrice = transSharePrice;
        this.date            = date;
    }
    
    
    // Getters:
    public int getId(){
        return id;
    }
    public Investor getInvestor(){
        return investor;
    }
    public Company getCompany(){
        return company;
    }
    public double getTrasSharePrice(){
        return transSharePrice;
    }
    public String getDate(){
        return date;
    }
    
    
    @Override
    public String toString(){
        return "Transaction "+id+":                            \n"
                    +"\tInvestor ID:      "+investor.getId()+" \n"
                    +"\tCompany ID:       "+company.getId()+"  \n"
                    +"\ttransSharePrice:  "+transSharePrice+"  \n"
                    +"\tDate:             "+date+"             \n";
    }
    
    
}
