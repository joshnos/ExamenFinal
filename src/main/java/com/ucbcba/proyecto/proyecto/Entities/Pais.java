package com.ucbcba.proyecto.proyecto.Entities;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPais;
    @NotNull
    @Size(min = 1, max = 50, message = "este campo debe tener entre 1 y 50 caracteres")
    private String name;


    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
