package com.example.employemangemnt.service;

import com.example.employemangemnt.model.Department;
import com.example.employemangemnt.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DeptServiceimp implements DeptService {

    @Autowired
    private DepartmentRepository DepartmentRepository;
@Override
    public List<Department> getAllDepartment() {
        return DepartmentRepository.findAll();
    }

    @Override

    public void saveDepartment(Department department) {
        this.DepartmentRepository.save(department);

    }

    @Override

    public Department GetDepartmentById(long dept_id) {
        Optional<Department> optional =DepartmentRepository.findById(dept_id);
        Department department=null;
        if (optional.isPresent()){
            department=optional.get();
        }
        else {
            throw new RuntimeException("Department not found for id::" + dept_id);
        }
        return department;
    }

    @Override
    public void DeleteDepartmentById(long dept_id) {
        this.DepartmentRepository.deleteById(dept_id);

    }




}

