package my.edu.utem.ftmk.dad.StudentExaminationAttendance.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="academicstaff")
public class AcademicStaff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column (name="StaffId") 
	private int staffId;
	
	@Column (name="StaffName")
	private String staffName;
	
	@Column (name="StaffPhoneNo")
	private String staffPhoneNo;
	
	@Column (name="StaffEmail")
	private String staffEmail;
	
	@OneToMany(mappedBy = "academicAdvisor")
    private List<Student> academicAdvisees;
	
	  public AcademicStaff() {
	        // Default constructor needed for JPA
	    }
	  
	public AcademicStaff(int staffId, String staffName) {
		this.staffId = staffId;
		this.staffName = staffName;
	}
	
	public int getStaffId() {
		return staffId;
	}
	
	public String getStaffName() {
		return staffName;
	}
	
	public String getStaffPhoneNo() {
		return staffPhoneNo;
	}
	public void setStaffPhoneNo(String staffPhoneNo) {
		this.staffPhoneNo = staffPhoneNo;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public List <Student> getAcademicAdvisees() {
		return academicAdvisees;
	}

	public void setAcademicAdvisees(List <Student> academicAdvisees) {
		this.academicAdvisees = academicAdvisees;
	}
	
}
