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
@Table(name = "Categoria")
@Audited
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;

    //Relacion con categoria - categoria
    @ManyToMany(mappedBy = "categoria")
    @Builder.Default
    private List<Articulo> articulo = new ArrayList<Articulo>();

    public Categoria(String denominacion) {
        this.denominacion = denominacion;
    }

    public void addArticulo(Articulo articulo) {
        this.articulo.add(articulo);
        articulo.getCategoria().add(this); // Esto sincroniza el artículo
    }

}
