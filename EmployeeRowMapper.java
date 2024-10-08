package com.example.EmployeeManagementProject;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeRowMapper implements RowMapper<Employee> {
	
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
