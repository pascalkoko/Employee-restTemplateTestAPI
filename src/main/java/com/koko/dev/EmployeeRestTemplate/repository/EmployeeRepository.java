package com.koko.dev.EmployeeRestTemplate.repository;

import com.koko.dev.EmployeeRestTemplate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findEmployeeByEmployeeName(String employeeName);
}
