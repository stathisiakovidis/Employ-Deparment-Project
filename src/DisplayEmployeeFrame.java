/* 
 * Onom/numo: Laskakis Spiridon - Karamouza Konstantina
 * AM: 3212019109 - 3212016057
 */ 

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//Afti einai h klasi pou dimiourgei to frame gia tin proboli olwn twn upallilwn tis etairias
public class DisplayEmployeeFrame {
	private JFrame frame;
	private JTable table;
	
	//Constructor tis klasis
	public DisplayEmployeeFrame() {
		frame = new JFrame();
		frame.setTitle("Display Employees");
		
		//Dhmiourgia stilwn me ta onomata twn stoixeiwn pou theloume na probaloume gia tous upallilous
		int i = 0;
		String [] columnNames = {"Όνομα", "Επώνυμο", "Ημ/νία Γέννησης","Οικ/κή κατάσταση", "Αριθμός παιδιών", "Έτος πρόσληψης", 
				"Ειδικότητα", "Εκπαίδευση"};
		//2D pinakas me grammes osoi einai oi upalliloi kai stiles oses plirofories theloume gia aytous
		String [][] data = new String[Main.allEmployees.size()][columnNames.length];
		
		//Eisagwgi twn plhroforiwn apo tin lista twn upallilwn se pinaka
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
		
		//Arxikopoisi tou pinaka kai eisagwgi sto kurio panel
		table = new JTable(data, columnNames);
		table.setEnabled(false);
		JScrollPane sp = new JScrollPane(table); 
		
		//Eisagwgi tou panel sto frame kai emfanisi ston xristi
        frame.add(sp); 
        frame.setSize(1200, 500); 
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true); 
	}
}
