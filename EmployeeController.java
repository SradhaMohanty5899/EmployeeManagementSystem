package com.example.EmployeeManagementProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	    @Autowired
	    private EmployeeService employeeService;

	    @PostMapping("/add")
	    public String addEmployee(@RequestBody Employee employee) {
	        employeeService.addEmployee(employee);
	        return "Employee added successfully!";
	    }

	    @PutMapping("/update-name/{id}")
	    public String updateEmployeeName(@PathVariable int id, @RequestParam String name) {
	        employeeService.updateEmployeeName(id, name);
	        return "Employee name updated successfully!";
	    }

	    @PutMapping("/update-position/{id}")
	    public String updateEmployeePosition(@PathVariable int id, @RequestParam String position) {
	        employeeService.updateEmployeePosition(id, position);
	        return "Employee position updated successfully!";
	    }

	    @PutMapping("/update-salary/{id}")
	    public String updateEmployeeSalary(@PathVariable int id, @RequestParam double salary) {
	        employeeService.updateEmployeeSalary(id, salary);
	        return "Employee salary updated successfully!";
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable int id) {
	        employeeService.deleteEmployee(id);
	        return "Employee deleted successfully!";
	    }

	    @GetMapping("/get/{id}")
	    public Employee getEmployeeById(@PathVariable int id) {
	        return employeeService.getEmployeeById(id);
	    }

	    @GetMapping("/all")
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

}
