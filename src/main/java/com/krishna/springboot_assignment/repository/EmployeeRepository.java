package com.krishna.springboot_assignment.repository;

import com.krishna.springboot_assignment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
