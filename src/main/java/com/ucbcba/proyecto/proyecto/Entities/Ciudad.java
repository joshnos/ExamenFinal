package com.ucbcba.proyecto.proyecto.Entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCiudad;
    @NotNull
    private String name;
    @OneToMany (mappedBy = "ciudad")
    private Set<User> users;
    @OneToMany (mappedBy = "ciudad")
    private Set<Empresa> empresas;


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }
}
