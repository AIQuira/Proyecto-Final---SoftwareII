package co.edu.unicauca.articulo.microservicio_articulo.dominio.estados;

import co.edu.unicauca.articulo.microservicio_articulo.dominio.ArticuloEntity;

public class EstadoBorrador implements IEstado {
    @Override
    public Resultado enviarArticulo(ArticuloEntity articulo) {
        EstadoEnviado estadoEnviado = new EstadoEnviado();
        articulo.setEstado(estadoEnviado);
        return new Resultado(true, "Artículo enviado");
    }

    @Override
    public Resultado revisionArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "No se puede revisar un artículo en estado Borrador");
    }

    @Override
    public Resultado requiereRevisionArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "No se puede requerir revisión de un artículo en estado Borrador");
    }

    @Override
    public Resultado aprobarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "No se puede aprobar un artículo en estado Borrador");
    }

    @Override
    public Resultado rechazarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "No se puede rechazar un artículo en estado Borrador");
    }


}
