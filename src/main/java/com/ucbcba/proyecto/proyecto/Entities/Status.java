package com.ucbcba.proyecto.proyecto.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="status")
public class Status {
    private Long id;
    private String name;
    private Set<Pedido> pedidos;

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

    @ManyToMany(mappedBy = "statuses")
    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
