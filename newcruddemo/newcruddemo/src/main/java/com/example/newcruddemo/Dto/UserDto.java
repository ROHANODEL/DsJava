package com.example.newcruddemo.Dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.newcruddemo.Model.EducationEntity;
import com.example.newcruddemo.Model.MaritalStatusEntity;
import com.example.newcruddemo.Model.ProjectEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
//@Data
//@ToString
public class UserDto {
	
//	@JsonProperty("id")
	private int id;
	
	@JsonProperty("username")
	@NotEmpty
	@Size(min = 3, message="name must min of 3 character")
	private String name;
	
	@JsonProperty("surname")
	@NotEmpty
	private String surname;
	
	@JsonProperty("email")
	@NotEmpty
	@Email(message="email address is not valid")
	private String email;
	
    private MaritalStatusEntity maritalSataus;
    
	private List<EducationEntity> educations;	

	private List<ProjectEntity> projectEntity;

	
    
    
	
}
