package com.lucas.em.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    private String name, email, jobTitle, phone, imageUrl;

    @Column(nullable = false, updatable = false)
    private String employeeCode;

}
