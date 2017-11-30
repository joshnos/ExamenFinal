package com.ucbcba.proyecto.proyecto.Entities;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

@Entity
public class  Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @NotNull
    private int precio;
    @NotNull
    @ManyToOne
    private User user;
    @NotNull
    @ManyToOne
    private Empresa empresa;
    @NotNull
    @OneToMany(mappedBy = "pedido")
    private Set<Opcion_Pedido> opcion_pedidos = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "status_pedido", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "status_id"))
    private Set<Status> statuses;
    private boolean Estado;
    private String direccion;

    public Set<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }


    public Pedido(){
        Estado=true;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public boolean getEstado(){
        return Estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setOpcion_pedidos(Set<Opcion_Pedido> opcion_pedidos) {
        this.opcion_pedidos = opcion_pedidos;
    }

    public Set<Opcion_Pedido> getOpcion_pedidos() {
        return opcion_pedidos;
    }
}
