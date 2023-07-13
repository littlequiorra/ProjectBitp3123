package my.edu.utem.ftmk.dad.StudentExaminationAttendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Student;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance.repository.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentRESTController {

	@Autowired
	private StudentRepository studentRepository;
	

	//private List <Student> studentList;
	
	/*
	 *  Creates a new record in table Student	
	 */
	
	@PostMapping()
	public Student addStudentDetails(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	/*
	 * Delete a record from table Student according to a web parameter's value
	 */
	
	@DeleteMapping("{stdId}")
	public ResponseEntity<HttpStatus> deleteStudentDetails(@PathVariable String stdId)	{
		studentRepository.deleteById(stdId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*
	 * Retrieves a record from table Student according to a web parameter's value
	 */
	
	/*@GetMapping("{matricNo}")
	public Student viewStudentDetails(@PathVariable long matricNo) {	
		Student student = studentRepository.findById(matricNo).get();
		return student;
	}*/
	
	/*
	 * Retrieves all records from table AcademicStaff
	 */
	
	@GetMapping
	public List<Student> getStudentList()	{	
		return studentRepository.findAll();
	}
		
	
	/*
	 * Updates  a record in table Student
	 */
	
	@PutMapping()
	public Student updateStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	

}
