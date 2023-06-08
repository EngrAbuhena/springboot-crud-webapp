package com.rony.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rony.springboot.model.Employee;
import com.rony.springboot.service.EmployeeService;


@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value="/employees")
    public String getAllEmployees(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping(value = "/new")
    public String showAddEmployeePage(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add_new_employee";
    }

    @PostMapping(value = "/save")
    public String addNewEmployee(@ModelAttribute("employee") Employee employee){
        this.employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping(value = "/employee/{id}")
    public String editEmployeeById(@PathVariable(value = "id") long id, Model model){
        // get employee from service
        Employee employee = employeeService.getEmployeeById(id);

        // set employee as a model attribute
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEmployeeById(@PathVariable(value = "id") long id){
        // delete employee from database
        this.employeeService.deleteEmployeeById(id);

        return "redirect:/employees";
    }
    
}
