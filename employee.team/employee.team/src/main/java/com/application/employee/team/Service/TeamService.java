package com.application.employee.team.Service;

import java.util.List;

import com.application.employee.team.Entity.Team;

public interface TeamService {
	List<Team> getAllTeams();
	
	Team saveTeam(Team team);
	
	Team getTeamById(Long id);
	
	Team updateTeam(Team team);
	
	void deleteTeamById(Long id);
}
