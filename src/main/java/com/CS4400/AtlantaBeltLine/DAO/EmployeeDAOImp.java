package com.CS4400.AtlantaBeltLine.DAO;

import com.CS4400.AtlantaBeltLine.DTO.Employee;
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
    public void saveEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(String username) {

    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";

        List employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>() {
            @Override
            public List extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<>();
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setUsername(rs.getString(1));
                    employee.setEmp_ID(rs.getInt(2));
                    employee.setPhone(rs.getString(3));
                    employee.setAddress(rs.getString(4));
                    employee.setCity(rs.getString(5));
                    employee.setState(rs.getString(6));
                    employee.setZip(rs.getInt(7));
                    list.add(employee);
                }
                return list;
            }
        });
        return employeeList;
    }
}
