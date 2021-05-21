package com.example.employemangemnt.controller;

import com.example.employemangemnt.model.Employee;
import com.example.employemangemnt.model.User;
import com.example.employemangemnt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String ViewHomePage(Model model) {
        return "Login";
    }
    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }

    @RequestMapping(value = "/login",  method= RequestMethod.GET)
    public String GetLoginForm(){
        return "Login";
    }
    @RequestMapping(value = "/index",  method= RequestMethod.GET)
    public String GetIndex(){
        return "index";
    }
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String Login(@ModelAttribute(name="User") User user, Model model ) {
        String mail = user.getMail();
        String password = user.getPassword();
        if ("admin@gmail.com".equals(mail) && "admin".equals(password)) {
            model.addAttribute("listEmployees", employeeService.getAllEmployees());
            return "home";
        }
        model.addAttribute("invalidCredentials",true);
        return "Login";

    }
    @GetMapping("/showEmployeeForm")

    public String showEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee" ;
    }
    // @PostMapping("/saveEmployee")
     //public String saveEmployee(@ModelAttribute("employee") Employee employee) {
      // employeeService.saveEmployee(employee);
     //return "redirect:new_employee";
    //}
    @RequestMapping(value = "/saveEmployee",method=RequestMethod.POST)
   public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model) {
       employeeService.saveEmployee(employee);
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
       return "index";}
       @GetMapping("/saveEmployee")
       public String saveemployee( Model model) {

           model.addAttribute("listEmployees", employeeService.getAllEmployees());
           return "index";}


    @GetMapping("/ShowFormforUpdate/{id}")
public String ShowFormforUpdate(@PathVariable(value ="id") long id ,Model model){
        Employee employee=employeeService.GetEmployeeById(id);
        model.addAttribute("employee",employee);
        return "update_employee";
    }
    @GetMapping("/DeleteEmployee/ {id}")
    public String DeleteEmployee(@PathVariable(value = "id") long id, Model model )  {

        this.employeeService.DeleteEmployeeById(id);
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }
    @RequestMapping(value = "/home",  method= RequestMethod.POST)
    public String PostHome(){
        return "home";
    }
    @GetMapping("/home")
    public String GetHome(){
        return "home";
    }


    }




