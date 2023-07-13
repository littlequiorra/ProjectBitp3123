package my.edu.utem.ftmk.dad.StudentExaminationAttendance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="venue")
public class Venue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column (name="VenueId")
	private int venueId;
	
	@Column (name="VenueName")
	private String venueName;
	
	@Column (name="Capacity")
	private int capacity;
	
	 public Venue() {
	        // Default constructor
	    }
	
	public Venue (int venueId, String venueName, int capacity) {
		this.venueId = venueId;
		this.venueName = venueName;
		this.capacity = capacity;
	}
	
	public int getVenueId() {
		return venueId;
	}

	public String getVenueName() {
		return venueName;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	
}
