package com.uam.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="Detalle")
public class Detalle
{
    @Id
    @GeneratedValue
    private UUID id;
    private Long idProducto;
    private Long cantidad;
    private Date diaEntrega;
    private Date fechaPago;
    private double subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pedido pedido;

}
