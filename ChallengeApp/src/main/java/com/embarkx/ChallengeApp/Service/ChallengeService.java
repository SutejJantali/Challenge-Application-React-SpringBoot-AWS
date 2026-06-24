package com.embarkx.ChallengeApp.Service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embarkx.ChallengeApp.Controller.Challenge;
import com.embarkx.ChallengeApp.Repository.ChallengeRepository;

@Service
public class ChallengeService {
//	private List<Challenge> challenges = new ArrayList<>();
	
	private ChallengeRepository challengeRepository;
	
    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }
	
	public List<Challenge> getAllChallenges(){
		return challengeRepository.findAll();
	}
	
	public Boolean addChallenge(Challenge challenge) {
		if (challenge != null) {
			
			challengeRepository.save(challenge);
			return true;
		}
		return false;
	}
	
	public Challenge getChallenge(String month){
		Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
		return challenge.orElse(null);
	}

	public boolean updateChallenge(Long id, Challenge updatedChallenge) {

		Optional<Challenge> challenge = challengeRepository.findById(id);
		
		if (challenge.isPresent()) {
			Challenge challengeToUpdate = challenge.get();
			challengeToUpdate.setMonth(updatedChallenge.getMonth());
			challengeToUpdate.setDescription(updatedChallenge.getDescription());
			
			challengeRepository.save(challengeToUpdate);
			return true;
		}
		
		return false;
	}

	public boolean deleteChallenge(Long id) {
		Optional<Challenge> challenge = challengeRepository.findById(id);
		
		if (challenge.isPresent()) {
			challengeRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	
}
