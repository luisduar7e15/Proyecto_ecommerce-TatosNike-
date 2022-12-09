package com.uam.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Direccion")
public class Direccion {
    @Id
    @SequenceGenerator(name = "direccion_seq",
            sequenceName = "direccion_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "direccion_seq")
    private Long id;
    private String departamento;
    private String municipio;
    @Column(name = "zip")
    private String codigoZip;
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UsuarioWeb usuarioWeb;


}
