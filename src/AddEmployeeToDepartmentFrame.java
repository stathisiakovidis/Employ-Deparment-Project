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
//Afti einai i klasi eisagwgis upallilou se tmhma tis etairias apo ton xristi me grafiki diepafi
public class AddEmployeeToDepartmentFrame implements ActionListener{
	
	private JComboBox<String> departmentMenu;
	private JComboBox<String> employeeMenu;
	private JFrame frame;
	private JPanel employeeToDepPanel;
	private JButton confirmButton;
	private JLabel label;
	
	//Constructor
	public AddEmployeeToDepartmentFrame() {
		//Font gia tin emfanisimotita
		Font font = new Font("Sans Serif", Font.BOLD, 16);
		// Dhmiourgia tou kentrikou frame
		frame = new JFrame("Add Employee to Department");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		//Ruthmiseis emfanisis twn Label 
		employeeToDepPanel = new JPanel();
		label = new JLabel(">>");
		label.setFont(font);
		
		//Dhmiourgia koumpiou apothikeusis kai eisagwgi listener
		confirmButton = new JButton("Αποθήκευση");
		confirmButton.addActionListener(this);
		
		//Menou epilogis tmhmatos
		createDepartmentMenu();
		//Menou epilogis upallilou
		createEmployeeMenu();
		
		//Prosthiki olwn twn antikeimenwn sto Panel
		employeeToDepPanel.add(employeeMenu);
		employeeToDepPanel.add(label);
		employeeToDepPanel.add(departmentMenu);
		employeeToDepPanel.add(confirmButton);
		
	    //Emfanisi tou frame ston xristi
		frame.getContentPane().add(employeeToDepPanel);
		frame.setSize(600, 120);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}

	//Menou epilogis tmhmatos
	public void createDepartmentMenu() {
		ArrayList<String> departments = new ArrayList<String>();		
		String[] choices = {"Επιλογή τμ/τος"};
		for(Department d : Main.allDeparments) {
			departments.add(d.getDepName());	
		}
		
		if(departments.isEmpty() == false) {
			choices = departments.stream().toArray(String[]::new);
		}
		
		departmentMenu = new JComboBox<>(choices);
		
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
			String departmentSelection = String.valueOf(departmentMenu.getSelectedItem());
			if(employeeSelection.equals("Επιλογή υπ/λου") || departmentSelection.equals("Επιλογή τμ/τος")) {
				JOptionPane.showMessageDialog(frame, "Δεν έχετε επιλέξει κάποιον υπάλληλο ή κάποιο τμήμα.");
			}else {
				for (Department d: Main.allDeparments) {
					for (Employee emp: Main.allEmployees) {
						String name = emp.getFirstName() + " " + emp.getLastName();
						if (d.getDepName().equals(departmentSelection) && name.equals(employeeSelection)) {
							d.setEmployeeToDepartment(emp);
						}
					}
				}
			}
		}
	}
}
