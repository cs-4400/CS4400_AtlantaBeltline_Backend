package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {

    }

    @Override
    public EmployeeDTO getEmployeeByUsername(String username) {
        return null;
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {

    }

    @Override
    public void deleteEmployee(String username) {

    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        String sql = "SELECT * FROM employee";

        List employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<EmployeeDTO>>() {
            @Override
            public List extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<EmployeeDTO> list = new ArrayList<>();
                while (rs.next()) {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setUsername(rs.getString(1));
                    employeeDTO.setEmp_ID(rs.getInt(2));
                    employeeDTO.setPhone(rs.getString(3));
                    employeeDTO.setAddress(rs.getString(4));
                    employeeDTO.setCity(rs.getString(5));
                    employeeDTO.setState(rs.getString(6));
                    employeeDTO.setZip(rs.getInt(7));
                    list.add(employeeDTO);
                }
                return list;
            }
        });
        return employeeList;
    }
}
