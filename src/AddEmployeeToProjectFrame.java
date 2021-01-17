/* 
 * Onom/numo: Laskakis Spiridon - Karamouza Konstantina
 * AM: 3212019109 - 3212016057
 */ 

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//Afti einai i klasi anathesis ergou se kapoion upallilo h se perissoterous upallilous
public class AddEmployeeToProjectFrame implements ActionListener{
	private JComboBox<String> projectMenu;
	private JComboBox<String> employeeMenu;
	private JFrame frame;
	private JPanel employeeToDepPanel;
	private JButton confirmButton;
	private JLabel label;
	
	//Constructor
	public AddEmployeeToProjectFrame() {
		//Border kai font gia tin emfanisimotita
		Font font = new Font("Sans Serif", Font.BOLD, 16);
		// Dhmiourgia tou kentrikou frame
		frame = new JFrame("Add Employee to Project");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		//Rythmiseis panel kai label
		employeeToDepPanel = new JPanel();
		label = new JLabel(">>");
		label.setFont(font);
		
		//Dhmiourgia koumpiou apothikeusis kai eisagwgi listener
		confirmButton = new JButton("Αποθήκευση");
		confirmButton.addActionListener(this);
		
		//Menou epilogis ergou
		createProjectMenu();
		//Menou epilogis upallilou
		createEmployeeMenu();
		
		//Prosthiki olwn twn antikeimenwn sto Panel
		employeeToDepPanel.add(employeeMenu);
		employeeToDepPanel.add(label);
		employeeToDepPanel.add(projectMenu);
		employeeToDepPanel.add(confirmButton);
		
	    //Emfanisi tou frame ston xristi
		frame.getContentPane().add(employeeToDepPanel);
		frame.setSize(600, 120);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}

	//Menou epilogis project
	public void createProjectMenu() {
		ArrayList<String> projects = new ArrayList<String>();		
		String[] choices = {"Επιλογή έργου"};
		for(Project p: Main.allProjects) {
			projects.add(p.getProjName());	
		}
		
		if(projects.isEmpty() == false) {
			choices = projects.stream().toArray(String[]::new);
		}
		
		projectMenu = new JComboBox<>(choices);
		
	}
	
	//Menou epilogis upallilou
	public void createEmployeeMenu() {
		ArrayList<String> names = new ArrayList<String>();		
		String[] choices = {"Επιλογή υπ/λου"};
		for(Employee e : Main.allEmployees) {
			names.add(e.getFirstName() +" "+ e.getLastName());	
		}
		
		if(names.isEmpty() == false) {
			choices = names.stream().toArray(String[]::new);
		}
		
		employeeMenu = new JComboBox<>(choices);
		
	}
	
	//Methodos pou energopoieitai otan o xristis patisi to koumpi apothikeusis
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmButton) {
			String employeeSelection = String.valueOf(employeeMenu.getSelectedItem());
			String projectSelection = String.valueOf(projectMenu.getSelectedItem());
			if(employeeSelection.equals("Επιλογή υπ/λου") || projectSelection.equals("Επιλογή έργου")) {
				JOptionPane.showMessageDialog(frame, "Δεν έχετε επιλέξει κάποιον υπάλληλο ή κάποιο έργο.");
			}else {
				for (Project p: Main.allProjects) {
					for (Employee emp: Main.allEmployees) {
						if (p.getProjName().equals(projectSelection) && employeeSelection.equals(emp.getFirstName() + " " + emp.getLastName())) {
							p.addEmployOnProject(emp);
							break;
						}
					}
				}
			}
		}
	}
}
