package com.uam.ecommerce.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "DETALLE")
public class DetalleOrder {
    @Id
    @SequenceGenerator(name = "detalle_seq",
            sequenceName = "detalle_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "detalle_seq")
    private Long id;
    private Long idProducto;
    private int count;

    //mismo tipo de la llave en order
    private Long idOrder;

}
