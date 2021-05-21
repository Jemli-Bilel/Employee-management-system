package com.example.employemangemnt.controller;

import com.example.employemangemnt.model.Department;
import com.example.employemangemnt.model.Employee;
import com.example.employemangemnt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DepartmentController {
    @Autowired
    private DeptService deptService;
    @RequestMapping(value = "/saveDepartment",method= RequestMethod.POST)
    public String saveDepartment(@ModelAttribute("Department") Department department, Model model) {
        deptService.saveDepartment(department);
        model.addAttribute("listDepartment", deptService.getAllDepartment());
        return "deptList";

    }
    @GetMapping("/saveDepartment")
    public String savedepartment( Model model) {

        model.addAttribute("listDepartment", deptService.getAllDepartment());
       return "deptList";
    }
    @GetMapping("/showdepartmentForm")

    public String showdepartmentForm(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "new_department";

    }
    @GetMapping("/ShowFormforUpdatedept/{dept_id}")
    public String ShowFormforUpdatedept(@PathVariable(value ="dept_id") long dept_id , Model model){
        Department  department=deptService.GetDepartmentById(dept_id);
        model.addAttribute("department",department);
        return "update_department";
    }
    @GetMapping("/DeleteDepartment/ {dept_id}")
    public String DeleteDepartment(@PathVariable(value = "dept_id") long dept_id, Model model )  {

        this.deptService.DeleteDepartmentById(dept_id);
        model.addAttribute("listDepartment", deptService.getAllDepartment());
        return "deptList";
    }


}

