package com.fullstack.employeapiback.services;

import com.fullstack.employeapiback.entity.EmployeeEntity;
import com.fullstack.employeapiback.model.Employees;
import com.fullstack.employeapiback.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public Employees createEmployee(Employees employees) {
        EmployeeEntity employeeEntity= new EmployeeEntity();
        BeanUtils.copyProperties(employees, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employees;
    }

    public List<Employees> allEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employees> employees = employeeEntities
                .stream()
                .map(emp -> new Employees(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()
                ))
                .collect(Collectors.toList());
        return employees;
    }

    public void deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);
    }

    public Employees getEmployeeById(Long id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employees employees = new Employees();
        BeanUtils.copyProperties(employeeEntity, employees);
        return employees;
    }

    public Employees updateEmployee(Long id, Employees employees){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setFirstName(employees.getFirstName());
        employeeEntity.setLastName(employees.getLastName());
        employeeEntity.setEmailId(employeeEntity.getEmailId());
        employeeRepository.save(employeeEntity);
        return employees;
    }
}
