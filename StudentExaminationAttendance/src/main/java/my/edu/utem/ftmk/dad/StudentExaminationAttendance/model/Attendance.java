package my.edu.utem.ftmk.dad.StudentExaminationAttendance.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity 
@Table(name="attendance")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column (name="AttendId") 
	private int attendId;
	
	@ManyToOne
	@JoinColumn(name="ExamId")
	private Examination examination;
	
	@ManyToOne
	@JoinColumn(name="StdId")
	private Student student;
	
	@Column (name="AttendTime")
	private LocalDateTime attendTime;
	
	@Column (name="AttendType")
	private String attendType;
	
	@PrePersist
	public void prePersist() {
		attendTime= LocalDateTime.now();
	}
	
	 
    // Default constructor
    public Attendance() {
        // Initialize any necessary variables or perform other setup tasks
    }
    
	public Attendance (Examination examination, Student student, LocalDateTime attendTime) {
		this.examination = examination;
		this.student = student;
		this.attendTime = attendTime;
	}

	public Examination getExamination() {
		return examination;
	}

	public Student getStudent() {
		return student;
	}

	public LocalDateTime getAttendTime() {
		return attendTime;
	}

	public String getAttendType() {
		return attendType;
	}

	public void setAttendType(String attendType) {
		this.attendType = attendType;
	}
	public int getAttendId() {
		return attendId;
	}
	public void setAttendId(int attendId) {
		this.attendId = attendId;
	}

}
