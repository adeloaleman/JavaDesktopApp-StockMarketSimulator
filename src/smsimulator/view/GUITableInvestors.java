package smsimulator.view;

import java.util.ArrayList;
import javax.swing.JTable;
import smsimulator.model.investor.Investor;
import smsimulator.Controler.MediatorInterface;


public class GUITableInvestors implements Component {
    private MediatorInterface mediator;

    public GUITableInvestors() {}
    
    
    public JTable createTableInvestors(ArrayList<Investor> investors){
        int m = investors.size();
        int n = 4;
        String[][] data = new String[m][n];
        for (int i = 0 ; i < m ; i++) {
            data[i][0] = Integer.toString(investors.get(i).getId());
            data[i][1] = investors.get(i).getName();
            data[i][2] = Double.toString(investors.get(i).getBudget());
            System.out.println(data[i][1]);
        }
            
        String[] columnsNames = {"ID", "Name", "Budget"};
        JTable table = new JTable(data, columnsNames);
        
        return table;
    }
    
    
    @Override
    public void setMediator(MediatorInterface mediator) {
        this.mediator = mediator;
    }
    
    
    @Override
    public String getName() {
        return "PanelInvestors";
    }
}
