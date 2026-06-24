package com.embarkx.ChallengeApp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.embarkx.ChallengeApp.Service.ChallengeService;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:3000/")
public class ChallengeController {
	private ChallengeService challengeService;
	
	public ChallengeController(ChallengeService challengeService) {
		this.challengeService = challengeService;
	}
	
	@PostMapping
	public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
		Boolean isChallenge =  challengeService.addChallenge(challenge);
		if (isChallenge) {
			return new ResponseEntity<>("Added successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Cannot add Challenge", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<Challenge>> getAllChallenges(){
		return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
	}
	
	@GetMapping("/{month}")
	public ResponseEntity<Challenge> getChallenge(@PathVariable String month) {
	    Challenge challenge = challengeService.getChallenge(month);

	    if (challenge != null) {
	        return new ResponseEntity<>(challenge, HttpStatus.OK);
	    }

	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge){
		boolean isChallengeUpdated = challengeService.updateChallenge(id, updatedChallenge);
		if (isChallengeUpdated)
		return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
		else {
			return new ResponseEntity<>("Challenge cannot be updated", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
		boolean isChallengeDeleted = challengeService.deleteChallenge(id);
		if (isChallengeDeleted)
		return new ResponseEntity<>("Challenge deleted successfully", HttpStatus.OK);
		else {
			return new ResponseEntity<>("Challenge cannot be deleted", HttpStatus.NOT_FOUND);
		}
	}
}
