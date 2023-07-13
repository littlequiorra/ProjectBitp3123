package my.edu.utem.ftmk.dad.StudentExaminationAttendance.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column (name="CourseId")
	private int courseId;
	
	@Column (name="CourseCode")
	private String courseCode;
	
	@Column (name="CourseName")
	private String courseName;
	
	@ManyToOne
	@JoinColumn (name="StaffId")
	private AcademicStaff lecturerId;
	
	@OneToMany(mappedBy = "course")
	private List<Student> enrolledStudent;
	
	 public Course() {
	        // default constructor
	    }
	
	public Course (int courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
	}

	
	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}
	
	public AcademicStaff getLecturer() {
		return lecturerId;
	}
	public void setLecturer(AcademicStaff lecturer) {
		this.lecturerId = lecturer;
	}
	
	public List<Student> getEnrolledStudent() {
		return enrolledStudent;
	}
	
	public void setEnrolledStudent(List<Student> enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}


}
