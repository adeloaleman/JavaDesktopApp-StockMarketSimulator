package smsimulator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import smsimulator.Controler.MediatorInterface;
import smsimulator.model.company.Company;
import smsimulator.model.company.MySQLCompanyDAO;
import smsimulator.model.investor.Investor;
import smsimulator.model.investor.MySQLInvestorDAO;
import smsimulator.model.transaction.MySQLTransactionDAO;
import smsimulator.model.transaction.Transaction;


public class GUIMenuBar extends JMenuBar implements Component {
    private MediatorInterface mediator;

    public GUIMenuBar(){
        // First JMenu
        JMenu file = new JMenu("File");
        this.add(file);
            JMenuItem save = new JMenuItem("Save to the DB (This can take a long time, try with a small simulation)");
            file.add(save);
            
            JMenuItem open = new JMenuItem("Open the last Simulation that was saved into the DB");
            file.add(open);
            
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MySQLCompanyDAO     dbComp = new MySQLCompanyDAO();
                MySQLInvestorDAO    dbInv  = new MySQLInvestorDAO();
                MySQLTransactionDAO dbTran = new MySQLTransactionDAO();
                
                dbComp.deleteAllFromCompany();
                dbComp.saveCompanies(mediator.getCompanies());
                
                dbInv.deleteAllFromInvestor();
                dbInv.saveInvestors(mediator.getInvestors());
                
                dbTran.deleteAllFromTransaction();
                dbTran.saveTransactions(mediator.getTransactions());
            }
        });
        
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                mediator.openSimulationFromDB();
            }
        });
            
            
        // Second JMenu
        JMenu simulation = new JMenu("Simulation");
        this.add(simulation);
            JMenuItem newsms = new JMenuItem("New Simulation");
            simulation.add(newsms);
            
        newsms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                mediator.newSimulation();
            }
        });
            
            
        JMenu results = new JMenu("Display results");
        this.add(results);
            JMenuItem tableStyle = new JMenuItem("Table style");
            results.add(tableStyle);
            JMenuItem barStyle = new JMenuItem("BarChart style");
            results.add(barStyle);
            
        tableStyle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                mediator.tableResults();
            }
        });            
            
        barStyle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                mediator.barChartResults();
            }
        });            
            

    }

    @Override
    public void setMediator(MediatorInterface mediator) {
        this.mediator = mediator;
    }


    @Override
    public String getName() {
        return "MenuBar";
    }
}
