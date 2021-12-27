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
@Table(name = "Lms_Candidate_Info")
public class HiredCandidate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Candidate_ID")
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
	private Long currentPincode;
	private Long permanentPincode;

	public HiredCandidate() {
		// TODO Auto-generated constructor stub
	}

	public void createCandidate(@Valid HiredCandidateDto hiredCandidateDto) {

		this.firstName = hiredCandidateDto.getFirstName();
		this.middleName = hiredCandidateDto.getMiddleName();
		this.lastName = hiredCandidateDto.getLastName();
		this.email = hiredCandidateDto.getEmail();
		this.mobileNum = hiredCandidateDto.getMobileNum();
		this.hiredCity = hiredCandidateDto.getHiredCity();
		this.hiredDate = hiredCandidateDto.getHiredDate();
		this.degree = hiredCandidateDto.getDegree();
		this.hiredLab = hiredCandidateDto.getHiredLab();
		this.attitudeRemark = hiredCandidateDto.getAttitudeRemark();
		this.communication = hiredCandidateDto.getCommunication();
		this.knowledgeRemark = hiredCandidateDto.getKnowledgeRemark();
		this.onboardingStatus = hiredCandidateDto.getOnboardingStatus();
		this.status = hiredCandidateDto.getStatus();
		this.creatorUser = hiredCandidateDto.getCreatorUser();
		this.joinDate = hiredCandidateDto.getJoinDate();
		this.location = hiredCandidateDto.getLocation();
		this.aggregatePr = hiredCandidateDto.getAggregatePr();
		this.currentPincode = hiredCandidateDto.getCurrentPincode();
		this.permanentPincode = hiredCandidateDto.getPermanentPincode();

	}

	public HiredCandidate(HiredCandidateDto hiredCandidateDto) {
		this.firstName = hiredCandidateDto.getFirstName();
		this.middleName = hiredCandidateDto.getMiddleName();
		this.lastName = hiredCandidateDto.getLastName();
		this.email = hiredCandidateDto.getEmail();
		this.mobileNum = hiredCandidateDto.getMobileNum();
		this.hiredCity = hiredCandidateDto.getHiredCity();
		this.hiredDate = hiredCandidateDto.getHiredDate();
		this.degree = hiredCandidateDto.getDegree();
		this.hiredLab = hiredCandidateDto.getHiredLab();
		this.attitudeRemark = hiredCandidateDto.getAttitudeRemark();
		this.communication = hiredCandidateDto.getCommunication();
		this.knowledgeRemark = hiredCandidateDto.getKnowledgeRemark();
		this.onboardingStatus = hiredCandidateDto.getOnboardingStatus();
		this.status = hiredCandidateDto.getStatus();
		this.creatorUser = hiredCandidateDto.getCreatorUser();
		this.joinDate = hiredCandidateDto.getJoinDate();
		this.location = hiredCandidateDto.getLocation();
		this.aggregatePr = hiredCandidateDto.getAggregatePr();
		this.currentPincode = hiredCandidateDto.getCurrentPincode();
		this.permanentPincode = hiredCandidateDto.getPermanentPincode();

	}

}
