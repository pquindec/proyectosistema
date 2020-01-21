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
import metodo.Producto;
import metodo.cliente;


/**
 *
 * @author usuario
 */
public class IngProducto {
    Conexion conexion = new Conexion();
    Connection cn = conexion.gettConexion();
    PreparedStatement cst;
    public boolean Guardar(Object objNew) {
        Producto objN = (Producto) objNew;
        boolean estado = false;
        try {

            cst = cn.prepareCall("{call TodosP(null,?,?,?,?,?,'Insertar')}");

            cst.setString(1, objN.getNombre());
            cst.setDouble(2, objN.getNprecio());
            cst.setDouble(3, objN.getDprecio());
            cst.setInt(4, objN.getCantidad());
            cst.setString(5, objN.getTipo());
            cst.execute();
            

            estado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
    public ArrayList<Producto> Listar_Producto(){
        ArrayList<Producto> list = new ArrayList<Producto>();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConexion();
        String sql = "SELECT * FROM vistapro;";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setNprecio(rs.getDouble("nprecio"));
                p.setDprecio(rs.getDouble("dprecio"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setTipo(rs.getString("tipo"));
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
           Producto objN = (Producto) obj;
           boolean estado = false;
        try {
                     
          CallableStatement pst=cn.prepareCall("{Call TodosP(?,null,null,null,null,null,'Eliminar')}");
          pst.setInt(1, objN.getId());
              pst.executeUpdate();
              estado = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return estado;
    }
    public boolean Modificar(Object objNew) {
        Producto objN = (Producto) objNew;
        boolean estado = false;

        try {

            cst = cn.prepareCall("{call TodosP(?,?,?,?,?,?,'Actualizar')}");

            cst.setInt(1, objN.getId());
            cst.setString(2, objN.getNombre());
            cst.setDouble(3, objN.getNprecio());
            cst.setDouble(4, objN.getDprecio());
            cst.setInt(5, objN.getCantidad());
            cst.setString(6, objN.getTipo());
            cst.execute();

            estado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estado;
    }
}
