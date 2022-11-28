package com.boev.relation.ManyToMany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
@Getter
@Setter
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section",
    joinColumns = @JoinColumn(name = "child_id"),
    inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Section> sections;

    public Child() {}

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addSectionToChild(Section section) {
        if (sections == null) sections = new ArrayList<>();

        sections.add(section);
    }
}
