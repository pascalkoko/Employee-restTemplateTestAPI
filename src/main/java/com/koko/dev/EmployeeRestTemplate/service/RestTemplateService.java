package com.koko.dev.EmployeeRestTemplate.service;

import com.koko.dev.EmployeeRestTemplate.model.Employee;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RestTemplateService {

    RestTemplate restTemplate = new RestTemplate();
    private static  final  String get_all_employee_url= "http://localhost:8080/stackInstance/getAllEmployee";
    private static  final  String create_employee_url= "http://localhost:8080/stackInstance/addEmployee";
    // Methode to Get All the employee
    public ResponseEntity<String>  getAllEmployee(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //headers.add("X-API-KEY",);
        //headers.add("X-API-SECRET",);
        HttpEntity<String>  entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(get_all_employee_url, HttpMethod.GET, entity, String.class);

        return  response;
    }

    // ajout d'un nouvel employee
    public ResponseEntity<Employee> createEmployee(Employee employee){
        return restTemplate.postForEntity(create_employee_url, employee, Employee.class);
    }


}
