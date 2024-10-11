
package org.example;

import org.example.entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();
        System.out.println("El proeycto JPA base esta funcionando");

        try {
            //Iniciar Transacción
            em.getTransaction().begin();

            //Creo una Categoria
            Categoria categoria1 = Categoria.builder()
                    .denominacion("Baño")
                    .build();

            //Creo un Articulo
            Articulo articulo1 = Articulo.builder()
                    .cantidad(30)
                    .denominacion("Shampoo")
                    .precio(15)
                    .build();
            Articulo articulo2 = Articulo.builder()
                    .cantidad(50)
                    .denominacion("Jabon")
                    .precio(5)
                    .build();

            articulo1.addCategoria(categoria1); // Añado la categoria baño a shampoo
            articulo2.addCategoria(categoria1); // Añado la categoria baño a jabón


            //Creo un domicilio
            Domicilio domicilio1 = Domicilio.builder()
                    .numero(459)
                    .nombreCalle("Sobremonte")
                    .build();

            //Creo un cliente
            Cliente cliente1 = Cliente.builder()
                    .apellido("Perez")
                    .dni(25347564)
                    .nombre("Jorge")
                    .domicilio(domicilio1)  //asigno domicilio en sobremonte
                    .build();

            //Creo una factura
            Factura factura1 = Factura.builder()
                    .fecha("18-08-2024")
                    .numero(21234)
                    .cliente(cliente1)  //Relaciono el cliente a la factura
                    .total(500).build();

            //Creo dos detalles
            DetalleFactura detalle1 = DetalleFactura.builder()
                    .cantidad(12)
                    .subtotal(200)
                    .articulo(articulo1)    //asigno articulo shampoo
                    .factura(factura1)
                    .build();
            DetalleFactura detalle2 = DetalleFactura.builder()
                    .cantidad(10)
                    .subtotal(300)
                    .articulo(articulo2)    //asigno articulo jabon
                    .factura(factura1)
                    .build();

            factura1.getDetalles().add(detalle1);    //Relaciono los detalles a la factura
            factura1.getDetalles().add(detalle2);


            em.persist(factura1);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("Salí por el catch");
        }
        // Cerrar el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();
    }
}


