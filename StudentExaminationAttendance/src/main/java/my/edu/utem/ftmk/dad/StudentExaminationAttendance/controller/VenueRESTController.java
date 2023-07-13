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

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Venue;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance.repository.VenueRepository;

@RestController
@RequestMapping("/api/venue")
public class VenueRESTController {
	@Autowired
	private VenueRepository venueRepository;
	

	/*
	 *  Creates a new record in table Venue	
	 */
	
	@PostMapping()
	public Venue addVenue(@RequestBody Venue venue) {
		return venueRepository.save(venue);
	}
	
	/*
	 * Delete a record from table Venue according to a web parameter's value
	 */
	
	@DeleteMapping("{venueId}")
	public ResponseEntity<HttpStatus> removeVenue(@PathVariable long venueId)	{
		venueRepository.deleteById(venueId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*
	 * Retrieves a record from table Venue according to a web parameter's value
	 */
	
	@GetMapping("{venueId}")
	public Venue viewStudentDetails(@PathVariable long venueId) {	
		Venue venue = venueRepository.findById(venueId).get();
		return venue;
	}
	
	/*
	 * Retrieves all records from table Venue
	 */
	
	@GetMapping
	public List<Venue> getVenueList()	{	
		return venueRepository.findAll();
	}
		
	
	/*
	 * Updates  a record in table Venue
	 */
	
	@PutMapping()
	public Venue updateVenue(@RequestBody Venue venue) {
		return venueRepository.save(venue);
	}
}
