package com.maveric.employee.service;
//
//import com.maveric.employee.dto.EmployeeDto;

import com.maveric.employee.dto.EmployeeDto;
import com.maveric.employee.exception.EmployeeNotFoundexception;
import com.maveric.employee.model.Employee;
import com.maveric.employee.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {


        return  employeeRepo.findAll();}

    public EmployeeDto getEmployeeDetails(Integer id) {
        Optional<Employee> employeeSelected= employeeRepo.findById(id);
        Employee employee=new Employee();
        if(employeeSelected.isPresent()) {
            employee = employeeSelected.get();
            return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getMiddleName(), employee.getLastName(), employee.getAddress(), employee.getPhoneNumber(), employee.getEmail());
        }
        else
            throw new EmployeeNotFoundexception("Not found");

    }

    @Override
    public EmployeeDto createEmployee(Employee employee) {
        employeeRepo.save(employee);
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getMiddleName(), employee.getLastName(), employee.getAddress(), employee.getPhoneNumber(), employee.getEmail());
    }

        @Override
    public EmployeeDto updateEmployeeDetails(Employee employee,Integer id) {
       Employee employeeUpdate=new Employee();
        if(employeeRepo.findById(id).isPresent())
            {
                employeeUpdate.setFirstName(employee.getFirstName());
                employeeUpdate.setMiddleName(employee.getMiddleName());
                employeeUpdate.setLastName(employee.getLastName());
                employeeUpdate.setAddress(employee.getAddress());
                employeeUpdate.setPhoneNumber(employee.getPhoneNumber());
                employeeUpdate.setEmail(employee.getEmail());
                employeeRepo.save(employeeUpdate);
                return new EmployeeDto(employeeUpdate.getId(), employeeUpdate.getFirstName(), employeeUpdate.getMiddleName(),employeeUpdate.getLastName(), employeeUpdate.getAddress(), employeeUpdate.getPhoneNumber(), employeeUpdate.getEmail());
            }
            else
            {
                throw new EmployeeNotFoundexception("Not found");
            }

    }

    @Override
    public String deleteEmployee(Integer id) {
        if(employeeRepo.findById(id).isPresent())
             employeeRepo.deleteById(id);

        return "Delete Successfully :" +id;
    }
}
