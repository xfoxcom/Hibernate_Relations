package com.boev.relation.OneToOne.repositories;

import com.boev.relation.OneToOne.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {
}
