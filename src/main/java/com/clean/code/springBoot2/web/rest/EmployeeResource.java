package com.clean.code.springBoot2.web.rest;


import com.clean.code.springBoot2.servece.EmployeeService;
import com.clean.code.springBoot2.domMain.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        Employee employee1=employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        Employee employee1=employeeService.save(employee);
        return ResponseEntity.ok(employee1);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee> > getAll(){
        List<Employee> employeeList =employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }
    @GetMapping("/employees/{name}")
    public ResponseEntity<List<Employee> > getAll(@PathVariable String name){
        List<Employee> employeeList =employeeService.findByName(name);
        return ResponseEntity.ok(employeeList);
    }
    @GetMapping("/employees/search")
    public ResponseEntity<List<Employee> > getAllSearch(@RequestParam String name){
        List<Employee> employeeList =employeeService.findAllByParam(name);
        return ResponseEntity.ok(employeeList);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("Row is delete");
    }
}
