package com.example.newcruddemo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="user_education")
@NoArgsConstructor
@Getter
@Setter
//@ToString
//@Data
public class EducationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "education_id")
	private int educationId;
	
	@Column(name = "education")
	private String education;
	
	@Column(name = "passout_year")
	private Long passYear;
	

//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id", referencedColumnName="id")
//	private UserEntity userEntity;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName="id")
	private UserEntity userEntity;
	
	
//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id", referencedColumnName="id")
//	private UserEntities userEntities;

	
}
	