package smsimulator.model;

import java.util.ArrayList;
import java.util.Collections;
import smsimulator.model.company.Company;
import smsimulator.model.investor.Investor;
import smsimulator.model.transaction.Transaction;


public class SimulationResultsSummary {
    
    public SimulationResultsSummary(){}
    
    // This method return an ArrayList<Double> of size companies.size(). 
    // The index 0 of this ArrayList contains the Total Capital for the Company with ID 1
    // The index 1 contains the Total Capital for the Company with ID 2
    // etc...
    public ArrayList<Double> getCompaniesCapital(ArrayList<Transaction> transactions, ArrayList<Company> companies){
        ArrayList<Double> companiesCapital = new ArrayList<Double>();
        double value = 0;
        for (int i = 0 ; i <= companies.size() ; i++){
            companiesCapital.add(value);
        }
        
        for (Transaction tran: transactions ){
            companiesCapital.set(tran.getCompany().getId(), companiesCapital.get(tran.getCompany().getId()) + tran.getTrasSharePrice());
            
        }
        
        companiesCapital.remove(0);
        
        return companiesCapital;
    }
    
    
    // 
    public ArrayList<Integer> getCompaniesMaxCapital(ArrayList<Double> companiesCapitals){
        ArrayList<Integer> companiesMaxCapitals = new ArrayList<Integer>();
        double max = Collections.max(companiesCapitals);
        for (int i=0 ; i < companiesCapitals.size() ; i++){
            if (companiesCapitals.get(i) == max){
                companiesMaxCapitals.add(i);
            }
        }
        return companiesMaxCapitals;
    }
    
    
    // 
    public ArrayList<Integer> getCompaniesMinCapital(ArrayList<Double> companiesCapitals){
        ArrayList<Integer> companiesMinCapitals = new ArrayList<Integer>();
        double min = Collections.min(companiesCapitals);
        for (int i=0 ; i < companiesCapitals.size() ; i++){
            if (companiesCapitals.get(i) == min){
                companiesMinCapitals.add(i);
            }
        }
        return companiesMinCapitals;
    }
    
    
    //
    public ArrayList<Integer> getInvestorsNumberOfShares(ArrayList<Transaction> transactions, ArrayList<Investor> investors){
       
        ArrayList<Integer> investorsNumberOfShares = new ArrayList<Integer>();
        for (int i = 0 ; i <= investors.size() ; i++){
            investorsNumberOfShares.add(0);
        }
        
        for (Transaction tran: transactions ){
            investorsNumberOfShares.set(tran.getInvestor().getId(), investorsNumberOfShares.get(tran.getInvestor().getId()) + 1);
        }
        
        investorsNumberOfShares.remove(0);
        
        return investorsNumberOfShares;
    }
    
    
    //
    public ArrayList<Integer> getInvestorsMaxShares(ArrayList<Integer> investorsNumberOfShares){
        ArrayList<Integer> investorsMaxShares = new ArrayList<Integer>();
        int max = Collections.max(investorsNumberOfShares);
        for (int i=0 ; i < investorsNumberOfShares.size() ; i++){
            if (investorsNumberOfShares.get(i) == max){
                investorsMaxShares.add(i);
            }
        }
        return investorsMaxShares;
    }
    
    
    // 
    public ArrayList<Integer> getInvestorsMinShares(ArrayList<Integer> investorsNumberOfShares){
        ArrayList<Integer> investorsMinShares = new ArrayList<Integer>();
        int min = Collections.min(investorsNumberOfShares);
        for (int i=0 ; i < investorsNumberOfShares.size() ; i++){
            if (investorsNumberOfShares.get(i) == min){
                investorsMinShares.add(i);
            }
        }
        return investorsMinShares;
    }       
    
    
    //
    public ArrayList<Integer> getNumberOfCompaniesByInvestor(ArrayList<Transaction> transactions, ArrayList<Investor> investors){
        // List to keept track of the IDs of investor and companies for every transaction
        ArrayList<Integer> investorsIDs = new ArrayList<Integer>();
        ArrayList<Integer> companiesIDs = new ArrayList<Integer>();
        investorsIDs.add(0);
        companiesIDs.add(0);
        
        ArrayList<Integer> numberOfCompaniesByInvestor = new ArrayList<Integer>();
        for (int i = 0 ; i <= investors.size() ; i++){
            numberOfCompaniesByInvestor.add(0);
        }
        
        boolean newCompany;
        for (Transaction tran: transactions ){
            
            newCompany = true;
            for (int i= 0 ; i< investorsIDs.size() ; i++){
                  if (investorsIDs.get(i) == tran.getInvestor().getId() &&
                      companiesIDs.get(i) == tran.getCompany().getId()  ){
                      
                    newCompany = false;
                    break;
                }
            }
            if (newCompany == true){
                investorsIDs.add(tran.getInvestor().getId());
                companiesIDs.add(tran.getCompany().getId());

                numberOfCompaniesByInvestor.set(tran.getInvestor().getId(), numberOfCompaniesByInvestor.get(tran.getInvestor().getId()) + 1);
            }
        }
        
        numberOfCompaniesByInvestor.remove(0);
        
        return numberOfCompaniesByInvestor;
    }
    
    
    // 
    public ArrayList<Integer> getInvestorsMaxCompanies(ArrayList<Integer> numberOfCompaniesByInvestor){
        ArrayList<Integer> investorsMaxCompanies = new ArrayList<Integer>();
        int max = Collections.max(numberOfCompaniesByInvestor);
        for (int i=0 ; i < numberOfCompaniesByInvestor.size() ; i++){
            if (numberOfCompaniesByInvestor.get(i) == max){
                investorsMaxCompanies.add(i);
            }
        }
        return investorsMaxCompanies;
    }
    
    
    //
    public ArrayList<Integer> getInvestorsMinCompanies(ArrayList<Integer> numberOfCompaniesByInvestor){
        ArrayList<Integer> investorsMinCompanies = new ArrayList<Integer>();
        int min = Collections.min(numberOfCompaniesByInvestor);
        for (int i=0 ; i < numberOfCompaniesByInvestor.size() ; i++){
            if (numberOfCompaniesByInvestor.get(i) == min){
                investorsMinCompanies.add(i);
            }
        }
        return investorsMinCompanies;
    }
    
    
}