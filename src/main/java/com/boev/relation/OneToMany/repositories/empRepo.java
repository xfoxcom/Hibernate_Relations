package com.boev.relation.OneToMany.repositories;

import com.boev.relation.OneToMany.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface empRepo extends JpaRepository<Employee, Long> {
}
