package com.boev.relation.OneToMany.repositories;

import com.boev.relation.OneToMany.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface departRepo extends JpaRepository<Department, Long> {
}
