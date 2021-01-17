/* 
 * Onom/numo: Laskakis Spiridon - Karamouza Konstantina
 * AM: 3212019109 - 3212016057
 */ 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
//Afti einai i klasi eisagwgis tmhmatos apo ton xristi me grafiki diepafi
public class AddDepartmentFrame implements ActionListener{
	private JFrame frame;
	private JLabel depNameLabel, depDescriptionLabel;
	private JTextField depNameText;
	private JTextArea depDescriptionText;
	private JButton confirmButton;
	private JPanel depPanel;
	private JComboBox<String> directorMenu;
	private JLabel depDirectorLabel;
	
	//Constructor
	public AddDepartmentFrame() {
		//Border kai font gia tin emfanisimotita
		Font font = new Font("Sans Serif", Font.BOLD, 16);
		Border bor = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		// Dhmiourgia tou kentrikou frame
		frame = new JFrame("Add Department");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		//Kurio Panel kai koumpi apothikeusis
		depPanel = new JPanel();
		confirmButton = new JButton("Αποθήκευση");
		confirmButton.addActionListener(this);
		
		//Ruthmiseis emfanisis twn Label kai twn Textbox
		depNameLabel = new JLabel("Όνομα Τμήματος");
		depNameText = new JTextField(20);
		depNameLabel.setFont(font);
		depNameLabel.setBorder(bor);
		
		depDescriptionLabel = new JLabel("Περιγραφή Τμήματος");
		depDescriptionText = new JTextArea(10,20);
		depDescriptionLabel.setFont(font);
		depDescriptionLabel.setBorder(bor);
		
		depDirectorLabel = new JLabel("Διευθυντής Τμήματος");
		depDirectorLabel.setFont(font);
		depDirectorLabel.setBorder(bor);
		
		//Menou epilogwn dieuthinti
		createDirectorMenu();
		
		//Prosthiki olwn twn antikeimenwn sto Panel
		depPanel.add(depNameLabel);
		depPanel.add(depNameText);
		depPanel.add(depDescriptionLabel);
		depPanel.add(depDescriptionText);
		depPanel.add(depDirectorLabel);
		depPanel.add(directorMenu);
		depPanel.add(confirmButton);
		
	    depPanel.setMaximumSize(new Dimension(300, 500));
		
	    //Emfanisi tou frame ston xristi
		frame.getContentPane().add(depPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}
	
	//Methodos pou energopoieitai otan o xristis patisi to koumpi apothikeusis
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirmButton) {
			if(depNameText.getText().equals("") || depDescriptionText.getText().equals("")) {
				JOptionPane.showMessageDialog(frame, "Παρακαλώ εισάγετε όλα τα πεδία"); //Minima lathous se periptwsi poy den exei eisagei stoixeia o xristis
			}else {
				Department d = new Department(depNameText.getText(),depDescriptionText.getText()); //Eisagwgi dedomenwn se neo tmhma apo ta stoixeia pou edwse o xristis
				String dirSelection = String.valueOf(directorMenu.getSelectedItem());
				//Ean yparxei h epilogi dieuthinti tmhmatos anazitoume sto pinaka me toys upallilous to onom/numo tou dieuthinti  
				//kai ton kataxwroume stin antixstoixi metabliti toy tmhmatos
				if(!dirSelection.equals("Επιλογή...")) {
					for(Employee emp: Main.allEmployees) {
						if((emp.getFirstName()+ " " + emp.getLastName()).equals(dirSelection)) {
							DepartmentDirector depDir = new DepartmentDirector(emp);
							d.setDepartmentDirector(depDir);
						}
					}
				}
				Main.allDeparments.add(d); //Eisagwgi toy tmhmatos ston pinaka olwn twn tmimatwn
				JOptionPane.showMessageDialog(frame, "Το τμήμα <<" + depNameText.getText() + ">> καταχωρήθηκε με επιτυχία!"); //Minima epituxous kataxwrisis
				frame.dispose(); //Kleisimo parathurou
			}
		}
	}
	
	//Menou epilogwn gia ton dieuthinti toy tmhmatos
	public void createDirectorMenu() {
		ArrayList<String> names = new ArrayList<String>();		
		String[] choices = {"Επιλογή..."};
		for(Employee e : Main.allEmployees) {
			names.add(e.getFirstName() +" "+ e.getLastName());	
		}
		
		if(names.isEmpty() == false) {
			choices =  names.stream().toArray(String[]::new);
		}
		
		directorMenu = new JComboBox<>(choices);
		
	}
	
	
}
