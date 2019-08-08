package smsimulator;

import java.util.ArrayList;

import smsimulator.model.company.Company;
import smsimulator.view.GUITableCompanies;

import smsimulator.model.investor.Investor;
import smsimulator.view.GUITableInvestors;

import smsimulator.model.transaction.Transaction;
import smsimulator.view.GUITableTransactions;

import smsimulator.model.InvestorsCompaniesCreator;
import smsimulator.model.TradingDaySimulation;

import smsimulator.Controler.Mediator;

import smsimulator.view.GUIMenuBar;
import smsimulator.Controler.MediatorInterface;
import smsimulator.view.GUIBarChartSummary;
import smsimulator.view.GUIOptionPane;
import smsimulator.view.GUITablesSummary;


public class SMSimulator {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        InvestorsCompaniesCreator setup = new InvestorsCompaniesCreator();
        setup.setCompanies(100);
        setup.setInvestors(100);
        
        ArrayList<Company>  companies = setup.getCompanies();
        ArrayList<Investor> investors = setup.getInvestors();
        
        TradingDaySimulation tds = new TradingDaySimulation();
        ArrayList<Transaction>  transactions = tds.tradingSimulator(companies, investors);

        
        MediatorInterface mediator = new Mediator(investors, companies, transactions);
        
        mediator.registerComponent(new GUITableInvestors());
        mediator.registerComponent(new GUITableCompanies());
        mediator.registerComponent(new GUITableTransactions());
        mediator.registerComponent(new GUIMenuBar());
        mediator.registerComponent(new GUIBarChartSummary());
        mediator.registerComponent(new GUITablesSummary());
        mediator.registerComponent(new GUIOptionPane());
        
        mediator.createGUI();
        
        
    }
    
}