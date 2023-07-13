package my.edu.utem.ftmk.dad.StudentExaminationAttendance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //The annotation represents the field as the primary key and the value of the key auto incremental
	@Column (name="StdId")
	private int stdId;
	
	@Column (name="MatricNo")
	private String matricNo;
	
	@Column (name="StdName")
	private String stdName;
	
	@Column (name="Programme")
	private String programme;

	@Column (name="StdEmail")
	private String stdEmail;
	
	@Column (name="StdPhoneNo")
	private String stdPhoneNo;
	
	@ManyToOne
	@JoinColumn(name = "StaffId")
	private AcademicStaff academicAdvisor;

	
	@ManyToOne
	@JoinColumn(name = "CourseId")
	private Course course;
	
	public Student() {
        // default constructor
    }
	
	public Student (int stdId, String matricNo, String stdName) {
		this.stdId = stdId;
		this.matricNo = matricNo;
		this.stdName = stdName;
	}
	
	public int getStdId() {
		return stdId;
	}
	
	public String getMatricNo() {
		return matricNo;
	}
	public String getStdName() {
		return stdName;
	}

	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public String getStdEmail() {
		return stdEmail;
	}
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}
	public String getStdPhoneNo() {
		return stdPhoneNo;
	}
	public void setStdPhoneNo(String stdPhoneNo) {
		this.stdPhoneNo = stdPhoneNo;
	}

}
