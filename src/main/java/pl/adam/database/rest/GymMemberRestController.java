package pl.adam.database.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.adam.database.entity.GymMember;
import pl.adam.database.service.GymMemberService;

@RestController
@RequestMapping("/api")
public class GymMemberRestController {

	// autowire the gymMemberService
	// it will inject the dependency
	@Autowired
	private GymMemberService gymMemberService;

	// add mapping for GET /gymmembers
	@GetMapping("/gymmembers")
	public List<GymMember> getGymMembers() {

		return gymMemberService.getGymMembers();
	}

	// add mapping for GET /gymmembers/{gymMemberId}
	@GetMapping("/gymmembers/{gymmemberId}")
	public GymMember getGymMember(@PathVariable int gymmemberId) {

		// if gymMemberId isn't found in the database it returns null
		// for null objects jackson returns an empty body
		GymMember theGymMember = gymMemberService.getGymMember(gymmemberId);

		if (theGymMember == null) {
			throw new GymMemberNotFoundException("GymMember id not found: " + gymmemberId);
		}

		return theGymMember;
	}

	// add mapping for POST /gymmembers -> add new GymMember
	@PostMapping("/gymmembers")
	public GymMember addGymMember(@RequestBody GymMember theGymMember) {

		// id is set to 0, to force jackson to save the member instead of update
		theGymMember.setId(0);
		gymMemberService.saveGymMember(theGymMember);

		return theGymMember;
	}

	// add mapping for PUT /gymmembers -> update GymMember
	@PutMapping("/gymmembers")
	public GymMember updateGymMember(@RequestBody GymMember theGymMember) {

		gymMemberService.saveGymMember(theGymMember);

		return theGymMember;
	}

	// add mapping for DELETE /gymmembers/{gymMemberId}
	@DeleteMapping("/gymmembers/{gymmemberId}")
	public String deleteGymMember(@PathVariable int gymmemberId) {

		// check if the gymMember exists
		GymMember theGymMember = gymMemberService.getGymMember(gymmemberId);

		// throw exception if null
		if (theGymMember == null) {
			throw new GymMemberNotFoundException("GymMember id not found: " + gymmemberId);
		}

		// delete the gymMember id
		gymMemberService.deleteGymMember(gymmemberId);
		
		return "Deleted GymMember id: " + gymmemberId;
	}
}
