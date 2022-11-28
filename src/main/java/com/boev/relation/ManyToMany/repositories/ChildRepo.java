package com.boev.relation.ManyToMany.repositories;

import com.boev.relation.ManyToMany.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepo extends JpaRepository<Child, Integer> {
}
