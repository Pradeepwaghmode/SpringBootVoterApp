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
public class Users_info implements Serializable{

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "EMP_SEQ",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1" ,strategy = GenerationType.SEQUENCE)
	private Integer userid;
	private String username;
	private String password;
	private String email="@.com";
	private Long phno;
	private String flag;
	private String role;
	
}
