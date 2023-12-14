package com.koko.dev.EmployeeRestTemplate;

import com.koko.dev.EmployeeRestTemplate.model.Employee;
import com.koko.dev.EmployeeRestTemplate.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeRestTemplateApplication  implements CommandLineRunner {

	EmployeeRepository employeeRepository;
	Logger LOG;

	public EmployeeRestTemplateApplication(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestTemplateApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		employeeRepository.save(new Employee(null,"Pascal koko","Informatique"));
		employeeRepository.save(new Employee(null,"Elie Lombe","Electronique"));
		employeeRepository.save(new Employee(null,"Moise Ronko","Genie Civil"));
		employeeRepository.save(new Employee(null,"Alfred Zola","Mecanique"));
	}
}
