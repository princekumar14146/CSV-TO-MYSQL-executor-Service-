package com.batchProcessing.boot.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
   // @Column(name = "emp_id")
    private  Integer employeeId;

   // @Column(name = "emp_first_name")
    private String employeeFirstName;

  //  @Column(name = "emp_last_name")
    private String employeeLastName;

  //  @Column(name = "emp_sal")
    private Double employeeSalary;

  //  @Column(name = "emp_email")
    private String employeeEmail;

   // @Column(name = "emp_address")
    private String employeeAddress;

}
