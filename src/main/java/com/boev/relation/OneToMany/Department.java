package com.boev.relation.OneToMany;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int salary;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH},
    mappedBy = "department")
    @ToString.Exclude
    private List<Employee> employees;

    public void addEmployeeToDepartment(Employee employee) {
        if (employees == null) employees = new ArrayList<>();
        employees.add(employee);
        employee.setDepartment(this);
    }

    public Department(String name, int salary) {
        this.name = name;
        this.salary = salary;

    }
}
