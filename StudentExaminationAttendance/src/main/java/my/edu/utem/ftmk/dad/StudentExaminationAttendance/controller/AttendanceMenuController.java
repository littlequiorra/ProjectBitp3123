package my.edu.utem.ftmk.dad.StudentExaminationAttendance.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Attendance;


@Controller
public class AttendanceMenuController {

	private String defaultURI="http://localhost:8080/exam_attendance_db/api/attendance";
	
	@GetMapping("/attendance/list")
	public String getAttendance(Model model)
	{
		
		// The URI for Get attendance
		String uri= "http://localhost:8080/exam_attendance_db/api/attendance";
				
		// Get a list attendance from the webs
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Attendance[]> response= restTemplate.getForEntity(uri,Attendance[].class);
				
		//Parse JSON data to array of object
		Attendance attendance[] = response.getBody();
		
		//System.out.println(this.getClass().getSimpleName());
		//System.out.println("Total records: "+ patientsTb.length+"\n");
		
		List<Attendance> attendanceList = Arrays.asList(attendance);
		
		model.addAttribute("attendance",attendanceList);
		
		return "attendance";
	}
		
		
			
		
		
	
		
		
		
	
	
}


	
	


