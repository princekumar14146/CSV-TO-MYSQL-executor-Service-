package com.batchProcessing.boot.Controller;

import com.batchProcessing.boot.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save1")
    public void processCsv(){
        employeeService.processCsvFile("/home/bonami/AWS_PRACTICE/StoreDataFromCsvFileToDatabaseByMultithreading/boot/src/main/resources/data.csv");
    }
}
