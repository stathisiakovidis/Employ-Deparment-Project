import java.util.Date;

public class DepartmentDirector extends Employee{
	private Date dirRecruitementDate;
	
	public DepartmentDirector(Employee e) {
		super(e.getFirstName(),e.getLastName(),e.getBirtdayDate(),e.getFamilyCondition(),
				e.getChildrenNum(), e.getRecruitementYear(), e.getSpecialization(), e.getDegree());
		this.dirRecruitementDate = new Date(System.currentTimeMillis());
	}

	public Date getDirRecruitementDate() {
		return dirRecruitementDate;
	}

}
