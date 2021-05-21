package com.example.employemangemnt.service;

import com.example.employemangemnt.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DeptService {
    List<Department> getAllDepartment();

    void saveDepartment(Department department);
    Department GetDepartmentById(long dept_id);
    void DeleteDepartmentById(long dept_id);
}
