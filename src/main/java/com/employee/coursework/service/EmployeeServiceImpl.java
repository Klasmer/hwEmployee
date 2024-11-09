package com.employee.coursework.service;

import com.employee.coursework.Employee;
import com.employee.coursework.exeption.EmployeeAlreadyAddedException;
import com.employee.coursework.exeption.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import com.employee.coursework.exeption.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Сергеев"),
            new Employee("Василий", "Кузнецов")));
    private final int STORAGE_SIZE = 10;

    @Override
    public Employee add(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("База заполненна");
        }
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в базе");
        }
        employees.add(employee);
        return employee;
    }
    @Override
    public Employee remove (String firsName, String lastName) throws EmployeeNotFoundException{
        Employee employee = new Employee(firsName, lastName);
        if (employees.contains(employee)){
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Такой сотрудник в базе отсутствует");
    }
    public Employee find (String firsName, String lastName) throws EmployeeNotFoundException{
        Employee employee = new Employee(firsName, lastName);
        if (employees.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException("Такой сотрудник в базе отсутствует");
    }
    @Override
    public List<Employee> getAll(){
        return employees;
    }
}