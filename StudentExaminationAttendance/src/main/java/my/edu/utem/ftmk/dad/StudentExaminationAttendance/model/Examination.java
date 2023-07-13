package my.edu.utem.ftmk.dad.StudentExaminationAttendance.model;

import java.time.LocalDateTime;
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
@Table(name="examination")
public class Examination {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column (name="ExamId")
	private int examId;
	
	@ManyToOne
	@JoinColumn (name="CourseId")
	private Course courseId;
	
	@ManyToOne
	@JoinColumn (name="VenueId")
	private Venue venueId;
	
	private LocalDateTime dateTime;
	
//	@ManyToOne
//	@JoinColumn (name="StaffId")
//	private AcademicStaff chiefInvigilatorId;
	
	@ManyToOne
	@JoinColumn (name="StaffId")
	private AcademicStaff invigilatorId;
	
	@OneToMany
	@JoinColumn (name="StdId")
	private List<Student> attendees;
	

    public Examination() {
        // Default constructor
    }
	
	public Examination (int examId, Course courseId, LocalDateTime dateTime) {
		this.examId = examId;
		this.courseId = courseId;
		this.dateTime = dateTime;
	}
	
	public int getExamId() {
		return examId;
	}

	public Course getCourseId() {
		return courseId;
	}

	public Venue getVenueId() {
		return venueId;
	}
	
	public void setVenue(Venue venue) {
		this.venueId = venue;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
//	public AcademicStaff getChiefInvigilatorId() {
//		return chiefInvigilatorId;
//	}
//	
//	public void setChiefInvigilator(AcademicStaff chiefInvigilator) {
//		this.chiefInvigilatorId = chiefInvigilator;
//	}
	
	public AcademicStaff getInvigilatorId() {
		return invigilatorId;
	}
	
	public void setInvigilatorId (AcademicStaff invigilator) {
		this.invigilatorId = invigilator;
	}
	
	public List<Student> getAttendees() {
		return attendees;
	}
	
	public void setAttendees(List<Student> attendees) {
		this.attendees = attendees;
	}

}
