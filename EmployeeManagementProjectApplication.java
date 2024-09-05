package com.example.EmployeeManagementProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner; // Import CommandLineRunner
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementProjectApplication implements CommandLineRunner { // Change to CommandLineRunner
    @Autowired
    private EmployeeDAO employeeDAO;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception { 
    	// Update method signature to match CommandLineRunner
        employeeDAO.createEmployeeTable();
        System.out.println("Employee table created!");
    }
}

