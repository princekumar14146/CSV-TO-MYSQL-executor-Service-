package com.batchProcessing.boot.Service;

import com.batchProcessing.boot.Entity.Employee;
import com.batchProcessing.boot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    // here we can use any type of executors like catcheThreadPool()  or fixedThreadPool() or singleThreadPool()
    private ExecutorService service= Executors.newFixedThreadPool(3);



    public void processCsvFile(String csvFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                service.submit(() -> {
                    //System.out.println("Starting batch processing for line: " + line);
                    Employee employee = new Employee();
                    employee.setEmployeeId(Integer.parseInt(data[0]));
                    employee.setEmployeeFirstName(data[1]);
                    employee.setEmployeeLastName(data[2]);
                    employee.setEmployeeSalary(Double.parseDouble(data[3]));
                    employee.setEmployeeEmail(data[4]);
                    employee.setEmployeeAddress(data[5]);
                    employeeRepository.save(employee);

                    //System.out.println("Starting batch processing for line: " + line);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }

    }


}
