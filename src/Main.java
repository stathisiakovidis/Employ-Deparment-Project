/* 
 * Onom/numo: Laskakis Spiridon - Karamouza Konstantina
 * AM: 3212019109 - 3212016057
 * 
 * Sto project periexontai epishs ena exwteriko .jar arxeio gia tin emfanisi hmerologiou mesa ston fakelo ExternalJar, 
 * enas fakelos gia tin apothikeush twn arxeiwn pou apaitountai apo thn ekfwnisi, enas fakelos gia fwtografies
 * pou mporei na prostethoun sto programma kai h adeia gia CC.
 * 
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//Afti einai h kuria klasi Main, h arxh tou programmatos.
public class Main {
	
	static final ArrayList<Department> allDeparments = new ArrayList<>(); //Pinakas twn tmhmatwn tou programmatos
	static final ArrayList<Employee> allEmployees = new ArrayList<>(); //Pinakas twn upallhlwn tou programmatos
	static final ArrayList<Project> allProjects = new ArrayList<>(); //Pinakas twn project tou programmatos
	static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); //Format tis hmeromhnias gia geniki xrisi
	
	public static void main(String[] args) {
		new GUI(); //Anoigma tis klasis tou grafikou perivallontos
		
	}

}
