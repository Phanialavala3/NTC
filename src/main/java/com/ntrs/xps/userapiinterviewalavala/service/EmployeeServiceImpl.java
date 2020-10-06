package com.ntrs.xps.userapiinterviewalavala.service;

import com.ntrs.xps.userapiinterviewalavala.entity.Employee;
import com.ntrs.xps.userapiinterviewalavala.repository.EmployeeRepository;
import com.ntrs.xps.userapiinterviewalavala.util.EmployeeLastNameComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repo){
        this.repository = repo;
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);

    }

    @Override
    public List<Employee> getEmployeesByFirstName(String firstName) {
        List<Employee> empList = repository.findAllByFirstName(firstName);
        Collections.sort(empList, new EmployeeLastNameComparator());
        return empList;
    }
}
