/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import metodo.Proveedor;

/**
 *
 * @author usuario
 */
public class IngProveedor {
    
    Conexion conexion = new Conexion();
    Connection cn = conexion.gettConexion();
    PreparedStatement cst;
        public boolean Guardar(Object objNew) {
        Proveedor objN = (Proveedor) objNew;
        boolean estado = false;
        try {

            cst = cn.prepareCall("{call TodosPro(null,?,?,?,?,?,'Insertar')}");
            cst.setString(1, objN.getCedula());
            cst.setString(2, objN.getNombre());
            cst.setString(3, objN.getApellido());
            cst.setString(4, objN.getDireccion());
            cst.setInt(5, objN.getNumero());
            cst.execute();
            estado = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
            public ArrayList<Proveedor> Listar_Producto(){
        ArrayList<Proveedor> list = new ArrayList<Proveedor>();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConexion();
        String sql = "SELECT * FROM vistador;";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Proveedor p = new Proveedor();
                p.setIdProveedor(rs.getInt("idProveedor"));
                p.setCedula(rs.getString("cedula"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setDireccion(rs.getString("direccion"));
                p.setNumero(rs.getInt("telefono"));
                list.add(p);
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
           Proveedor objN = (Proveedor) obj;
           boolean estado = false;
        try {
                     
          CallableStatement pst=cn.prepareCall("{Call TodosPro(?,null,null,null,null,null,'Eliminar')}");
          pst.setInt(1, objN.getIdProveedor());
              pst.executeUpdate();
              estado = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return estado;
    }
        public boolean Modificar(Object objNew) {
        Proveedor objN = (Proveedor) objNew;
        boolean estado = false;
        try {
            cst = cn.prepareCall("{call TodosPro(?,?,?,?,?,?,'Actualizar')}");
            cst.setInt(1, objN.getIdProveedor());
            cst.setString(2, objN.getCedula());
            cst.setString(3, objN.getNombre());
            cst.setString(4, objN.getApellido());
            cst.setString(5, objN.getDireccion());
            cst.setInt(6, objN.getNumero());
            cst.execute();
            estado = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
}
