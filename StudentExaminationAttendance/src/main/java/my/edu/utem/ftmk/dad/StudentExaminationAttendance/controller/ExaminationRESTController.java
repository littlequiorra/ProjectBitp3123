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

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Examination;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance.repository.ExaminationRepository;

@RestController
@RequestMapping("/api/examination")
public class ExaminationRESTController {
	@Autowired
	private ExaminationRepository examRepository;
	

	/*
	 *  Creates a new record in table Examination	
	 */
	
	@PostMapping()
	public Examination addExam(@RequestBody Examination exam) {
		return examRepository.save(exam);
	}
	
	/*
	 * Remove a record from table Examination according to a web parameter's value
	 */
	
	@DeleteMapping("{examId}")
	public ResponseEntity<HttpStatus> removeExam(@PathVariable long examId)	{
		examRepository.deleteById(examId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*
	 * Retrieves a record from table Examination according to a web parameter's value
	 */
	
	@GetMapping("{examId}")
	public Examination viewExamDetails(@PathVariable long examId) {	
		Examination exam = examRepository.findById(examId).get();
		return exam;
	}
	
	/*
	 * Retrieves all records from table Examination
	 */
	
	@GetMapping
	public List<Examination> getExamination()	{	
		return examRepository.findAll();
	}
		
	
	/*
	 * Updates  a record in table Examination
	 */
	
	@PutMapping()
	public Examination updateExam(@RequestBody Examination exam) {
		return examRepository.save(exam);
	}
}
