package com.example.EmployeeManagementProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAO {

	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    public void createEmployeeTable() {
	        String sql = "CREATE TABLE IF NOT EXISTS employee (" +
	                     "id INT PRIMARY KEY, " +
	                     "name VARCHAR(100) NOT NULL, " +
	                     "position VARCHAR(100) NOT NULL, " +
	                     "salary DECIMAL(10,2) NOT NULL)";
	        jdbcTemplate.execute(sql);
	    }
	    // Method to add an employee
	    public void addEmployee(Employee employee) {
	        String sql = "INSERT INTO employee (id, name, position, salary) VALUES (?, ?, ?, ?)";
	        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getPosition(), employee.getSalary());
	    }
	    // Method to update an employee
	    public void updateEmployee(int id, Employee employee) {
	        String sql = "UPDATE employee SET name = ?, position = ?, salary = ? WHERE id = ?";
	        jdbcTemplate.update(sql, employee.getName(), employee.getPosition(), employee.getSalary(), id);
	    }
	    // Method to delete an employee
	    public void deleteEmployee(int id) {
	        String sql = "DELETE FROM employee WHERE id = ?";
	        jdbcTemplate.update(sql, id);
	    }
	    // Method to fetch an employee by ID
	    public Employee getEmployeeById(int id) {
	        String sql = "SELECT * FROM employee WHERE id = ?";
	        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
	    }

	    // Method to fetch all employees
	    public List<Employee> getAllEmployees() {
	        String sql = "SELECT * FROM employee";
	        return jdbcTemplate.query(sql, new EmployeeRowMapper());
	    }
	 // RowMapper class to map ResultSet to Employee object
	    private static class EmployeeRowMapper implements RowMapper<Employee> {
	        @Override
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Employee employee = new Employee();
	            employee.setId(rs.getInt("id"));
	            employee.setName(rs.getString("name"));
	            employee.setPosition(rs.getString("position"));
	            employee.setSalary(rs.getDouble("salary"));
	            return employee;
	        }
	    }



}
