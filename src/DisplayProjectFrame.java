import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DisplayProjectFrame {
	private JFrame frame;
	private JTable table;
	
	public DisplayProjectFrame() {
		frame = new JFrame();
		frame.setTitle("Display Departments");
		
		int i = 0;
		String [] columnNames = {"Όνομα", "Περιγραφή", "Έσοδα","Ημ/νία Έναρξης", "Ημ/νία Περάτωσης"};
		String [][] data = new String[Main.allProjects.size()][columnNames.length];
		
		for(Project proj: Main.allProjects) {
			data[i][0] = proj.getProjName();
			data[i][1] = proj.getProjDescription();
			data[i][2]= String.valueOf(proj.getEarnings());
			data[i][3] = Main.dateFormat.format(proj.getStart());
			data[i][4] = Main.dateFormat.format(proj.getEnd());
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
