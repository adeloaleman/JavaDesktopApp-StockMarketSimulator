package smsimulator.Controler;


import java.util.ArrayList;
import smsimulator.model.company.Company;
import smsimulator.model.investor.Investor;
import smsimulator.model.transaction.Transaction;
import smsimulator.view.GUITableInvestors;
import smsimulator.view.Component;

/**
 * Common mediator interface.
 */
public interface MediatorInterface {
    void registerComponent(Component component);
    void createGUI();
    
    ArrayList<Investor> getInvestors();
    ArrayList<Company> getCompanies();
    ArrayList<Transaction> getTransactions();
    
    void setPanelInvestors(GUITableInvestors panelInvestors);
    
    void newSimulation();
    void tableResults();
    void barChartResults();
    void openImputDialog();
    void setNumberCompanies(int numberCompanies);
    void setNumberInvestors(int numberInvestors);
    void setNewSim(boolean newSim);
    
    void openSimulationFromDB();
}
