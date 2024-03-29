package com.example.helloworld.core;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "people")
@EqualsAndHashCode
@Getter
@Setter
@NamedQueries(
    {
        @NamedQuery(
            name = "com.example.helloworld.core.Person.findAll",
            query = "SELECT p FROM Person p"
        )
    })
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;

    public Person() {
    }

    public Person(String fullName, String jobTitle) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
    }

}
