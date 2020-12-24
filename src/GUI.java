import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class GUI implements ActionListener{
	JFrame frame;
	JMenuBar menuBar;
	JMenu m1, m2;
	JMenuItem m11, m22;
	JPanel panel1, panel2;
	JSplitPane mainPanel;
	ImageIcon img;
	JLabel createLabel = new JLabel("Δημιουργία", JLabel.CENTER);
	JLabel setProjectLabel = new JLabel("Αναθέσεις & Ενημέρωση", JLabel.CENTER);
	JLabel displayLabel = new JLabel("Εμφάνιση", JLabel.CENTER);
	JButton addDepartmentButton = new JButton("Εισαγωγή τμήματος");
	JButton addEmployeeButton = new JButton("Εισαγωγή υπαλλήλου");
	JButton addProjectButton = new JButton("Εισαγωγή έργων");
	JButton setProjectButton = new JButton("Εμφάνιση αναθέσεων");
	JButton updateButton = new JButton("Ενημέρωση δεδομένων");
	JButton displayDeprtmentButton = new JButton("Εμφάνιση όλων των τμημάτων");
	JButton displayEmployeeButton = new JButton("Εμφάνιση όλων των υπαλλήλων");
	JButton displayProjectButton = new JButton("Εμφάνιση όλων των έργων");
	JButton displaySalariesButton = new JButton("Εμφάνιση μισθοδοσίας υπαλλήλων");
	JButton displayEarningsButton = new JButton("Εμφάνιση εσόδων της εταιρίας");

	public GUI() {
		// Dhmiourgia tou Frame provolis
		frame = new JFrame("Company's Name");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 550);

		createMenu();
		createPanels();

		frame.getContentPane().add(BorderLayout.NORTH, menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}

	// Dhmiourgia xwrismenou panel gia tin kaluteri emfanisi kai
	// diataxi twn antikeimenwn tou
	private void createPanels() {
		mainPanel = new JSplitPane();
		panel1 = new JPanel();
		panel2 = new JPanel();
		Font font = new Font("Sans Serif", Font.BOLD, 18);
		Border bor = BorderFactory.createEmptyBorder(20, 10, 10, 10);

		//Eisagogi fotografias sto panel1 gia thn emfanisimotita
		img = new ImageIcon("images/IntroImage.png");
		Image image = img.getImage(); // transform it
		Image newimg = image.getScaledInstance(300, 250, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		img = new ImageIcon(newimg); // transform it back
		JLabel imgLabel = new JLabel("", img, JLabel.CENTER);
		imgLabel.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 10));
		panel1.add(imgLabel, BorderLayout.CENTER);
		
		//Dhmiourgia tou kurious panel twn epilogwn tou xristi 
		//dhladh thn kuria diepafi
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		
		//Ruthmiseis emfanisis twn Label kai twn Button
		createLabel.setFont(font);
		createLabel.setBorder(bor);
		setProjectLabel.setFont(font);
		setProjectLabel.setBorder(bor);
		displayLabel.setFont(font);
		displayLabel.setBorder(bor);
		
		//Enotita dhmiourgias
		panel2.add(createLabel);
		panel2.add(addDepartmentButton);
		panel2.add(addEmployeeButton);
		panel2.add(addProjectButton);
		
		//Enotita anathesis kai enhmerwsis
		panel2.add(setProjectLabel);
		panel2.add(setProjectButton);
		panel2.add(updateButton);
		
		//Enotita emfanisis upallilwn ergwn kai tmhmatwn
		panel2.add(displayLabel);
		panel2.add(displayDeprtmentButton);
		panel2.add(displayEmployeeButton);
		panel2.add(displayProjectButton);
		panel2.add(displaySalariesButton);
		panel2.add(displayEarningsButton);
		
		addDepartmentButton.addActionListener(this);
		addEmployeeButton.addActionListener(this);

		//Eisagwgi twn 2 upopanel sto kuriws panel kai
		//xwrismos me mia katheti grammi
		mainPanel.setLeftComponent(panel1);
		mainPanel.setRightComponent(panel2);
		mainPanel.setDividerSize(1);

	}

	// Dhmiourgia tou Menu kai prosthiki epilogwn
	public void createMenu() {
		menuBar = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Help");
		menuBar.add(m1);
		menuBar.add(m2);
		m11 = new JMenuItem("Open");
		m22 = new JMenuItem("Save as");
		m1.add(m11);
		m1.add(m22);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addDepartmentButton) {
			new AddDepartmentFrame();
		}else if(e.getSource() == addEmployeeButton) {
			new AddEmployeeFrame();
		}else if(e.getSource() == addProjectButton) {
			
		}else if(e.getSource() == setProjectButton) {
			
		}else if(e.getSource() == updateButton) {
			
		}else if(e.getSource() == displayDeprtmentButton) {
			
		}else if(e.getSource() == displayEarningsButton) {
			
		}else if(e.getSource() == displayEmployeeButton) {
			
		}else if(e.getSource() == displayProjectButton) {
			
		}else if(e.getSource() == displaySalariesButton) {
			
		}
	}

}
