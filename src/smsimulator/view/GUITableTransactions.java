package smsimulator.view;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import smsimulator.model.transaction.Transaction;
import smsimulator.Controler.MediatorInterface;



public class GUITableTransactions implements Component {
    private MediatorInterface mediator;


    public GUITableTransactions() {}
    
    
    public JTable createTableTransactions(ArrayList<Transaction> transactions){
        
        int m = transactions.size();
        int n = 5;
        String[][] data = new String[m][n];
        for (int i = 0 ; i < m ; i++) {
            data[i][0] = Integer.toString(transactions.get(i).getId());
            data[i][1] = Integer.toString(transactions.get(i).getInvestor().getId());
            data[i][2] = Integer.toString(transactions.get(i).getCompany().getId());
            data[i][3] = Double.toString(transactions.get(i).getTrasSharePrice());
            data[i][4] = transactions.get(i).getDate();
        }
        
        String[] columnsNames = {"ID", "Investor ID", "Company ID", "Transaction Share price", "Date"};
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
        return "PanelTransactions";
    }
}
