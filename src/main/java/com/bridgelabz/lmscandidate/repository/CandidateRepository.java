package com.bridgelabz.lmscandidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.lmscandidate.model.HiredCandidate;

@Repository
public interface CandidateRepository extends JpaRepository<HiredCandidate, Long>{

}
