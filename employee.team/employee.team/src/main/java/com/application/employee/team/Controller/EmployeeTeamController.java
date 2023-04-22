package com.application.employee.team.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.employee.team.Entity.Employee;
import com.application.employee.team.Entity.Team;
import com.application.employee.team.Service.EmployeeService;
import com.application.employee.team.Service.TeamService;

@Controller
public class EmployeeTeamController {
	
	
	private EmployeeService employeeService;
	private TeamService teamService ;

	public EmployeeTeamController(EmployeeService employeeService , TeamService teamService) {
		super();
		this.employeeService = employeeService;
		this.teamService = teamService;
	}
	
	@GetMapping("/home")
	public String home(){
		return "home"; 
	}
	
	@GetMapping("/manager")
	public String Manager(){
		return "manager"; 
	}
	
	@GetMapping("/login")
	public String login(){
		return "login"; 
	}
	
	
	@GetMapping("/employees/login")
	public String loginE() {
		return "login";
	}
	
	@GetMapping("/manager/login")
	public String loginT() {
		return "login";
	} 
	
	@GetMapping("/")
	public String ViewHomePage(Model model) {
		return "manager";
	} 
	
	// handler method to handle list employees and return mode and view
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";
	}
	// handler method to handle list team and return mode and view
	
	@GetMapping("/teams")
	public String listTeams(Model model) {
		model.addAttribute("teams", teamService.getAllTeams());
		return "teams";
	}
	
	
	
	@GetMapping("/employees/filter")
	public String Filter(Model model) {
		List<Team> allteams = teamService.getAllTeams();
		model.addAttribute("teams", allteams);
		return "Filter";
		
	}
	
	@GetMapping("/employees/new")
	public String createEmployeForm(Model model) {
		
		// create employee object to hold employee form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		List<Team> allteams = teamService.getAllTeams();
		model.addAttribute("teams", allteams);
		return "create_employee";
		
	}
	
	@GetMapping("/teams/new")
	public String createTeacherForm(Model model) {
		
		// create team object to hold team form data
		Team team = new Team();
		model.addAttribute("team", team);
		return "create_team";
		
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	
	@PostMapping("/teams")
	public String saveTeam(@ModelAttribute("team") Team team) {
		teamService.saveTeam(team);
		return "redirect:/teams";
	}
	
	
	@PostMapping("/employees/filter-by-team")
	public String ListEmployee(@RequestParam("teamId") long id, Model model) {
		//System.out.println(id);
		model.addAttribute("team", teamService.getTeamById(id));
		Team t = teamService.getTeamById(id) ;
		List<Employee> allemployee = t.getEmployees();
		//System.out.println(allemployee);
		model.addAttribute("employees", allemployee);
		return "FilterEmployee";
	}
	
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee",employeeService.getEmployeeById(id));
		List<Team> allteams = teamService.getAllTeams();
		model.addAttribute("teams", allteams);
		return "edit_employee";
	}
	
	@GetMapping("/teams/edit/{id}")
	public String editTeamForm(@PathVariable Long id, Model model) {
		model.addAttribute("team", teamService.getTeamById(id));
		return "edit_team";
	}


	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, 
			@ModelAttribute("employee") Employee employee, 
			Model model) {
		
		// get Employee from database by id
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		// save updated employee object
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employees";		
	}
	
	@PostMapping("/teams/{id}")
	public String updateTeam(@PathVariable Long id,	
			@ModelAttribute("team") Team team, 
			Model model) {
		
		// get team from database by id
		Team existingTeam = teamService.getTeamById(id);
		existingTeam.setId(id);
		existingTeam.setTeamName(team.getTeamName());

		
		// save updated team object
		teamService.updateTeam(existingTeam);
		return "redirect:/teams";		
	}
	
	// handler method to handle delete employee request
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
	
	// handler method to handle delete team request
	
	@GetMapping("/teams/{id}")
	public String deleteTeam(@PathVariable Long id) {
		teamService.deleteTeamById(id);
		return "redirect:/teams";
	}
}
