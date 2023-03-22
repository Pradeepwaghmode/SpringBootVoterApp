package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.service.CandidateHelperImpl;
import com.nt.module.Users_info;
import com.nt.module.VoterReport;

public interface IReportRepository extends JpaRepository<VoterReport, Integer> {

//	@Query("from Users_info where username=:name")
//	public Users_info finuserByUserName(String name);
}
