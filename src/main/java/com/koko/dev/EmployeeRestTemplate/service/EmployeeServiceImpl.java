package com.koko.dev.EmployeeRestTemplate.service;

import com.koko.dev.EmployeeRestTemplate.model.Employee;
import com.koko.dev.EmployeeRestTemplate.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements  EmployeeService{

    EmployeeRepository employeeRepository;


    /*
    ---------Algorithme d'ajout d'un  nouvel utilisateur dans la Base des données----
    ------------------------------------------------------------------------------------
    */
    @Override
    public Employee addNewEmployee(Employee nouvelEmployee) {
        if(employeeRepository.findEmployeeByEmployeeName(nouvelEmployee.getEmployeeName()) != null)
            throw  new RuntimeException("Cet employee existe déjà dans la Base des données");

        System.out.println("******************************************************************");
        System.out.println(" Nouvel utilisateur: "+nouvelEmployee.getEmployeeName()+" ajouté avec succès ");
        System.out.println("******************************************************************");
        return employeeRepository.save(nouvelEmployee);
    }


    /*
   ---Algorithme de recuperation des tous les employés dans la Base des données-
   --------------------------------------------------------------------------------------
   */
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    /*
   Algorithme de recuperation d'un seul employé par son nom dans la Base des données-----
   --------------------------------------------------------------------------------------
   */
    @Override
    public Employee getEmployeeByName(String employeeName) {
         if (employeeRepository.findEmployeeByEmployeeName(employeeName) == null)
             throw  new RuntimeException(" cet employee n'existe pas dans la Base des données");
        return employeeRepository.findEmployeeByEmployeeName(employeeName);
    }

    /*
    Suppression d'un employé dans la Base des données evc son ID------------------------
   --------------------------------------------------------------------------------------
   */
    @Override
    public void deleteEmployee(int employee_id) {
        employeeRepository.deleteById(employee_id);
    }
}
