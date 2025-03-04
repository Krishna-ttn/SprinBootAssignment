package com.krishna.springboot_assignment;

import com.krishna.springboot_assignment.Configuration.ConfiPropExample;
import com.krishna.springboot_assignment.entity.Employee;
import com.krishna.springboot_assignment.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAssignmentApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootAssignmentApplication.class, args);

        //Q2)Confgure few properties under application properties file and read there value under Main class.
        // Fetch the ConfigProperties bean
        ConfiPropExample confiPropExample = context.getBean(ConfiPropExample.class);

        // Print the properties
        System.out.println("Config URL: " + confiPropExample.getUrl());
        System.out.println("Config Username: " + confiPropExample.getUserName());
    }

    // Q3)CreateCreate a Employee table (id, name, designation) under H2 database and inserts few sample records under
    // that table at startup.
    @Bean
    public CommandLineRunner loadData(EmployeeRepository repository) {
        return args -> {
            // Insertings sample data
            repository.save(new Employee("Krishna Sharma", "Software Engineer"));
            repository.save(new Employee("Kunal Rawat", "QA"));
            repository.save(new Employee("Yatin ", "Business Analyst"));

            System.out.println("Sample data inserted successfully!");
        };
    }

}
