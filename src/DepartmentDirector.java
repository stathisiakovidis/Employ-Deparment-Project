/* 
 * Onom/numo: Laskakis Spiridon - Karamouza Konstantina
 * AM: 3212019109 - 3212016057
 */ 

import java.util.Date;
//Afti einai i upoklasi tou dieuthinti tmhmatos. Anhkei stin klasi Employee
public class DepartmentDirector extends Employee{
	private Date dirRecruitementDate;
	
	//Constructor
	public DepartmentDirector(Employee e) {
		//Me tin methodo super pairnoume ta stoixeia tou upallilou apo tin klasi Employee kai
		//dhmiourgoume ena antikeimeno DepartmentDirector h alliws dieuthintis tmhmatos
		//H kainourgia metabliti poy prostithetai einai to etos proslipsis toy upallilou
		super(e.getFirstName(),e.getLastName(),e.getBirtdayDate(),e.getFamilyCondition(),
				e.getChildrenNum(), e.getRecruitementYear(), e.getSpecialization(), e.getDegree());
		this.dirRecruitementDate = new Date(System.currentTimeMillis());
	}
	
	//Getters kai Setters
	public Date getDirRecruitementDate() {
		return dirRecruitementDate;
	}

}
