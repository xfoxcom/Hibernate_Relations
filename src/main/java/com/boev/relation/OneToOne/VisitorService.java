package com.boev.relation.OneToOne;

import com.boev.relation.OneToOne.repositories.PassportRepository;
import com.boev.relation.OneToOne.repositories.VisitorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisitorService {

    private final PassportRepository passportRepository;

    private final VisitorRepository visitorRepository;

    public VisitorService(PassportRepository passportRepository, VisitorRepository visitorRepository) {
        this.passportRepository = passportRepository;
        this.visitorRepository = visitorRepository;
    }

//    @PostConstruct
//    public void init() {
//
//       // CreateVisitorWithPassport();
//
//        DeleteVisitorWithPassport(2);
//
//        GetAllVisitors().forEach(System.out::println);
//
//        GetAllPassports().forEach(System.out::println);
//
//    }

    public void CreateVisitorWithPassport() {

        Visitor visitor = new Visitor("Olga", "+74999887878");

        Passport passport = new Passport("4400 789456",  LocalDate.of(2005, 5, 16));

        visitor.setPassport(passport);

        visitorRepository.save(visitor);
    }

    public void DeleteVisitorWithPassport(long id) {

        visitorRepository.deleteById(id);

    }

    public List<Visitor> GetAllVisitors() {
        return visitorRepository.findAll();
    }

    public List<Passport> GetAllPassports() {
        return passportRepository.findAll();
    }

}
