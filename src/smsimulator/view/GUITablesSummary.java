package smsimulator.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import smsimulator.Controler.MediatorInterface;
import smsimulator.model.SimulationResultsSummary;
import smsimulator.model.company.Company;
import smsimulator.model.investor.Investor;
import smsimulator.model.transaction.Transaction;


public class GUITablesSummary implements Component {
    private MediatorInterface mediator;

    public GUITablesSummary() {}
    
    
    public JTable createTableCompaniesMaxCapital(ArrayList<Transaction> transactions, ArrayList<Company> companies){
        
        SimulationResultsSummary summary = new SimulationResultsSummary();
        ArrayList<Double> companiesCapital = summary.getCompaniesCapital(transactions, companies);
        ArrayList<Integer> companiesMaxCapital = summary.getCompaniesMaxCapital(companiesCapital);
        
        int m = companiesMaxCapital.size();
        int n = 3;
        String[][] data = new String[m][n];
        for (int i = 0 ; i < m ; i++) {
            int indexCompany = companiesMaxCapital.get(i);
            data[i][0] = Integer.toString(companies.get(indexCompany).getId());
            data[i][1] = companies.get(indexCompany).getName();
            data[i][2] = Double.toString(Collections.max(companiesCapital));
        }
        
        String[] columnsNames = {"ID", "Name", "Capital"};
        JTable table = new JTable(data, columnsNames);
        JScrollPane barrapanel = new JScrollPane(table);
        barrapanel.setPreferredSize(new Dimension(510, 300));
        
        return table;
        
    }
        
    
    public JTable createTableCompaniesMinCapital(ArrayList<Transaction> transactions, ArrayList<Company> companies){
        
        SimulationResultsSummary summary = new SimulationResultsSummary();
        ArrayList<Double> companiesCapital = summary.getCompaniesCapital(transactions, companies);
        ArrayList<Integer> companiesMinCapital = summary.getCompaniesMinCapital(companiesCapital);
        
        int m = companiesMinCapital.size();
        int n = 3;
        String[][] data = new String[m][n];
        for (int i = 0 ; i < m ; i++) {
            int indexCompany = companiesMinCapital.get(i);
            data[i][0] = Integer.toString(companies.get(indexCompany).getId());
            data[i][1] = companies.get(indexCompany).getName();
            data[i][2] = Double.toString(Collections.min(companiesCapital));
        }
        
        String[] columnsNames = {"ID", "Name", "Capital"};
        JTable table = new JTable(data, columnsNames);
        JScrollPane barrapanel = new JScrollPane(table);
        barrapanel.setPreferredSize(new Dimension(510, 300));
        
        return table;
        
    }
    
    
    
    public JTable createTableInvestorsMaxShares(ArrayList<Transaction> transactions, ArrayList<Investor> investors){
        
        SimulationResultsSummary summary = new SimulationResultsSummary();
        ArrayList<Integer> investorsNumberOfShares = summary.getInvestorsNumberOfShares(transactions, investors);
        
        for (int i = 0 ; i < investorsNumberOfShares.size() ; i++){
            System.out.println(investorsNumberOfShares.get(i));
        }
        
        ArrayList<Integer> investorsMaxShares = summary.getInvestorsMaxShares(investorsNumberOfShares);
        
        int m = investorsMaxShares.size();
        int n = 3;
        String[][] data = new String[m][n];
        for (int i = 0 ; i < m ; i++) {
            int indexInvestor = investorsMaxShares.get(i);
            data[i][0] = Integer.toString(investors.get(indexInvestor).getId());
            data[i][1] = investors.get(indexInvestor).getName();
            data[i][2] = Double.toString(Collections.max(investorsNumberOfShares));
        }
        
        String[] columnsNames = {"ID", "Name", "Number of Shares"};
        JTable table = new JTable(data, columnsNames);
        JScrollPane barrapanel = new JScrollPane(table);
        barrapanel.setPreferredSize(new Dimension(510, 300));
        
        return table;
        
    }
    
    
    
    public JTable createTableInvestorsMinShares(ArrayList<Transaction> transactions, ArrayList<Investor> investors){
        
        SimulationResultsSummary summary = new SimulationResultsSummary();
        ArrayList<Integer> investorsNumberOfShares = summary.getInvestorsNumberOfShares(transactions, investors);
        ArrayList<Integer> investorsMinShares = summary.getInvestorsMinShares(investorsNumberOfShares);
        
        int m = investorsMinShares.size();
        int n = 3;
        String[][] data = new String[m][n];
        for (int i = 0 ; i < m ; i++) {
            int indexInvestor = investorsMinShares.get(i);
            data[i][0] = Integer.toString(investors.get(indexInvestor).getId());
            data[i][1] = investors.get(indexInvestor).getName();
            data[i][2] = Double.toString(Collections.min(investorsNumberOfShares));
        }
        
        String[] columnsNames = {"ID", "Name", "Number of Shares"};
        JTable table = new JTable(data, columnsNames);
        JScrollPane barrapanel = new JScrollPane(table);
        barrapanel.setPreferredSize(new Dimension(510, 300));
        
        return table;
        
    }
    
    
    
    
    public JTable createTableInvestorsMaxCompanies(ArrayList<Transaction> transactions, ArrayList<Company> companies, ArrayList<Investor> investors){
        
        SimulationResultsSummary summary = new SimulationResultsSummary();
        ArrayList<Integer> numberOfCompaniesByInvestor = summary.getNumberOfCompaniesByInvestor(transactions, investors);
        
        ArrayList<Integer> investorsMaxCompanies = summary.getInvestorsMaxCompanies(numberOfCompaniesByInvestor);
        
        int m = investorsMaxCompanies.size();
        int n = 3;
        String[][] data = new String[m][n];
        for (int i = 0 ; i < m ; i++) {
            int indexInvestor = investorsMaxCompanies.get(i);
            data[i][0] = Integer.toString(investors.get(indexInvestor).getId());
            data[i][1] = investors.get(indexInvestor).getName();
            data[i][2] = Double.toString(Collections.max(numberOfCompaniesByInvestor));
        }
        
        String[] columnsNames = {"ID", "Name", "Number of companies"};
        JTable table = new JTable(data, columnsNames);
        JScrollPane barrapanel = new JScrollPane(table);
        barrapanel.setPreferredSize(new Dimension(510, 300));
        
        return table;
        
    }
    
    
    
    public JTable createTableInvestorsMinCompanies(ArrayList<Transaction> transactions, ArrayList<Company> companies, ArrayList<Investor> investors){
        
        SimulationResultsSummary summary = new SimulationResultsSummary();
        ArrayList<Integer> numberOfCompaniesByInvestor = summary.getNumberOfCompaniesByInvestor(transactions, investors);
        
        ArrayList<Integer> investorsMinCompanies = summary.getInvestorsMinCompanies(numberOfCompaniesByInvestor);
        
        int m = investorsMinCompanies.size();
        int n = 3;
        String[][] data = new String[m][n];
        for (int i = 0 ; i < m ; i++) {
            int indexInvestor = investorsMinCompanies.get(i);
            data[i][0] = Integer.toString(investors.get(indexInvestor).getId());
            data[i][1] = investors.get(indexInvestor).getName();
            data[i][2] = Double.toString(Collections.min(numberOfCompaniesByInvestor));
        }
        
        String[] columnsNames = {"ID", "Name", "Number of companies"};
        JTable table = new JTable(data, columnsNames);
        JScrollPane barrapanel = new JScrollPane(table);
        barrapanel.setPreferredSize(new Dimension(510, 300));
        
        return table;
        
    }        
    
    
   
    @Override
    public void setMediator(MediatorInterface mediator) {
        this.mediator = mediator;
    }


    @Override
    public String getName() {
        return "GUITablesSummary";
    }
}
