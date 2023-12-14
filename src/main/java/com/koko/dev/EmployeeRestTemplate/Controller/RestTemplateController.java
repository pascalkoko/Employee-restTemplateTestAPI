package com.koko.dev.EmployeeRestTemplate.Controller;

import com.koko.dev.EmployeeRestTemplate.model.Employee;
import com.koko.dev.EmployeeRestTemplate.service.RestTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {
    private RestTemplateService restTemplateService;

    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<String> getAllEmployee(){
         return  restTemplateService.getAllEmployee();
    }

    @GetMapping("/getEmployee/{EmployeeName}")
    public Employee getEmployeeByName(@PathVariable  String employeeName){
        return  restTemplateService.getEmployeeByName(employeeName);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return  restTemplateService.createEmployee(employee);
    }

}
