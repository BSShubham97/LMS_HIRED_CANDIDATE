package com.bridgelabz.lmscandidate.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.lmscandidate.dto.HiredCandidateDto;
import com.bridgelabz.lmscandidate.model.HiredCandidate;
import com.bridgelabz.lmscandidate.repository.CandidateRepository;
import com.bridgelabz.lmscandidate.util.JwtTokenUtil;




@Service
public class HiredCandidateService implements IHiredCandidateService {

	@Autowired
	private CandidateRepository candidateRepository ; 
	@Autowired
	JwtTokenUtil tokenUtil;
	
	@Override
	public List<HiredCandidateDto> getAllCandidates() {
	return candidateRepository.findAll().stream().map(hiredCandidate -> {
		HiredCandidateDto hiredCandidateDto = new HiredCandidateDto();
		hiredCandidateDto.setId(hiredCandidate.getId());
		hiredCandidateDto.setFirstName(hiredCandidate.getFirstName());
		hiredCandidateDto.setEmail(hiredCandidate.getEmail());
		hiredCandidate.setHiredCity(hiredCandidateDto.getHiredCity());
		return hiredCandidateDto;
	}).collect(Collectors.toList());
}
	
	
//	@Override
//	public HiredCandidate addCandidate(HiredCandidateDto hiredCandidateDto) {
//		HiredCandidate hiredCandidate = new HiredCandidate();
//		hiredCandidate.setFirstName(hiredCandidateDto.getFirstName());
//		hiredCandidate.setEmail(hiredCandidateDto.getEmail());
//		hiredCandidate.setHiredCity(hiredCandidateDto.getHiredCity());
//		hiredCandidate.setDegree(hiredCandidateDto.getDegree());
//		hiredCandidate.setHiredLab(hiredCandidateDto.getHiredLab());
//		hiredCandidate.setLocation(hiredCandidateDto.getLocation());
//		return hiredCandidate;
//	}
	
	public HiredCandidate createCandidate(@Valid HiredCandidateDto hiredCandidateDto) {
		HiredCandidate hiredCandidate = new HiredCandidate();
		hiredCandidate.createCandidate(hiredCandidateDto);
		return candidateRepository.save(hiredCandidate);
	}


	@Override
	public HiredCandidate getCandidateById(Long id) {
		return candidateRepository.findById(id).get();
	
	}
	

	@Override
	public HiredCandidate updateCandidate(String token, HiredCandidateDto hiredCandidateDto) {
		Long Id=  tokenUtil.decodeToken(token);
		Optional<HiredCandidate> hiredCandidate =  candidateRepository.findById(Id);
		if(hiredCandidate.isPresent()) {
			hiredCandidate.get().setFirstName(hiredCandidateDto.getFirstName());
			hiredCandidate.get().setMiddleName(hiredCandidateDto.getMiddleName());
			hiredCandidate.get().setLastName(hiredCandidateDto.getLastName());
			hiredCandidate.get().setEmail(hiredCandidateDto.getEmail());
			hiredCandidate.get().setHiredCity(hiredCandidateDto.getHiredCity());
			hiredCandidate.get().setLocation(hiredCandidateDto.getLocation());
			hiredCandidate.get().setDegree(hiredCandidateDto.getDegree());
			hiredCandidate.get().setHiredLab(hiredCandidateDto.getHiredLab());
			
		    candidateRepository.save(hiredCandidate.get());
		  return hiredCandidate.get();
		}
		return null;
	}

	
	@Override
	public HiredCandidate deleteCandidate(Long id) {
		Optional<HiredCandidate> hiredCandidate = candidateRepository.findById(id);
		if (hiredCandidate.isPresent()) {
			candidateRepository.delete(hiredCandidate.get());
			;
		}
		return null;
	}



	}


