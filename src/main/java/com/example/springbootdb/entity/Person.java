package com.example.springbootdb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String vorname;
}
