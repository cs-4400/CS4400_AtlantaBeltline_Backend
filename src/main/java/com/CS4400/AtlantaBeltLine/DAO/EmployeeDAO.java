package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeDAO {

    public void saveEmployee(EmployeeDTO employeeDTO);
    public EmployeeDTO getEmployeeByUsername(String username);
    public void updateEmployee(EmployeeDTO employeeDTO);
    public void deleteEmployee(String username);
    public List<EmployeeDTO> getAllEmployees();
}
