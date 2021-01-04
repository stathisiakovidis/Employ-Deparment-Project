import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DisplayEmployeeFrame {
	private JFrame frame;
	private JTable table;
	
	public DisplayEmployeeFrame() {
		frame = new JFrame();
		frame.setTitle("Display Departments");
		
		int i = 0;
		String [] columnNames = {"Όνομα", "Επώνυμο", "Ημ/νία Γέννησης","Οικ/κή κατάσταση", "Αριθμός παιδιών", "Έτος πρόσληψης", 
				"Ειδικότητα", "Εκπαίδευση"};
		String [][] data = new String[Main.allEmployees.size()][columnNames.length];
		
		for(Employee emp: Main.allEmployees) {
			data[i][0] = emp.getFirstName();
			data[i][1] = emp.getLastName(); 
			data[i][2] = Main.dateFormat.format(emp.getBirtdayDate());;
			data[i][3] = emp.getFamilyCondition();
			data[i][4] = String.valueOf(emp.getChildrenNum());
			data[i][5] = String.valueOf(emp.getRecruitementYear());
			data[i][6] = emp.getSpecialization();
			data[i][7] = emp.getDegree();
			i++;
		}
		
		table = new JTable(data, columnNames);
		table.setEnabled(false);
		JScrollPane sp = new JScrollPane(table); 
		
        frame.add(sp); 
        frame.setSize(1200, 500); 
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true); 
	}
}
