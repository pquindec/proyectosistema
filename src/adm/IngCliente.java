
package adm;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import metodo.cliente;


/**
 *
 * @author Administrator
 */
public class IngCliente {
Conexion conexion = new Conexion();
    Connection cn = conexion.gettConexion();
    PreparedStatement cst;
    public boolean Guardar(Object objNew) {
        cliente objN = (cliente) objNew;
        boolean estado = false;
        try {

            cst = cn.prepareCall("{call TodosU(?,?,?,?,?,'Insertar')}");

            cst.setString(1, objN.getCedula());
            cst.setString(2, objN.getNombre());
            cst.setString(3, objN.getApellido());
            cst.setString(4, objN.getCorreo());
            cst.setString(5, objN.getDireccion());
            cst.execute();
            

            estado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
    public ArrayList<cliente> Listar_Cliente(){
        ArrayList<cliente> list = new ArrayList<cliente>();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConexion();
        String sql = "SELECT * FROM vistacli;";
        
         try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                cliente vo = new cliente();
                vo.setCedula(rs.getString("cedula"));
                vo.setNombre(rs.getString("nombre"));
                vo.setApellido(rs.getString("apellido"));
                vo.setCorreo(rs.getString("correo"));
                vo.setDireccion(rs.getString("direccion"));
                list.add(vo);
            }
            }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                cn.close();
            }catch(Exception ex){}
        }
        return list;
}
public boolean eliminar(Object obj ){
           cliente objN = (cliente) obj;
           boolean estado = false;
        try {
                     
          CallableStatement pst=cn.prepareCall("{Call TodosU(?,null,null,null,null,'Eliminar')}");
          pst.setString(1, objN.getCedula());
          
              pst.executeUpdate();
              estado = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return estado;
    }
    public boolean Modificar(Object objNew) {
        cliente objN = (cliente) objNew;
        boolean estado = false;

        try {

            cst = cn.prepareCall("{call TodosU(?,?,?,?,?,'Actualizar')}");

            cst.setString(1, objN.getCedula());
            cst.setString(2, objN.getNombre());
            cst.setString(3, objN.getApellido());
            cst.setString(4, objN.getCorreo());
            cst.setString(5, objN.getDireccion());
            cst.execute();

            estado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
}