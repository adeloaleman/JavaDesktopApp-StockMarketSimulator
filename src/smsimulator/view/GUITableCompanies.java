package smsimulator.view;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import smsimulator.model.company.Company;
import smsimulator.Controler.MediatorInterface;


public class GUITableCompanies implements Component {
    private MediatorInterface mediator;

    public GUITableCompanies() {}
    
    
    public JTable createTableCompanies(ArrayList<Company> companies){
        
        int m = companies.size();
        int n = 4;
        String[][] data = new String[m][n];
        for (int i = 0 ; i < m ; i++) {
            data[i][0] = Integer.toString(companies.get(i).getId());
            data[i][1] = companies.get(i).getName();
            data[i][2] = Integer.toString(companies.get(i).getShares());
            data[i][3] = Double.toString(companies.get(i).getsharePrice());
        }
        
        String[] columnsNames = {"ID", "Name", "Shares", "Share price"};
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
        return "PanelCompanies";
    }
}
