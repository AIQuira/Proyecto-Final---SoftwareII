package co.edu.unicauca.mvc.modelos;

public class Persona {

    private String nombre;
    private String apellido;
    private int cedula;
    private String correo;
    private String contra;
    private int telefono;
    private int rol;
    
    public Persona(){
        
    }

    public Persona(String nombre, String apellido, int cedula, String correo, String contra) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
    }
    
    public Persona(int cedula, String nombre, String correo, String password, int telefono, int rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.contra = password;
        this.telefono = telefono;
        this.rol = rol;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return contra;
    }

    public void setPassword(String password) {
        this.contra = password;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
