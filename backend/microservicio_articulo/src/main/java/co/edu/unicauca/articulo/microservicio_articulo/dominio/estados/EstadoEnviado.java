package co.edu.unicauca.articulo.microservicio_articulo.dominio.estados;

import co.edu.unicauca.articulo.microservicio_articulo.dominio.ArticuloEntity;

public class EstadoEnviado implements IEstado {

    @Override
    public Resultado enviarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "El artículo ya se encuentra en estado 'Enviado'");
    }

    @Override
    public Resultado revisionArticulo(ArticuloEntity articulo) {
        EstadoEnRevision objEstado = new EstadoEnRevision();
        articulo.setEstado(objEstado);
        return new Resultado(true, "El artículo ha pasado a estado 'En Revisión'");
    }

    @Override
    public Resultado requiereRevisionArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "El artículo no puede pasar a estado 'Requiere Revisión' desde 'Enviado'");
    }

    @Override
    public Resultado aprobarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "El artículo no puede pasar a estado 'Aprobado' desde 'Enviado'");
    }

    @Override
    public Resultado rechazarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "El artículo no puede pasar a estado 'Rechazado' desde 'Enviado'");
    }
}
