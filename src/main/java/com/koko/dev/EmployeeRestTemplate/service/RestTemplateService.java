package com.koko.dev.EmployeeRestTemplate.service;

import com.koko.dev.EmployeeRestTemplate.model.Employee;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestTemplateService {

    RestTemplate restTemplate = new RestTemplate();
    private static  final  String get_all_employee_url= "http://localhost:8080/stackInstance/getAllEmployee";
    private static  final  String get_employee_By_Name_url = "http://localhost:8080/stackInstance/getEmployee/{EmployeeName}";
    private static  final  String create_employee_url= "http://localhost:8080/stackInstance/addEmployee";


    /*
   ---Algorithme pour recuperer tous les employés en consommant  l'API externe developpé avec RestTemplate-
   --------------------------------------------------------------------------------------
   */
    public ResponseEntity<String>  getAllEmployee(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //headers.add("X-API-KEY",);
        //headers.add("X-API-SECRET",);
        HttpEntity<String>  entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(get_all_employee_url, HttpMethod.GET, entity, String.class);
        System.out.println("------------------ -------------------------------------------");
        System.out.println("------------------ LISTE DE TOUS  LES EMPLOYES --------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return  response;
    }
    /*
     ---Algorithme pour recuperer tous les employés en consommant  l'API externe developpé avec RestTemplate-
     --------------------------------------------------------------------------------------
     */
    public Employee getEmployeeByName( String name_of_employee){
        Map<String, String> param = new HashMap<String, String>();
        param.put("EmployeeName", name_of_employee);

        return  restTemplate.getForObject(get_employee_By_Name_url, Employee.class,param);
    }


    /*
  ---Algorithme d'ajout d'un nouvel employé en consommant  l'API externe developpé avec RestTemplate-
  --------------------------------------------------------------------------------------
  */
    public ResponseEntity<Employee> createEmployee(Employee employee){
        return restTemplate.postForEntity(create_employee_url, employee, Employee.class);
    }

   /*
   ---Algorithme pour recuperer d'un employé par son ID en consommant   l'API externe developpé avec RestTemplate-
   --------------------------------------------------------------------------------------
   */

}
