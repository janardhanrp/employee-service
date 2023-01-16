package com.maveric.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class EmployeeDto {
        @Id
        private Integer employeeId;
        private String firstName;
        private String secondName;
        private String lastName;
        private String address;
        private String phoneNumber;
        private String email;


    }
