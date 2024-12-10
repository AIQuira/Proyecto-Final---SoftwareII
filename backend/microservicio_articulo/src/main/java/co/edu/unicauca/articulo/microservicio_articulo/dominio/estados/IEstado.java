package co.edu.unicauca.articulo.microservicio_articulo.dominio.estados;

import co.edu.unicauca.articulo.microservicio_articulo.dominio.ArticuloEntity;

public interface IEstado {
    Resultado enviarArticulo(ArticuloEntity articulo);
    Resultado revisionArticulo(ArticuloEntity articulo);
    Resultado requiereRevisionArticulo(ArticuloEntity articulo);
    Resultado aprobarArticulo(ArticuloEntity articulo);
    Resultado rechazarArticulo(ArticuloEntity articulo);
}
