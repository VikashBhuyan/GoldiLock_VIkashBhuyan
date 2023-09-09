package com.goldilock.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goldilock.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
