package com.ntrs.xps.userapiinterviewalavala.repository;

import com.ntrs.xps.userapiinterviewalavala.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAllByFirstName(String firstName);
}
