package smsimulator.view;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;


public class MainFrame extends JFrame {
    
    static int xSize;
    static int ySize;

    public MainFrame() {
    }
    
    public MainFrame(String frameTitle, int frameWidth, int frameHeight, String iconName) {
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.xSize = (int)tk.getScreenSize().getWidth();
        this.ySize = (int)tk.getScreenSize().getHeight();
        
        this.setLayout(null);
        this.setTitle(frameTitle);
        this.setSize(MainFrame.xCoordinate(frameWidth), MainFrame.yCoordinate(frameHeight));

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(iconName));
        UIManager.put("ToolTip.font", new FontUIResource("PLAIN", Font.BOLD, MainFrame.xCoordinate(12)));
    
        this.validate();
        this.repaint();    
    }
    
    static public int xCoordinate(double number) {
        return (int) Math.round(1.0*xSize*number/1366.0);
    }
    
    static public int yCoordinate(double number) {
        return (int) Math.round(1.0*ySize*number/768.0);
    }
    
}
