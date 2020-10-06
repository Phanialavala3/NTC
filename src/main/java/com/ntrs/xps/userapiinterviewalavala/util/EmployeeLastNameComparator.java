package com.ntrs.xps.userapiinterviewalavala.util;

import com.ntrs.xps.userapiinterviewalavala.entity.Employee;

import java.util.Comparator;

public class EmployeeLastNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
