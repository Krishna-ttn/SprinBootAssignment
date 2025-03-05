package com.krishna.springboot_assignment;

import com.krishna.springboot_assignment.Configuration.ConfiPropExample;
import com.krishna.springboot_assignment.entity.Employee;
import com.krishna.springboot_assignment.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAssignmentApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringbootAssignmentApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootAssignmentApplication.class, args);

        //Q2)Confgure few properties under application properties file and read there value under Main class.
        // Fetch the ConfigProperties bean
        ConfiPropExample confiPropExample = context.getBean(ConfiPropExample.class);

        // log the properties
        log.info("Config URL: {}", confiPropExample.getUrl());
        log.info("Config Username: {}", confiPropExample.getUserName());
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

            log.info("Sample data inserted successfully!");
        };
    }

}
