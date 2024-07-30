package com.assignment.ems.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.ems.model.Employee;
import com.assignment.ems.repository.EmployeeRepository;
import com.assignment.ems.service.EmployeeService;

@Service
public class EmployeeServiceImplement  implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return  repository.findById(id).orElse(null);
    }

    @Override
    public Employee findByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber).orElse(null);
    }

    @Override
    public boolean saveEmployee(Employee employee) {

        try{
            return (repository.save(employee)!=null)?true:false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

        
    }

    @Override
    public boolean deleteEmployee(int id) {
       try{
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
         return false;

       
       } 
       catch(Exception e){
        e.printStackTrace();
        return false;
       }
        
    }

    @Override
    public boolean updateEmployee(Employee employee) {
       if(repository.existsById(employee.getId())){
             Employee tempEmp = repository.findById(employee.getId()).orElse(null);
            tempEmp.setEmail(employee.getEmail());
            tempEmp.setAddress(employee.getAddress());
            tempEmp.setName(employee.getName());
            tempEmp.setPhoneNumber(employee.getPhoneNumber());

            return saveEmployee(employee);
       }
       else{
        return false;
       }
    }

    
}
