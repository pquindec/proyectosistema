package adm;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    
    
    private final String user = "user";
    private final String password = "pquinde";
    private final String url = "jdbc:sqlserver://192.168.27.230:1433;database=farmacia";
    private Connection con = null;
    static Connection co = null;
    public static String User="user";
    public static String Clave="pquinde";
    public static boolean status = false;
    
    public Connection getConexion()
    {
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch(SQLException e)
        {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return con;  
    }
    public Connection gettConexion() {
        status = false;
        String url = "jdbc:sqlserver://192.168.27.230:1433;databaseName=farmacia";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        try {
            co = DriverManager.getConnection(url, this.user, this.password);
            status = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return co;
    }

    public static void setcuenta(String user, String clave) {
        Conexion.User = user;
        Conexion.Clave = clave;
    }
    public static boolean getstatus() {
        return status;
    }

    public  ResultSet Consulta(String consulta) {
        Connection con = gettConexion();
        Statement declara;
        
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

}
