package smsimulator.view;

import javax.swing.*;
import smsimulator.Controler.MediatorInterface;

public class GUIOptionPane1 implements Component {
    
    private MediatorInterface mediator;
    
   public GUIOptionPane1() {}
   
      public void inputDialog() {
      JTextField numberCompanies = new JTextField(5);
      JTextField numberInvestors = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Nº of Companies:"));
      myPanel.add(numberCompanies);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Nº of Investors:"));
      myPanel.add(numberInvestors);

      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Enter the number of Companies and Investors", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
          if (!numberCompanies.getText().equals("") && !numberInvestors.getText().equals("") && 
              numberInvestors.getText().matches("[0-9]+") && numberCompanies.getText().matches("[0-9]+") ){
            int numberCompaniesInt = Integer.parseInt(numberCompanies.getText());
            int numberInvestorsInt = Integer.parseInt(numberInvestors.getText());
            
            if (numberCompaniesInt > 0 && numberCompaniesInt <= 100 &&
                numberInvestorsInt > 0 && numberInvestorsInt <= 100  ){
                
                mediator.setNumberCompanies(numberCompaniesInt);
                mediator.setNumberInvestors(numberInvestorsInt);
                mediator.setNewSim(true);
            }else{
                JOptionPane.showMessageDialog(null, "Please enter an integer between 1 and 100 (No blank space)", "Wrong input", JOptionPane.ERROR_MESSAGE);
                this.inputDialog();
            }
          }
          else{
               JOptionPane.showMessageDialog(null, "Please enter an integer between 1 and 100 (No blank space)", "Wrong input", JOptionPane.ERROR_MESSAGE);
               this.inputDialog();
          }
          
      }
   }

    @Override
    public void setMediator(MediatorInterface mediator) {
        this.mediator = mediator;
    }


    @Override
    public String getName() {
        return "GUIOptionPane";
    }
}