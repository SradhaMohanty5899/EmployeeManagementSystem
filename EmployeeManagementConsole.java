package com.example.EmployeeManagementProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class EmployeeManagementConsole implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Fetch Employee by ID");
            System.out.println("5. List All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    updateEmployee(scanner);
                    break;
                case 3:
                    deleteEmployee(scanner);
                    break;
                case 4:
                    fetchEmployeeById(scanner);
                    break;
                case 5:
                    listAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
        scanner.close();
    }

    private void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Position: ");
        String position = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, position, salary);
        employeeService.addEmployee(employee);
        System.out.println("Employee added successfully!");
    }

    private void updateEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        System.out.println("Select update option:");
        System.out.println("1. Update Name");
        System.out.println("2. Update Position");
        System.out.println("3. Update Salary");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();

        switch (updateChoice) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                employeeService.updateEmployeeName(id, newName);
                System.out.println("Employee name updated successfully!");
                break;
            case 2:
                System.out.print("Enter new position: ");
                String newPosition = scanner.nextLine();
                employeeService.updateEmployeePosition(id, newPosition);
                System.out.println("Employee position updated successfully!");
                break;
            case 3:
                System.out.print("Enter new salary: ");
                double newSalary = scanner.nextDouble();
                employeeService.updateEmployeeSalary(id, newSalary);
                System.out.println("Employee salary updated successfully!");
                break;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }

    private void deleteEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        employeeService.deleteEmployee(id);
        System.out.println("Employee deleted successfully!");
    }

    private void fetchEmployeeById(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            System.out.println("Employee Details: " + employee);
        } else {
            System.out.println("Employee not found!");
        }
    }

    private void listAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}
