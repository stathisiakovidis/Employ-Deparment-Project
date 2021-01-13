import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;
//Afti h klasi analambanei tin diaxeirisi twn arxeiwn
public class FileReader {

	private File file;
	private Scanner scanner;

	public FileReader(File selectedFile) { //Ston constructor eisagoume ws parametro to arxeio apo ton file explorer
		try {
			this.file = selectedFile;
			if (file.canRead() == false) { //Se periptwsi pou to arxeio den mporei na diabastei emfanizetai minima lathous
				JOptionPane.showMessageDialog(null, "Το αρχείο δεν μπορεί να διαβαστεί!");
			}
			scanner = new Scanner(file); //O scanner xrisimopoieitai gia to diavasma tou arxeiou
			if (file.getName().equals("Projects.txt")) { //Me basi to onoma tou arxeiou kanoume tis parakatw energeies. Stin sugkekrimeni periptwsi eisagoume ta project
				while (scanner.hasNextLine()) {
					String data = scanner.nextLine(); //Diavasma toy arxeiou grammi pros grammi
					String[] parts = data.split("\\:"); //Me ton entopismou toy sumbolou : xwrizoyme tis plirofories kai tis eisagoume se enan pinaka
					String pName = parts[0]; //To 1o stoixeio tou pinaka einai to onoma tou project
					String pDescription = parts[1]; //To 2o stoixeio tou pinaka einai h perigrafi tou project
					try {
						int pEarnings = Integer.valueOf(parts[2]); //To 3o stoixeio tou pinaka einai ta esoda tou project
						Date pStartDate = Main.dateFormat.parse(parts[3]); //To 4o stoixeio tou pinaka einai h hmeromhnia enarxis tou project
						Date pEndDate = Main.dateFormat.parse(parts[4]); //To 5o stoixeio tou pinaka einai h hmeromhnia lixis tou project
						Project project = new Project(pName, pDescription, pEarnings, pStartDate, pEndDate); //Dhmiourgia project metablitis
						Main.allProjects.add(project); //Eisagwgi project ston pinaka twn project sthn main
					} catch (ParseException e) {
						JOptionPane.showMessageDialog(null, "Το αρχείο δεν είναι σωστά δομημένο!"); //Elegxos orthotitas twn dedomenwn
						e.printStackTrace();
					}
				}
			}else if(file.getName().equals("Departments.txt")) { //Stin sugkekrimeni periptwsi eisagoume ta tmhmata
				while (scanner.hasNextLine()) {
					String data = scanner.nextLine(); //Diavasma toy arxeiou grammi pros grammi
					String[] parts = data.split("\\:"); //Me ton entopismou toy sumbolou : xwrizoyme tis plirofories kai tis eisagoume se enan pinaka
					String dName = parts[0]; //To 1o stoixeio tou pinaka einai to onoma tou tmhmatos
					String dDescription = parts[1]; //To 2o stoixeio tou pinaka einai h perigrafi toy tmhmtos
					Department department = new Department(dName, dDescription); //Dhmiourgia department metablitis
					Main.allDeparments.add(department); //Eisagwgi department ston pinaka twn department sthn main
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //Elegxos euresis arxeiou
		}
	}

}
