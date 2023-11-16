package com.example.newcruddemo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.newcruddemo.Dto.UserDto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_marital_status")
@NoArgsConstructor
@Getter
@Setter
//@Data
public class MaritalStatusEntity {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "marital_status_id")
	private int statusId;
	
	@Column(name = "marital_status_details")
	private String maritalStatusData;

}

