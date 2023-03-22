package com.nt.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateVotingDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	private String cname;
	private String symbolname;
	private Integer voteConunt;
	
}
