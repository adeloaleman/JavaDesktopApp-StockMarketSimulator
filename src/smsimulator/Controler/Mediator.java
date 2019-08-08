package smsimulator.Controler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import smsimulator.model.investor.Investor;
import smsimulator.model.company.Company;
import smsimulator.model.transaction.Transaction;

import smsimulator.view.MainFrame;
import smsimulator.view.Component;

import smsimulator.view.GUITableInvestors;
import smsimulator.view.GUITableCompanies;
import smsimulator.view.GUITableTransactions;

import smsimulator.view.GUIMenuBar;

import smsimulator.model.InvestorsCompaniesCreator;
import smsimulator.model.TradingDaySimulation;
import smsimulator.model.company.MySQLCompanyDAO;
import smsimulator.model.investor.MySQLInvestorDAO;
import smsimulator.model.transaction.MySQLTransactionDAO;
import smsimulator.view.GUIBarChartSummary;
import smsimulator.view.GUIOptionPane;
import smsimulator.view.GUITablesSummary;


/**
 * Concrete mediator. All chaotic communications between concrete components
 * have been extracted to the mediator. Now components only talk with the
 * mediator, which knows who has to handle a request.
 */
public class Mediator implements MediatorInterface {
    
    private ArrayList<Investor>    investors;
    private ArrayList<Company>     companies;
    private ArrayList<Transaction> transactions;
    private int numberCompanies = 10;
    private int numberInvestors = 10;
    
    private JFrame frame;
    private GUITableInvestors    tableInvestors;
    private GUITableCompanies    tableCompanies;
    private GUITableTransactions tableTransactions;
    private GUIMenuBar           menuBar;
    private GUIBarChartSummary   barChart;
    private GUITablesSummary     tableSummary;
    private GUIOptionPane        optionPane;
    
    private JPanel panelTransactions, panelInvestors, panelCompanies, panelSummary, panelS;
    private JPanel panelCompaniesMaxcapital, panelCompaniesMincapital;
    private JPanel panelInvestorsMaxShares, panelInvestorsMinShares;
    private JPanel panelInvestorsMaxCompanies, panelInvestorsMinCompanies;
    
    private boolean newSim;
    
    public Mediator(ArrayList<Investor> investors, ArrayList<Company> companies, ArrayList<Transaction> transactions){
       this.investors    = investors;
       this.companies    = companies;
       this.transactions = transactions;
    }
    
    
    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "PanelInvestors":
                tableInvestors = (GUITableInvestors)component;
                break;
            case "PanelCompanies":
                tableCompanies = (GUITableCompanies)component;
                break;
            case "PanelTransactions":
                tableTransactions = (GUITableTransactions)component;
                break;
            case "MenuBar":
                menuBar = (GUIMenuBar)component;
                break;
            case "BarChart":
                barChart = (GUIBarChartSummary)component;
                break;
            case "GUITablesSummary":
                tableSummary = (GUITablesSummary)component;
                break;
            case "GUIOptionPane":
                optionPane = (GUIOptionPane)component;
                break;
        }
    }
    
    
    @Override
    public void createGUI() {
        
        frame = new MainFrame("Stock Market Simulator", 1145, 685, "src/smsimulator/view/icon.png");
        frame.setJMenuBar(menuBar);
        
        GridLayout grid1 = new GridLayout(2,2);
        frame.setLayout(grid1);
        
        // 1
        panelTransactions = new JPanel();
            panelTransactions.setBorder(BorderFactory.createTitledBorder(null, "Transactions", 0, 0, new Font("PLAIN", Font.BOLD, 12)));
            panelTransactions.setToolTipText("Transactions");
            JScrollPane scrollPaneT = new JScrollPane(tableTransactions.createTableTransactions(transactions));
            scrollPaneT.setPreferredSize(new Dimension(510, 300));
            panelTransactions.add(scrollPaneT);
            panelTransactions.revalidate();
        frame.add(panelTransactions);
                
        
        // 2
        panelSummary = new JPanel();
        panelSummary.setBorder(BorderFactory.createTitledBorder(null, "Summary of the Simulation", 0, 0, new Font("PLAIN", Font.BOLD, 12)));
        GridLayout gridp2 = new GridLayout(1,1);
        panelSummary.setLayout(gridp2);
        
            panelS = new JPanel();
            GridLayout grid21 = new GridLayout(3,2);
            panelS.setLayout(grid21);

                // 2.1
                panelCompaniesMaxcapital = new JPanel();
                panelCompaniesMaxcapital.setBorder(BorderFactory.createTitledBorder(null, "Companies with the highest capital", 0, 0, new Font("PLAIN", Font.BOLD, 11)));
                JScrollPane scrollPaneCompMaxCapital = new JScrollPane(tableSummary.createTableCompaniesMaxCapital(transactions, companies));
                scrollPaneCompMaxCapital.setPreferredSize(new Dimension(245, 75));
                panelCompaniesMaxcapital.add(scrollPaneCompMaxCapital);
                panelS.add(panelCompaniesMaxcapital);

                // 2.2
                panelCompaniesMincapital = new JPanel();
                panelCompaniesMincapital.setBorder(BorderFactory.createTitledBorder(null, "Companies with the lowest capital", 0, 0, new Font("PLAIN", Font.BOLD, 11)));
                JScrollPane scrollPaneCompMinCapital = new JScrollPane(tableSummary.createTableCompaniesMinCapital(transactions, companies));
                scrollPaneCompMinCapital.setPreferredSize(new Dimension(245, 75));
                panelCompaniesMincapital.add(scrollPaneCompMinCapital);
                panelS.add(panelCompaniesMincapital);

                // 2.3
                panelInvestorsMaxShares = new JPanel();
                panelInvestorsMaxShares.setBorder(BorderFactory.createTitledBorder(null, "Investor with the highest # of shares", 0, 0, new Font("PLAIN", Font.BOLD, 11)));
                JScrollPane scrollPaneInveMaxShares = new JScrollPane(tableSummary.createTableInvestorsMaxShares(transactions, investors));
                scrollPaneInveMaxShares.setPreferredSize(new Dimension(245, 75));
                panelInvestorsMaxShares.add(scrollPaneInveMaxShares);
                panelS.add(panelInvestorsMaxShares);

                // 2.4
                panelInvestorsMinShares = new JPanel();
                panelInvestorsMinShares.setBorder(BorderFactory.createTitledBorder(null, "Investor with the lowest # of shares", 0, 0, new Font("PLAIN", Font.BOLD, 11)));
                JScrollPane scrollPaneInveMinShares = new JScrollPane(tableSummary.createTableInvestorsMinShares(transactions, investors));
                scrollPaneInveMinShares.setPreferredSize(new Dimension(245, 75));
                panelInvestorsMinShares.add(scrollPaneInveMinShares);
                panelS.add(panelInvestorsMinShares);

                // 2.5
                panelInvestorsMaxCompanies = new JPanel();
                panelInvestorsMaxCompanies.setBorder(BorderFactory.createTitledBorder(null, "Investors that invested in most COs", 0, 0, new Font("PLAIN", Font.BOLD, 11)));
                JScrollPane scrollPaneInveMaxComp = new JScrollPane(tableSummary.createTableInvestorsMaxCompanies(transactions, companies, investors));
                scrollPaneInveMaxComp.setPreferredSize(new Dimension(245, 75));
                panelInvestorsMaxCompanies.add(scrollPaneInveMaxComp);
                panelS.add(panelInvestorsMaxCompanies);

                // 2.6
                panelInvestorsMinCompanies = new JPanel();
                panelInvestorsMinCompanies.setBorder(BorderFactory.createTitledBorder(null, "Investors that invested in less COs", 0, 0, new Font("PLAIN", Font.BOLD, 11)));
                JScrollPane scrollPaneInveMinComp = new JScrollPane(tableSummary.createTableInvestorsMinCompanies(transactions, companies, investors));
                scrollPaneInveMinComp.setPreferredSize(new Dimension(245, 75));
                panelInvestorsMinCompanies.add(scrollPaneInveMinComp);
                panelS.add(panelInvestorsMinCompanies);
            
            panelSummary.add(panelS);
            
        frame.add(panelSummary);
        
        
        
        // 3
        panelInvestors = new JPanel();
            panelInvestors.setBorder(BorderFactory.createTitledBorder(null, "Investors", 0, 0, new Font("PLAIN", Font.BOLD, 12)));
            panelInvestors.setToolTipText("Investors");
            JScrollPane scrollPaneI = new JScrollPane(tableInvestors.createTableInvestors(investors));
            scrollPaneI.setPreferredSize(new Dimension(510, 300));
            panelInvestors.add(scrollPaneI);
            panelInvestors.revalidate();
        frame.add(panelInvestors);

        
        // 4
        panelCompanies = new JPanel();
            panelCompanies.setBorder(BorderFactory.createTitledBorder(null, "Companies", 0, 0, new Font("PLAIN", Font.BOLD, 12)));
            panelCompanies.setToolTipText("Companies");
            JScrollPane scrollPanelC = new JScrollPane(tableCompanies.createTableCompanies(companies));
            scrollPanelC.setPreferredSize(new Dimension(510, 300));
            panelCompanies.add(scrollPanelC);
            panelCompanies.revalidate();
        frame.add(panelCompanies);


        frame.setVisible(true);
        frame.validate();
        frame.repaint();
        
    }
    
    
    @Override
    public void newSimulation() {
        InvestorsCompaniesCreator setup = new InvestorsCompaniesCreator();
        
        optionPane.inputDialog(); 
        
        if (newSim == true){
            
            Company.idAutoIncrement     = 0;
            Investor.idAutoIncrement    = 0;
            Transaction.idAutoIncrement = 0;

            setup.setCompanies(numberCompanies);
            setup.setInvestors(numberInvestors);
            companies = setup.getCompanies();
            investors = setup.getInvestors();

            TradingDaySimulation tds = new TradingDaySimulation();
            transactions = tds.tradingSimulator(companies, investors);

            registerComponent(new GUITableTransactions());
            registerComponent(new GUITableInvestors());
            registerComponent(new GUITableCompanies());

            JScrollPane scrollPaneT = new JScrollPane(tableTransactions.createTableTransactions(transactions));
            scrollPaneT.setPreferredSize(new Dimension(510, 300));

            JScrollPane ScrollPaneI = new JScrollPane(tableInvestors.createTableInvestors(investors));
            ScrollPaneI.setPreferredSize(new Dimension(510, 300));

            JScrollPane scrollPaneC = new JScrollPane(tableCompanies.createTableCompanies(companies));
            scrollPaneC.setPreferredSize(new Dimension(510, 300));

            JScrollPane scrollPaneCompMaxCapital = new JScrollPane(tableSummary.createTableCompaniesMaxCapital(transactions, companies));
            scrollPaneCompMaxCapital.setPreferredSize(new Dimension(245, 75));

            JScrollPane scrollPaneCompMinCapital = new JScrollPane(tableSummary.createTableCompaniesMinCapital(transactions, companies));
            scrollPaneCompMinCapital.setPreferredSize(new Dimension(245, 75));

            JScrollPane scrollPaneInveMaxShares = new JScrollPane(tableSummary.createTableInvestorsMaxShares(transactions, investors));
            scrollPaneInveMaxShares.setPreferredSize(new Dimension(245, 75));

            JScrollPane scrollPaneInveMinShares = new JScrollPane(tableSummary.createTableInvestorsMinShares(transactions, investors));
            scrollPaneInveMinShares.setPreferredSize(new Dimension(245, 75));

            JScrollPane scrollPaneInveMaxComp = new JScrollPane(tableSummary.createTableInvestorsMaxCompanies(transactions, companies, investors));
            scrollPaneInveMaxComp.setPreferredSize(new Dimension(245, 75));

            JScrollPane scrollPaneInveMinComp = new JScrollPane(tableSummary.createTableInvestorsMinCompanies(transactions, companies, investors));
            scrollPaneInveMinComp.setPreferredSize(new Dimension(245, 75));


            panelTransactions.removeAll();
            panelTransactions.repaint();
            panelTransactions.add(scrollPaneT);
            panelTransactions.revalidate();

            panelInvestors.removeAll();
            panelInvestors.repaint();
            panelInvestors.revalidate();
            panelInvestors.add(ScrollPaneI);

            panelCompanies.removeAll();
            panelCompanies.repaint();
            panelCompanies.revalidate();
            panelCompanies.add(scrollPaneC);    


            // Summary
            panelCompaniesMaxcapital.removeAll();
            panelCompaniesMaxcapital.repaint();
            panelCompaniesMaxcapital.revalidate();
            panelCompaniesMaxcapital.add(scrollPaneCompMaxCapital);

            panelCompaniesMincapital.removeAll();
            panelCompaniesMincapital.repaint();
            panelCompaniesMincapital.revalidate();
            panelCompaniesMincapital.add(scrollPaneCompMinCapital);

            panelInvestorsMaxShares.removeAll();
            panelInvestorsMaxShares.repaint();
            panelInvestorsMaxShares.revalidate();
            panelInvestorsMaxShares.add(scrollPaneInveMaxShares);

            panelInvestorsMinShares.removeAll();
            panelInvestorsMinShares.repaint();
            panelInvestorsMinShares.revalidate();
            panelInvestorsMinShares.add(scrollPaneInveMinShares);


            panelInvestorsMaxCompanies.removeAll();
            panelInvestorsMaxCompanies.repaint();
            panelInvestorsMaxCompanies.revalidate();
            panelInvestorsMaxCompanies.add(scrollPaneInveMaxComp);

            panelInvestorsMinCompanies.removeAll();
            panelInvestorsMinCompanies.repaint();
            panelInvestorsMinCompanies.revalidate();
            panelInvestorsMinCompanies.add(scrollPaneInveMinComp);

            tableResults();
            
            newSim = false;
                       
        }
        
    }
    
    @Override
    public void openSimulationFromDB(){
        MySQLCompanyDAO     dbComp = new MySQLCompanyDAO();
        MySQLInvestorDAO    dbInv  = new MySQLInvestorDAO();
        MySQLTransactionDAO dbTran = new MySQLTransactionDAO();
                
        companies = dbComp.getCompanies();
        investors = dbInv.getInvestors();
        transactions = dbTran.getTransactions(investors, companies);
        
        registerComponent(new GUITableTransactions());
            registerComponent(new GUITableInvestors());
            registerComponent(new GUITableCompanies());

            JScrollPane scrollPaneT = new JScrollPane(tableTransactions.createTableTransactions(transactions));
            scrollPaneT.setPreferredSize(new Dimension(510, 300));

            JScrollPane ScrollPaneI = new JScrollPane(tableInvestors.createTableInvestors(investors));
            ScrollPaneI.setPreferredSize(new Dimension(510, 300));

            JScrollPane scrollPaneC = new JScrollPane(tableCompanies.createTableCompanies(companies));
            scrollPaneC.setPreferredSize(new Dimension(510, 300));

            JScrollPane scrollPaneCompMaxCapital = new JScrollPane(tableSummary.createTableCompaniesMaxCapital(transactions, companies));
            scrollPaneCompMaxCapital.setPreferredSize(new Dimension(245, 75));

            JScrollPane scrollPaneCompMinCapital = new JScrollPane(tableSummary.createTableCompaniesMinCapital(transactions, companies));
            scrollPaneCompMinCapital.setPreferredSize(new Dimension(245, 75));

            JScrollPane scrollPaneInveMaxShares = new JScrollPane(tableSummary.createTableInvestorsMaxShares(transactions, investors));
            scrollPaneInveMaxShares.setPreferredSize(new Dimension(245, 75));

            JScrollPane scrollPaneInveMinShares = new JScrollPane(tableSummary.createTableInvestorsMinShares(transactions, investors));
            scrollPaneInveMinShares.setPreferredSize(new Dimension(245, 75));

            JScrollPane scrollPaneInveMaxComp = new JScrollPane(tableSummary.createTableInvestorsMaxCompanies(transactions, companies, investors));
            scrollPaneInveMaxComp.setPreferredSize(new Dimension(245, 75));

            JScrollPane scrollPaneInveMinComp = new JScrollPane(tableSummary.createTableInvestorsMinCompanies(transactions, companies, investors));
            scrollPaneInveMinComp.setPreferredSize(new Dimension(245, 75));


            panelTransactions.removeAll();
            panelTransactions.repaint();
            panelTransactions.add(scrollPaneT);
            panelTransactions.revalidate();

            panelInvestors.removeAll();
            panelInvestors.repaint();
            panelInvestors.revalidate();
            panelInvestors.add(ScrollPaneI);

            panelCompanies.removeAll();
            panelCompanies.repaint();
            panelCompanies.revalidate();
            panelCompanies.add(scrollPaneC);    


            // Summary
            panelCompaniesMaxcapital.removeAll();
            panelCompaniesMaxcapital.repaint();
            panelCompaniesMaxcapital.revalidate();
            panelCompaniesMaxcapital.add(scrollPaneCompMaxCapital);

            panelCompaniesMincapital.removeAll();
            panelCompaniesMincapital.repaint();
            panelCompaniesMincapital.revalidate();
            panelCompaniesMincapital.add(scrollPaneCompMinCapital);

            panelInvestorsMaxShares.removeAll();
            panelInvestorsMaxShares.repaint();
            panelInvestorsMaxShares.revalidate();
            panelInvestorsMaxShares.add(scrollPaneInveMaxShares);

            panelInvestorsMinShares.removeAll();
            panelInvestorsMinShares.repaint();
            panelInvestorsMinShares.revalidate();
            panelInvestorsMinShares.add(scrollPaneInveMinShares);


            panelInvestorsMaxCompanies.removeAll();
            panelInvestorsMaxCompanies.repaint();
            panelInvestorsMaxCompanies.revalidate();
            panelInvestorsMaxCompanies.add(scrollPaneInveMaxComp);

            panelInvestorsMinCompanies.removeAll();
            panelInvestorsMinCompanies.repaint();
            panelInvestorsMinCompanies.revalidate();
            panelInvestorsMinCompanies.add(scrollPaneInveMinComp);

            tableResults();
                
    }
    
    
    @Override
    public void tableResults(){
        
        panelSummary.removeAll();
        panelSummary.repaint();
        panelSummary.revalidate();
        panelSummary.add(panelS);
        
    }
    
    
    @Override
    public void barChartResults(){
       
        barChart.setPreferredSize(new Dimension(510, 300));
        
        panelSummary.removeAll();
        panelSummary.repaint();
        panelSummary.revalidate();
        panelSummary.add(barChart);
       
        
    }
    
    
    @Override
    public void openImputDialog(){
        int i = 1;
    }
    
    
    @Override
    public ArrayList<Company> getCompanies(){
        return companies;
    }
    
    
    @Override
    public ArrayList<Investor> getInvestors() {
        return investors;
    }
    
    
    @Override
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    
    
    @Override
    public void setPanelInvestors(GUITableInvestors panelInvestors){
        this.tableInvestors = panelInvestors;
    }
    

    @Override
    public void setNumberCompanies(int numberCompanies){
        this.numberCompanies = numberCompanies;
    }
    
    @Override
    public void setNumberInvestors(int numberInvestors){
        this.numberInvestors = numberInvestors;
    }
    
    @Override
    public void setNewSim(boolean newSim){
        this.newSim = newSim;
    }
 
    
}