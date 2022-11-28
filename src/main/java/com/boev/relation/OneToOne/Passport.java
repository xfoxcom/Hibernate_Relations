package com.boev.relation.OneToOne;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long passport_id;
    private String serialNum;
    private LocalDate dateOfIssue;

    public Passport(String serialNum, LocalDate date) {
        this.serialNum = serialNum;
        this.dateOfIssue = date;
    }
}
