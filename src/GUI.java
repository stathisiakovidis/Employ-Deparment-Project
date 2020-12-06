import java.awt.*;

import javax.swing.*;
public class GUI {
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu m1,m2;
	private JMenuItem m11,m22;
	private JPanel panel1,panel2;
	private JPanel mainPanel;
	
	public GUI() {
		//Dhmiourgia tou Frame provolis
		frame = new JFrame("Company's Name");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		//Dhmiourgia tou Menu kai prosthiki epilogwn
		menuBar = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Help");
		menuBar.add(m1);
		menuBar.add(m2);
		m11 = new JMenuItem("Open");
		m22 = new JMenuItem("Save as");
		m1.add(m11);
		m1.add(m22);
        
        //Dhmiourgia xwrismenou panel gia tin kaluteri emfanisi kai
        //diataxi twn antikeimenwn tou
		mainPanel = new JPanel(new BorderLayout());
        panel1 = new JPanel();
        panel2 = new JPanel();
        mainPanel.add(panel1, BorderLayout.WEST);
        mainPanel.add(panel2, BorderLayout.EAST);
   
        
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, 
        		dim.height/2-frame.getSize().height/2);
	}
	
}
