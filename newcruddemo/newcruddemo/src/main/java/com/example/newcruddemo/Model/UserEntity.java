package com.example.newcruddemo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import com.example.newcruddemo.Dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@NoArgsConstructor
@Getter
@Setter
//@Data
public class UserEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "email")
	private String email;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marital_id", referencedColumnName = "marital_status_id")
    private MaritalStatusEntity maritalSataus;
    
    
//    @OneToMany(targetEntity = EducationEntity.class, mappedBy = "userEntity", cascade = CascadeType.ALL)
//    private List<EducationEntity> educations;
    
    @OneToMany(targetEntity = EducationEntity.class, mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<EducationEntity> educations;

      
    
	  @JsonIgnore
	  @ManyToMany(cascade = CascadeType.ALL)
	  @JoinTable(name = "user_project", joinColumns = @JoinColumn(name = "user_id"),
	  inverseJoinColumns = @JoinColumn(name = "project_id"))
	  private List<ProjectEntity> projectEntity;
	  
	
}

