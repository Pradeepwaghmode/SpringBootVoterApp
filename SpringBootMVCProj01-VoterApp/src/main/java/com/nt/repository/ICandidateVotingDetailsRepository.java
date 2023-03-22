package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.module.CandidateVotingDetails;

public interface ICandidateVotingDetailsRepository extends JpaRepository<CandidateVotingDetails, Integer> {

//	@Query("from Users_info where username=:name")
//	public Users_info finuserByUserName(String name);
}
