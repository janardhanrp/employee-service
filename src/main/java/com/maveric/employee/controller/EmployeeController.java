package com.maveric.employee.controller;

//import com.maveric.employee.service.EmployeeServiceImpl;

import com.maveric.employee.dto.EmployeeDto;
import com.maveric.employee.model.Employee;
import com.maveric.employee.service.EmployeeServiceImpl;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    public EmployeeServiceImpl employeeService;
    @Autowired
   private JobLauncher jobLauncher;
    @Autowired
   private Job job;

    @GetMapping("/importEmployees")
    public  void importCsvToDb()
    {
        JobParameters jobParameters=new JobParametersBuilder()
                .addLong("startAt",System.currentTimeMillis())
                .toJobParameters();
   try{
       jobLauncher.run(job,jobParameters);
   }
   catch (JobInstanceAlreadyCompleteException|JobExecutionAlreadyRunningException| JobParametersInvalidException |JobRestartException e) {
       e.printStackTrace();
   }

    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        return  new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <EmployeeDto> getEmployeeDetails(@PathVariable Integer id)
    {
        return  new ResponseEntity<>(employeeService.getEmployeeDetails(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployees(@RequestBody Employee employee)
    {
        return  new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeDetails(@RequestBody Employee employee,@PathVariable Integer id)
    {
        return  new ResponseEntity<>(employeeService.updateEmployeeDetails(employee, id), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id)
    {
        return  new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }
}
