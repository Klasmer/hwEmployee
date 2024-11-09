package com.employee.coursework.controller;

import com.employee.coursework.Employee;
import com.employee.coursework.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")

    public Employee addEmployee(

            @RequestParam("firstName") String firstName,

            @RequestParam("lastName") String lastName

    ) {

        return employeeService.add(firstName, lastName);

    }

    @GetMapping("/remove")

    public Employee removeEmployee(

            @RequestParam("firstName") String firstName,

            @RequestParam("lastName") String lastName

    ) {

        return employeeService.remove(firstName, lastName);

    }

    @GetMapping("/find")

    public Employee findEmployee(

            @RequestParam("firstName") String firstName,

            @RequestParam("lastName") String lastName

    ) {

        return employeeService.find(firstName, lastName);

    }

    @GetMapping("/allEmployee")

    public List<Employee> getAllEmployees() {

        return employeeService.getAll();


    }

}
