package com.koko.dev.EmployeeRestTemplate.Controller;

import com.koko.dev.EmployeeRestTemplate.model.Employee;
import com.koko.dev.EmployeeRestTemplate.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stackInstance")
public class EmployeeController {

    EmployeeService employeeService;
    private static  final  String get_all_employee_url= "http://localhost:8080/stackInstance/getAllEmployee";

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addEmployee")
     Employee addEmployee(@RequestBody Employee employee){
         return employeeService.addNewEmployee(employee);
     }

     @GetMapping("/getAllEmployee")
     List<Employee> getAllEmployee(){
        return  employeeService.getAllEmployee();
     }
    @GetMapping("/getEmployee/{EmployeeName}")
     Employee getEmployeeByName(@PathVariable  String employeeName){
        return  employeeService.getEmployeeByName(employeeName);
     }

}
