package com.uam.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="Producto")
public class Producto
{
    private Boolean display;
    @Id
    @GeneratedValue()
    private UUID id;
    private String nombre;
    private String modelo;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String imagen;
    private double precio;
    private Long cantidad;
}
