package com.assignment.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.ems.model.Employee;

@Service
public interface EmployeeService {
   

     public List<Employee> findAll();

     public Employee findById(int id);

     public Employee findByPhoneNumber(String phoneNumber);

     public boolean saveEmployee(Employee employee);

     public boolean deleteEmployee(int id);

     public boolean updateEmployee(Employee employee);

     
}
