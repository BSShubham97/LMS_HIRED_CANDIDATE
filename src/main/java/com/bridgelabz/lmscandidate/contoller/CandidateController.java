package com.bridgelabz.lmscandidate.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.lmscandidate.dto.HiredCandidateDto;
import com.bridgelabz.lmscandidate.dto.ResponseDto;
import com.bridgelabz.lmscandidate.model.HiredCandidate;
import com.bridgelabz.lmscandidate.repository.CandidateRepository;
import com.bridgelabz.lmscandidate.service.IHiredCandidateService;
import com.bridgelabz.lmscandidate.util.JwtTokenUtil;

@RequestMapping("/hiredcandidate")
@RestController
public class CandidateController {

	@Autowired
	CandidateRepository candidateRepository;
	@Autowired
	IHiredCandidateService iHiredCandidateService;
	@Autowired
	JwtTokenUtil tokenUtil;

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<ResponseDto> getAllCandidates() {
		List<HiredCandidateDto> candidateDataList = iHiredCandidateService.getAllCandidates();
		ResponseDto respDto = new ResponseDto("GET CALL FOR HIRED CANDIDATES SUCCESSFUL", candidateDataList);
		return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
	}

	@PostMapping("/addCandidate")
	public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody HiredCandidateDto hiredCandidateDto) {

		HiredCandidate hiredCandidate = iHiredCandidateService.createCandidate(hiredCandidateDto);
		ResponseDto respDto = new ResponseDto("Hired Candidate Added Succcessfully !!!",
				tokenUtil.createToken(hiredCandidate.getId()));
		return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
	}

	@RequestMapping("/get/{id}")
	public ResponseEntity<ResponseDto> getById(@PathVariable("id") long id) {
		HiredCandidate candidateDataList = iHiredCandidateService.getCandidateById(id);
		ResponseDto respDto = new ResponseDto("GET CALL FOR CANDIDATE No." + id + " SUCCESSFUL", candidateDataList);
		return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateData(@RequestHeader(name = "token") String token,
			@Valid @RequestBody HiredCandidateDto hiredCandidateDto) {

		HiredCandidate hiredCandidate = iHiredCandidateService.updateCandidate(token, hiredCandidateDto);
		ResponseDto respDto = new ResponseDto("UPDATED CANDIDATE DATA SUCCESSFULLY !!! ",
				tokenUtil.createToken(hiredCandidate.getId()));
		return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDto> deleteCandidate(@PathVariable("id") long id) {
		iHiredCandidateService.deleteCandidate(id);
		ResponseDto respDto = new ResponseDto("DELETED CANDIDATE DATA SUCCESSFULLY !!!", "DATABASE UPDATED.");
		return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
	}

}
