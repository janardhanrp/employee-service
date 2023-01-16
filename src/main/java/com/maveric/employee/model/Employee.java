package com.maveric.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   private String firstName;
   private String middleName;
   private String lastName;
   private String address;
   private String phoneNumber;
   private String email;
 //  private String password;




}
