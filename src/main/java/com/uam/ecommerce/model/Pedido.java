package com.uam.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name="Pedido")
public class Pedido
{
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Pago pago;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;
    private Double total;

    @OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Detalle> detalles;

}
