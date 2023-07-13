package my.edu.utem.ftmk.dad.StudentExaminationAttendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Attendance;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance.repository.AttendanceRepository;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceRESTController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@GetMapping("/test")
	public String testMapping() {
		
		return "Test Mapping";
	}
	
	
	
	/*
	 * Retrieves all records from table Attendance
	 */
	@GetMapping
	public List<Attendance> getAttendanceList()	{	
		return attendanceRepository.findAll();
	}
	/*
	 *  Creates a new record in table Student	
	 */
	
	@PostMapping()
	public Attendance addAttendance(@RequestBody Attendance attendance) {
		return attendanceRepository.save(attendance);
	}
	
	
	
	
}
