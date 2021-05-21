package com.example.employemangemnt.service;

import com.example.employemangemnt.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);
    Employee GetEmployeeById(long id);
    void DeleteEmployeeById(long id);
}
