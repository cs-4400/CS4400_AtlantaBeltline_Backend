package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.Employee;

import java.util.List;

public interface EmployeeDAO {

    public void saveEmployee(Employee employee);
    public Employee getEmployeeByUsername(String username);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(String username);
    public List<Employee> getAllEmployees();
}
