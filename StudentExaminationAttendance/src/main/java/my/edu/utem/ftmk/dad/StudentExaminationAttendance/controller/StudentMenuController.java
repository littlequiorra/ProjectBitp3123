package my.edu.utem.ftmk.dad.StudentExaminationAttendance.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Student;


@Controller
public class StudentMenuController {

	private String defaultURI="http://localhost:8080/exam_attendance_db/api/student";
	
	@GetMapping("/student/list")
	public String getStudent(Model model)
	{
		
		// The URI for Get attendance
		String uri= "http://localhost:8080/exam_attendance_db/api/student";
				
		// Get a list attendance from the webs
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Student[]> response= restTemplate.getForEntity(uri,Student[].class);
				
		//Parse JSON data to array of object
		Student student[] = response.getBody();
		
		List<Student> studentList = Arrays.asList(student);
		
		model.addAttribute("student",studentList);
		
		return "student";
	}
}