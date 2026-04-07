package com.example.clientes.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends PanacheEntity {
    public String nombre;
    public String email;
    public String telefono;
}
