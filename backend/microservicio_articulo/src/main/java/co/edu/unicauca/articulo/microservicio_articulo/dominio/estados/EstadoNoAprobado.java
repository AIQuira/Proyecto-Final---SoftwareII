package co.edu.unicauca.articulo.microservicio_articulo.dominio.estados;

import co.edu.unicauca.articulo.microservicio_articulo.dominio.ArticuloEntity;

public class EstadoNoAprobado implements IEstado{

    @Override
    public Resultado enviarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "No se puede enviar el articulo, ya fue rechazado");
    }

    @Override
    public Resultado revisionArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "No se puede revisar el articulo, ya fue rechazado");
    }

    @Override
    public Resultado requiereRevisionArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "No se puede requerir revision del articulo, ya fue rechazado");
    }

    @Override
    public Resultado aprobarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "No se puede aprobar el articulo, ya fue rechazado");
    }

    @Override
    public Resultado rechazarArticulo(ArticuloEntity articulo) {
        return new Resultado(false, "No se puede rechazar el articulo, ya fue rechazado");
    }
    
}
