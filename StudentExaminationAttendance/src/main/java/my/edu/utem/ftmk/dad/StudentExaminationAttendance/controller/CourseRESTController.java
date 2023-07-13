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

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Course;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance.repository.CourseRepository;

@RestController
@RequestMapping("/api/course")
public class CourseRESTController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	/*
	 *  Creates a new record in table Course	
	 */
	
	@PostMapping()
	public Course addCourse(@RequestBody Course student) {
		return courseRepository.save(student);
	}
	
	/*
	 * Delete a record from table Course according to a web parameter's value
	 */
	
	@DeleteMapping("{courseId}")
	public ResponseEntity<HttpStatus> removeCourse(@PathVariable long courseId)	{
		courseRepository.deleteById(courseId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*
	 * Retrieves a record from table Course according to a web parameter's value
	 */
	
	@GetMapping("{courseId}")
	public Course viewCourseDetails(@PathVariable long courseId) {	
		Course course = courseRepository.findById(courseId).get();
		return course;
	}
	
	
	/*
	 * Updates  a record in table Course
	 */
	@PutMapping()
	public Course updateCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
    
	/*
	 * Get all record in table Course
	 */
	@GetMapping
	public List<Course> getAllCourses() {
	    return courseRepository.findAll();
	}

}
