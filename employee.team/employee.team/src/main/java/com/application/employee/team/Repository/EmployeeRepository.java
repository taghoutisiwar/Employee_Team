package com.application.employee.team.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.application.employee.team.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}




