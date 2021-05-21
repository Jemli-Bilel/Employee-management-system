package com.example.employemangemnt.service;

import com.example.employemangemnt.model.Employee;
import com.example.employemangemnt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicemp implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
     return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);

    }

    @Override
    public Employee GetEmployeeById(long id) {
        Optional<Employee> optional =employeeRepository.findById(id);
        Employee employee=null;
        if (optional.isPresent()){
        employee=optional.get();
        }
       else {
            throw new RuntimeException("Employee not found for id::" + id);
        }
       return employee;
        }

    @Override
    public void DeleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }


}

