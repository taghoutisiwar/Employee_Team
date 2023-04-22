package com.application.employee.team.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "teamName", nullable = false)
	private String teamName;
	

	@OneToMany (mappedBy = "team" , fetch=FetchType.LAZY)
	private List<Employee> employees ;
 
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Team() {

	}
	
	public Team(String TeamName , Long id ) {
		super();
		this.id=id;
		this.teamName = TeamName;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String TeamName) {
		this.teamName = TeamName;
	}


}
