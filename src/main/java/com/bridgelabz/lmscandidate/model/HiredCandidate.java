package com.bridgelabz.lmscandidate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import com.bridgelabz.lmscandidate.dto.HiredCandidateDto;

import lombok.Data;


@Data
@Entity 
@Table (name="Lms_Candidate_Info")	
public class HiredCandidate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Candidate_ID")
    private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String mobileNum;
	private String hiredCity;
	private String hiredDate;
	private String degree;
	private String hiredLab;
	private String attitudeRemark;
	private String communication;
	private String knowledgeRemark;
	private String onboardingStatus;
	private String status;
	private String creatorUser;
	private String joinDate;
	private String location;
	private Double aggregatePr;
	private Integer currentPincode;
	private Integer permanentPincode ;
    
    public HiredCandidate() {
		// TODO Auto-generated constructor stub
	}

	public void createCandidate(@Valid HiredCandidateDto hiredCandidateDto) {
		this.firstName= hiredCandidateDto.getFirstName();
		this.email=hiredCandidateDto.getEmail();
		this.hiredCity=hiredCandidateDto.getHiredCity();
		this.degree=hiredCandidateDto.getDegree();
		this.location=hiredCandidateDto.getLocation();
		
	}
    

}
