package com.fullstack.employeapiback.controller;

import com.fullstack.employeapiback.model.Employees;
import com.fullstack.employeapiback.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    private Employees postEmployee(@RequestBody Employees employees){
         return employeeService.createEmployee(employees);
    }

    @GetMapping("/allEmployees")
    @ResponseStatus(HttpStatus.OK)
    private List<Employees> getAllEmployee(){
        return employeeService.allEmployee();
    }

    @DeleteMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteEmployeeById(@PathVariable Long id){employeeService.deleteEmployee(id);}

    @GetMapping("/{id}")
    private Employees employeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private Employees updateEmployee(@PathVariable Long id, @RequestBody Employees employees){
        return employeeService.updateEmployee(id, employees);
    }
}
