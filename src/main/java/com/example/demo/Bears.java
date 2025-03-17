package com.example.demo;

import jakarta.persistence.*;


@Entity
@Table(name = "Bears")
public class Bears{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BearsId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double age;

    public Bears(int BearsId, String name, String description, double age) {
        this.BearsId = BearsId;
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public Bears(String name, String description, double age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }

    //Always include a no-argument constructor.
    public Bears() {
    }


    public int getBearsId() {
        return BearsId;
    }

    public void setBearsId(int BearsId) {
        this.BearsId = BearsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}

