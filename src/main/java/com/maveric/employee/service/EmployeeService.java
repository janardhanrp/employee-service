package com.maveric.employee.service;

import com.maveric.employee.dto.EmployeeDto;
import com.maveric.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    EmployeeDto getEmployeeDetails(Integer id);

    EmployeeDto createEmployee(Employee employee);

    EmployeeDto updateEmployeeDetails(Employee employee,Integer id);

   String deleteEmployee(Integer id);
}
