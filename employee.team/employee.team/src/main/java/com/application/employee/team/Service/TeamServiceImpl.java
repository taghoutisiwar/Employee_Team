package com.application.employee.team.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.employee.team.Entity.Team;
import com.application.employee.team.Repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{

	private TeamRepository teamRepository;
	
	public TeamServiceImpl(TeamRepository teamRepository) {
		super();
		this.teamRepository = teamRepository;
	}

	@Override
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

	@Override
	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public Team getTeamById(Long id) {
		return teamRepository.findById(id).get();
	}

	@Override
	public Team updateTeam(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public void deleteTeamById(Long id) {
		teamRepository.deleteById(id);	
	}

}