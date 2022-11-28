package com.boev.relation.OneToMany;

import com.boev.relation.OneToMany.repositories.departRepo;
import com.boev.relation.OneToMany.repositories.empRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private departRepo departments;

    private empRepo employees;

    public DepartmentService(departRepo departments, empRepo employees) {
        this.departments = departments;
        this.employees = employees;
    }

    @PostConstruct
    public void init() {

//        Department department = new Department("IT", 500);
//
//        Employee employee1 = new Employee("Alex");
//        Employee employee2 = new Employee("Olga");
//
//        department.addEmployeeToDepartment(employee1);
//        department.addEmployeeToDepartment(employee2);
//
//        departments.save(department);

       // departmentList().forEach(System.out::println);

       // departmentList().forEach(r -> System.out.println(r + " "));

       // empList().forEach(r -> System.out.println(r + " "));
    }


    public List<String> departmentList() {
        return departments.findAll()
                .stream()
                .map(Department::getName)
                .collect(Collectors.toList());
    }

    public List<String> empList() {
        return departments.findAll()
                .stream()
                .map(Department::getEmployees)
                .flatMap(emp -> emp.stream().map(Employee::getName))
                .distinct()
                .collect(Collectors.toList());

    }



}
