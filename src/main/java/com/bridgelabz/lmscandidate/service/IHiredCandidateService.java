package com.bridgelabz.lmscandidate.service;


import java.util.List;

import javax.validation.Valid;

import com.bridgelabz.lmscandidate.dto.HiredCandidateDto;
import com.bridgelabz.lmscandidate.model.HiredCandidate;


public interface IHiredCandidateService {

	List<HiredCandidate> getAllCandidates();
    HiredCandidate createCandidate(@Valid HiredCandidateDto hiredCandidateDto);
    HiredCandidate getCandidateById(Long id);
	HiredCandidate updateCandidate(String token, HiredCandidateDto hiredCandidateDto);
	HiredCandidate deleteCandidate(Long id);
	String deleteAllData();
}
