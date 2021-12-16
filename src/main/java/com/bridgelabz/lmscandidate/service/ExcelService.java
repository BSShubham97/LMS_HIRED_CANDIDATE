package com.bridgelabz.lmscandidate.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.lmscandidate.model.HiredCandidate;
import com.bridgelabz.lmscandidate.repository.CandidateRepository;
import com.bridgelabz.lmscandidate.util.ExcelHelper;

@Service
public class ExcelService {

	@Autowired
	CandidateRepository repository ;
	
	 public void save(MultipartFile file) {
		    try {
		      List<HiredCandidate> candidateList = ExcelHelper.excelToLMSCandidate(file.getInputStream());
		      repository.saveAll(candidateList);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
		  }

		  public List<HiredCandidate> getAllCandidates() {
		    return repository.findAll();
		  }
}
