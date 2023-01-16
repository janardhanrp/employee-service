package com.maveric.employee.config;

import com.maveric.employee.model.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


public class EmployeeProcessor implements ItemProcessor<Employee,Employee> {

    @Override
    public Employee process(Employee employee) throws Exception {
        return employee;
    }

}
