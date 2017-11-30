package com.ucbcba.proyecto.proyecto.Entities;

import javax.persistence.*;

@Entity
@Table(name="status")
public class Status {
    private Long id;
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //falta relacionar con pedido en una relacion many to many
}
