/* 
 * Onom/numo: Laskakis Spiridon - Karamouza Konstantina
 * AM: 3212019109 - 3212016057
 */ 

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
//Afti einai h klasi pou dhmiourgei to frame gia tin provoli olwn twn tmhmatwn tis etairias
public class DisplayDepartmentFrame {
	private JFrame frame;
	private JTable table;
	
	//Constructor
	public DisplayDepartmentFrame() {
		frame = new JFrame();
		frame.setTitle("Display Departments");
		
		int i = 0;
		//Dhmiourgia stilwn me ta onomata twn stoixeiwn pou theloume na probaloume gia ta tmhmata
		String [] columnNames = {"Όνομα", "Περιγραφή", "Διευθυντής","Υπάλληλοι"};
		//2D pinakas me grammes osa einai ta tmhmata kai stiles oses plirofories theloume gia ayta
		String [][] data = new String[Main.allDeparments.size()][columnNames.length];
		
		//Eisagwgi twn plhroforiwn apo tin lista twn tmhmatwn se pinaka
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
		
		//Arxikopoisi tou pinaka kai eisagwgi sto kurio panel
		table = new JTable(data, columnNames);
		table.setEnabled(false);
		JScrollPane sp = new JScrollPane(table); 
		
		//Eisagwgi tou panel sto frame kai emfanisi ston xristi
        frame.add(sp); 
        frame.setSize(700, 500); 
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true); 
	}
	
}
