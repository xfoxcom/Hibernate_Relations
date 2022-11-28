package com.boev.relation.ManyToMany;

import com.boev.relation.ManyToMany.repositories.ChildRepo;
import com.boev.relation.ManyToMany.repositories.SectionRepo;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private ChildRepo childRepo;

    @Autowired
    private SectionRepo sectionRepo;

    @PersistenceContext
    private EntityManager em;


    public void childrenToSection() {

        Child alex = new Child("Alex", 4);
        Child amigo = new Child("Amigo", 7);

        Section chess = new Section("Chess");

        chess.addChildToSection(alex);
        chess.addChildToSection(amigo);

        sectionRepo.save(chess);

    }

    @PostConstruct
    public void get() {
        GetSectionWithChildren(1)
                .getChildren()
                .forEach(child -> System.out.println(child.getName() + " " + child.getAge()));
    }

    public Section GetSectionWithChildren(int id) {

        var query = em.createQuery("SELECT s FROM Section s JOIN FETCH s.children c WHERE s.id = :id");

        query.setParameter("id", id);

        return (Section) query.getSingleResult();
    }
}
