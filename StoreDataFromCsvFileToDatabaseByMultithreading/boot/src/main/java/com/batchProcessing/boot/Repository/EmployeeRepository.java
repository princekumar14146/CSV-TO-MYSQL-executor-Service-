package com.batchProcessing.boot.Repository;

import com.batchProcessing.boot.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
