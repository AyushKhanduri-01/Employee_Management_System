package com.assignment.ems.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assignment.ems.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
  
    public Optional<Employee> findByPhoneNumber(String phoneNumber);
}
