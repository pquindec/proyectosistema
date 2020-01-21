
package metodo;

public class cliente {
    String cedula;
    String nombre;
    String apellido;
    String correo;
    String direccion;
    public cliente(String cedula,String nombre,String apellido,String correo,String direccion){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.correo=correo;
        this.direccion=direccion;
    }
    public cliente(){
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
