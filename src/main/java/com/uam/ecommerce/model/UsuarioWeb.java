package com.uam.ecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="UsuarioWeb")
public class UsuarioWeb
{
    @Id
    private String id;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;

    @OneToMany( mappedBy = "usuarioWeb", cascade = CascadeType.ALL)
    private List<Direccion> direccions;
}
