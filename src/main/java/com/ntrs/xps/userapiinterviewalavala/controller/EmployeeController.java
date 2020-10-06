package com.ntrs.xps.userapiinterviewalavala.controller;

import com.ntrs.xps.userapiinterviewalavala.entity.Employee;
import com.ntrs.xps.userapiinterviewalavala.service.EmployeeService;
import com.ntrs.xps.userapiinterviewalavala.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    @Autowired
//    private EmployeeService empService;

    @Autowired
    private EmployeeServiceImpl service;



    @PostMapping("/addEmployee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping("/getEmployeesByFirstName/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesByFirstName(@PathVariable("firstName") String firstName){
        return service.getEmployeesByFirstName(firstName);
    }

}
