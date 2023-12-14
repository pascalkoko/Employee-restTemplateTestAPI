package com.koko.dev.EmployeeRestTemplate.service;

import com.koko.dev.EmployeeRestTemplate.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
     Employee addNewEmployee(Employee employee);
     List<Employee> getAllEmployee();
     Employee getEmployeeByName(String employeeName);

     void deleteEmployee(int employee_id);
}
