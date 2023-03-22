package com.nt.service;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CandidateHelperImpl implements Serializable{

	private int c1;
	private int c2;
	private int c3;
	private int c4;
	
}
