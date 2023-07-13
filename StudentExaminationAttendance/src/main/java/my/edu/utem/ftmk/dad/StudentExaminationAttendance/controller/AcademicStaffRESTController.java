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

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.AcademicStaff;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance.repository.AcademicStaffRepository;

@RestController
@RequestMapping("/api/academicstaff")
public class AcademicStaffRESTController {
		
		@Autowired
		private AcademicStaffRepository academicStaffRepository;
		
	//	@Autowired
		//private StudentRepository studentRepository;
		
		//private List <AcademicStaff> staffList;
		//private List <Student> academicAdvisees;
		
		/*
		 *  Creates a new record in table AcademicStaff	
		 */
		
		@PostMapping()
		public AcademicStaff addStaffDetails(@RequestBody AcademicStaff academicStaff) {
			return academicStaffRepository.save(academicStaff);
		}
		
		/*
		 * Delete a record from table AcademicStaff according to a web parameter's value
		 */
		
		@DeleteMapping("{staffId}")
		public ResponseEntity<HttpStatus> deleteStaffDetails(@PathVariable long staffId)	{
			academicStaffRepository.deleteById(staffId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		/*
		 * Retrieves a record from table AcademicStaff according to a web parameter's value
		 */
		
		@GetMapping("{staffId}")
		public AcademicStaff viewStaffDetails(@PathVariable long staffId) {	
			AcademicStaff academicStaff = academicStaffRepository.findById(staffId).get();
			return academicStaff;
		}
		
		/*
		 * Retrieves all records from table AcademicStaff
		 */
		
		@GetMapping
		public List<AcademicStaff> getStaffList()	{	
			return academicStaffRepository.findAll();
		}
			
		
		/*
		 * Updates  a record in table AcademicStaff
		 */
		
		@PutMapping()
		public AcademicStaff updateAcademicStaff(@RequestBody AcademicStaff academicStaff) {
			return academicStaffRepository.save(academicStaff);
		}
		
		/*
//		 * Retrieves academic advisees list record from table AcademicStaff according to a web parameter's value
//		 */
//		
//		@GetMapping("{staffId}")
//		public List <Student> viewAcademicAdvisees(@PathVariable long academicAdvisees) {	
//			AcademicStaff academicStaff = academicStaffRepository.findById(staffId).get();
//			return academicAdvisees;
//		}

//		public List <Student> getAcademicAdvisees() {
//			return academicAdvisees;
//		}
//
//		public void setAcademicAdvisees(List <Student> academicAdvisees) {
//			this.academicAdvisees = academicAdvisees;
//		}


}
