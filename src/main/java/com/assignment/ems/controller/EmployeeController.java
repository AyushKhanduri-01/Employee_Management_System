package com.assignment.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.ems.model.Employee;
import com.assignment.ems.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
     public List<Employee> getAllEmployee(){
        return employeeService.findAll();
     }


     @GetMapping("/{id}")
     ResponseEntity<Employee> getEmployeeByid(@PathVariable int id){
        Employee emp = employeeService.findById(id);
        if(emp != null){
            return ResponseEntity.ok(emp);
        }
        else{
            return ResponseEntity.notFound().build();
        }
     }

     @PostMapping("/addEmployee")
     ResponseEntity<String> addEmployee(@RequestBody Employee employee){
           if(employeeService.saveEmployee(employee)){
            return ResponseEntity.ok("successfull");
           }
           else{
            return ResponseEntity.badRequest().build();
           }
       
     }

     @GetMapping("/delete/{id}")
     ResponseEntity<String> deleteEmployee(@PathVariable int id){
    
        if(employeeService.deleteEmployee(id)){
           return ResponseEntity.ok("Successfull");
        }
        else{
            return ResponseEntity.badRequest().build();
        }
     }
     @PostMapping("/update")
     ResponseEntity <String> updateEmployee(@RequestBody Employee employee){
        if(employeeService.updateEmployee(employee)){
            return ResponseEntity.ok("Successfull");
        }
        else{
            return ResponseEntity.badRequest().build();
        }
     }
     
}
