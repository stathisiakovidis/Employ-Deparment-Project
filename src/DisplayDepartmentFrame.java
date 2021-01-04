import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class DisplayDepartmentFrame {
	private JFrame frame;
	private JTable table;
	
	public DisplayDepartmentFrame() {
		frame = new JFrame();
		frame.setTitle("Display Departments");
		
		int i = 0;
		String [] columnNames = {"Όνομα", "Περιγραφή", "Διευθυντής","Υπάλληλοι"};
		String [][] data = new String[Main.allDeparments.size()][columnNames.length];
		
		for(Department d: Main.allDeparments) {
			data[i][0] = d.getDepName();
			data[i][1] = d.getDepDescription();
			if(d.getDepartmentDirector() != null) {
				data[i][2] = d.getDepartmentDirector().getFirstName() + " " + d.getDepartmentDirector().getLastName();
			}else {
				data[i][2] = " ";
			}
			
			for (Employee e: d.getAllDepartmentsEmployees()) {
				data[i][3] += e.getFirstName() + " " + e.getLastName() + ", ";
			}
			i++;
		}
		
		table = new JTable(data, columnNames);
		table.setEnabled(false);
		JScrollPane sp = new JScrollPane(table); 
		
        frame.add(sp); 
        frame.setSize(700, 500); 
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true); 
	}
	
}
