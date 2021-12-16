package com.bridgelabz.lmscandidate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public @ToString class HiredCandidateDto {
	    private Long id ;
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
}
