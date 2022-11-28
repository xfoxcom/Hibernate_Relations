package com.boev.relation.ManyToMany.repositories;

import com.boev.relation.ManyToMany.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepo extends JpaRepository<Section, Integer> {
}
