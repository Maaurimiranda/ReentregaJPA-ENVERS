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
@Table(name = "Articulo")
@Audited
public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private String denominacion;
    private int precio;

    //Relacion con categoria
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @Builder.Default
    private List<Categoria> categoria = new ArrayList<Categoria>();

    //relacion con detalle factura
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "articulo")
    @Builder.Default
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

    public Articulo(String denominacion, int cantidad, int precio) {
        this.denominacion = denominacion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void addCategoria(Categoria categoria) {
        this.categoria.add(categoria);
        categoria.getArticulo().add(this); // Esto sincroniza la categoría
    }

}
