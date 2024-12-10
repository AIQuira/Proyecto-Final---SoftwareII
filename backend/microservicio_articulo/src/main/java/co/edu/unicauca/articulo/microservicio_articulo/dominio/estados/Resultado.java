package co.edu.unicauca.articulo.microservicio_articulo.dominio.estados;

public record Resultado(boolean cambioPermitido, String mensaje) {

    public Resultado(boolean cambioPermitido, String mensaje) {
        this.cambioPermitido = cambioPermitido;
        this.mensaje = mensaje;
    }

    public boolean cambioPermitido() {
        return this.cambioPermitido;
    }

    public String mensaje() {
        return this.mensaje;
    }
}
