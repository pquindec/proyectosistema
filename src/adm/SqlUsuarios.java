
package adm;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import metodo.usuarios;

/**
 *
 * @author usuario
 */
public class SqlUsuarios extends Conexion{
    
    
    public boolean login(usuarios user){

    PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT u.id,u.usuario,u.contrasena,u.tipo_usuario,t.nombre,t.id "
                + "From usuarios AS u INNER JOIN tipo_usuario AS t ON u.tipo_usuario=t.id WHERE usuario=?";
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            rs = ps.executeQuery();
            if(rs.next()){
                if(user.getContrasena().equals(rs.getString(3))){
                    user.setId(rs.getInt(1));
                    user.setNombre(rs.getString(2));
                    user.setTipo_usuario(rs.getInt(4));
                    return true;
                }else
                    return false;
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    
}

}
