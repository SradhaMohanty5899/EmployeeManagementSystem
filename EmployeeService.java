package com.example.EmployeeManagementProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService {
	@Autowired
    private EmployeeDAO employeeDAO;

    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }
    public void updateEmployeeName(int id, String name) {
        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee != null) {
            employee.setName(name);
            employeeDAO.updateEmployee(id, employee);
        }
    }
    public void updateEmployeePosition(int id, String position) {
        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee != null) {
            employee.setPosition(position);
            employeeDAO.updateEmployee(id, employee);
        }
    }
    public void updateEmployeeSalary(int id, double salary) {
        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee != null) {
            employee.setSalary(salary);
            employeeDAO.updateEmployee(id, employee);
        }
    }

    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

	

}
