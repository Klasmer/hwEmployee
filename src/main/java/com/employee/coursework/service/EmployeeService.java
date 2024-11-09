package com.employee.coursework.service;

import com.employee.coursework.Employee;
import com.employee.coursework.exeption.EmployeeAlreadyAddedException;
import com.employee.coursework.exeption.EmployeeNotFoundException;
import com.employee.coursework.exeption.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee add(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;


    Employee remove(String firstName, String lastName) throws EmployeeNotFoundException;


    Employee find(String firstName, String lastName) throws EmployeeNotFoundException;


    List<Employee> getAll();
}
