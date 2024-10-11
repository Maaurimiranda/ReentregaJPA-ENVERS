package org.example.entidades;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Factura")
@Audited
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private int numero;
    private int total;

    //relacion con DetalleFacutura
    @OneToMany(mappedBy = "factura",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    @Builder.Default
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

    //Relacion * - 1 de Factura con cliente
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    public Factura(int numero, String fecha, int total) {
        this.numero = numero;
        this.fecha = fecha;
        this.total = total;
    }
}
