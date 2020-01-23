
package metodo;

/**
 *
 * @author usuario
 */
public class Proveedor {
    int idProveedor;
    String cedula;
    String nombre;
    String apellido;
    String direccion;
    int numero;
    public Proveedor(){
        
    }
    public Proveedor(int idProveedor,String cedula,String nombre,String apellido,String direccion,int numero){
        this.idProveedor=idProveedor;
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.numero=numero;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
