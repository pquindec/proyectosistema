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
import metodo.cliente;
import metodo.usuarios;

/**
 *
 * @author usuario
 */
public class IngUsuarios {
    Conexion conexion = new Conexion();
    Connection cn = conexion.gettConexion();
    PreparedStatement cst;
    public boolean Guardar(Object objNew) {
        usuarios objN = (usuarios) objNew;
        boolean estado = false;
        try {

            cst = cn.prepareCall("{call cUsuario(null,?,?,?,?,?,'Insertar')}");

            cst.setString(1, objN.getNombre());
            cst.setString(2, objN.getApellido());
            cst.setString(3, objN.getUsuario());
            cst.setString(4, objN.getContrasena());
            cst.setInt(5, objN.getTipo_usuario());
            cst.execute();
            

            estado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
    public ArrayList<usuarios> Listar_Usuarios(){
        ArrayList<usuarios> list = new ArrayList<usuarios>();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConexion();
        String sql = "SELECT * FROM veruser;";
        
         try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                usuarios vo = new usuarios();
                vo.setId(rs.getInt("id"));
                vo.setNombre(rs.getString("nombre"));
                vo.setApellido(rs.getString("apellido"));
                vo.setUsuario(rs.getString("usuario"));
                vo.setTipo_usuario(rs.getInt("tipo_usuario"));
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
