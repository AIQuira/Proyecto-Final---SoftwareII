package co.edu.unicauca.articulo.microservicio_articulo.dominio.estados;

import co.edu.unicauca.articulo.microservicio_articulo.dominio.ArticuloEntity;

public class EstadoEnRevision implements IEstado {
    //Transición En Revision -> Aceptado, Requiere Revisión

    @Override
    public Resultado enviarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "No se puede enviar un artículo en revisión");
    }

    @Override
    public Resultado revisionArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "El artículo ya se encuentra en revisión");
    }

    @Override
    public Resultado requiereRevisionArticulo(ArticuloEntity articulo) {
        EstadoRequiereRevision objEstado = new EstadoRequiereRevision();
        articulo.setEstado(objEstado);
        return new Resultado(true, "El artículo requiere revisión");
    }

    @Override
    public Resultado aprobarArticulo(ArticuloEntity articulo) {
        EstadoAprobado objEstado = new EstadoAprobado();
        articulo.setEstado(objEstado);
        return new Resultado(true, "El artículo ha sido aprobado");
    }

    @Override
    public Resultado rechazarArticulo(ArticuloEntity articulo) {
        EstadoNoAprobado objEstado = new EstadoNoAprobado();
        articulo.setEstado(objEstado);
        return new Resultado(true, "El artículo ha sido rechazado");
    }

}
