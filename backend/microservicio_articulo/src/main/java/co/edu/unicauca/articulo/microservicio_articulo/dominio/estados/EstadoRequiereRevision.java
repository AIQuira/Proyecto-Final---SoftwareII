package co.edu.unicauca.articulo.microservicio_articulo.dominio.estados;

import co.edu.unicauca.articulo.microservicio_articulo.dominio.ArticuloEntity;

public class EstadoRequiereRevision implements IEstado {

    @Override
    public Resultado enviarArticulo(ArticuloEntity articulo) {
        EstadoEnviado estadoEnviado = new EstadoEnviado();
        articulo.setEstado(estadoEnviado);
        return new Resultado(true, "Artículo enviado");
    }

    @Override
    public Resultado revisionArticulo(ArticuloEntity articulo) {
        EstadoEnRevision estadoEnRevision = new EstadoEnRevision();
        articulo.setEstado(estadoEnRevision);
        return new Resultado(true, "Artículo en revisión");
    }

    @Override
    public Resultado requiereRevisionArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "El artículo ya se encuentra en estado 'Requiere Revisión'");
    }

    @Override
    public Resultado aprobarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "El artículo no puede ser aprobado en este estado");
    }

    @Override
    public Resultado rechazarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "El artículo no puede ser rechazado en este estado");
    }

}
