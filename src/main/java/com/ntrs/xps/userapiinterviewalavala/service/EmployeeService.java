package com.ntrs.xps.userapiinterviewalavala.service;

import com.ntrs.xps.userapiinterviewalavala.entity.Employee;

import java.util.List;

public interface EmployeeService {


    public Employee saveEmployee(final Employee employee);
    public List<Employee> getEmployeesByFirstName(final String firstName);
}
