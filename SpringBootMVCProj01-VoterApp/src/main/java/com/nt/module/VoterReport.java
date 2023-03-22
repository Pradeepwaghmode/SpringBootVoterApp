package com.nt.module;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoterReport implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rid;
	private Integer cid;
	private String cname;
	private Integer userid;
	private String usname;
	
}
