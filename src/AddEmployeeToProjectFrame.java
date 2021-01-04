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

public class AddEmployeeToProjectFrame implements ActionListener{
	private JComboBox<String> projectMenu;
	private JComboBox<String> employeeMenu;
	private JFrame frame;
	private JPanel employeeToDepPanel;
	private JButton confirmButton;
	private JLabel label;
	
	public AddEmployeeToProjectFrame() {
		Font font = new Font("Sans Serif", Font.BOLD, 16);
		frame = new JFrame("Add Employee to Project");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		employeeToDepPanel = new JPanel();
		label = new JLabel(">>");
		label.setFont(font);
		
		confirmButton = new JButton("Αποθήκευση");
		confirmButton.addActionListener(this);
		
		createProjectMenu();
		createEmployeeMenu();
		
		employeeToDepPanel.add(employeeMenu);
		employeeToDepPanel.add(label);
		employeeToDepPanel.add(projectMenu);
		employeeToDepPanel.add(confirmButton);
		
		frame.getContentPane().add(employeeToDepPanel);
		frame.setSize(400, 120);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}

	public void createProjectMenu() {
		ArrayList<String> projects = new ArrayList<String>();		
		String[] choices = {"Επιλογή έργου"};
		for(Project p: Main.allProjects) {
			projects.add(p.getProjName());	
		}
		
		if(projects.isEmpty() == false) {
			choices = (String[]) projects.toArray();
		}
		
		projectMenu = new JComboBox<>(choices);
		
	}
	
	public void createEmployeeMenu() {
		ArrayList<String> names = new ArrayList<String>();		
		String[] choices = {"Επιλογή υπ/λου"};
		for(Employee e : Main.allEmployees) {
			names.add(e.getFirstName() +" "+ e.getLastName());	
		}
		
		if(names.isEmpty() == false) {
			choices = (String[]) names.toArray();
		}
		
		employeeMenu = new JComboBox<>(choices);
		
	}

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
						if (p.getProjName().equals(projectSelection)) {
							p.addEmployOnProject(emp);
						}
					}
				}
			}
		}
	}
}
