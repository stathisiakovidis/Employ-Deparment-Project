/* 
 * Onom/numo: Laskakis Spiridon - Karamouza Konstantina
 * AM: 3212019109 - 3212016057
 */ 

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//Afti einai h klasi pou dimiourgei to frame gia tin proboli olwn twn ergwn tis etairias
public class DisplayProjectFrame {
	private JFrame frame;
	private JTable table;
	
	//Constructor tis klasis
	public DisplayProjectFrame() {
		frame = new JFrame();
		frame.setTitle("Display Projects");
		
		//Dhmiourgia stilwn me ta onomata twn stoixeiwn pou theloume na probaloume gia ta erga
		int i = 0;
		String [] columnNames = {"Όνομα", "Περιγραφή", "Έσοδα","Ημ/νία Έναρξης", "Ημ/νία Περάτωσης"};
		//2D pinakas me grammes osa einai ta erga kai stiles oses plirofories theloume gia ayta
		String [][] data = new String[Main.allProjects.size()][columnNames.length];
		
		//Eisagwgi twn plhroforiwn apo tin lista twn ergwn ston pinaka
		for(Project proj: Main.allProjects) {
			data[i][0] = proj.getProjName();
			data[i][1] = proj.getProjDescription();
			data[i][2]= String.valueOf(proj.getEarnings());
			data[i][3] = Main.dateFormat.format(proj.getStart());
			data[i][4] = Main.dateFormat.format(proj.getEnd());
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
