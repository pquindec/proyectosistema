/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo;

import adm.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class Tabla {
    IngUsuarios use = null;
    IngProducto pro = null;
    IngProveedor dor=null;
    IngCliente cli= null;
    int j;
    
    public void ver_usuarios(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };    
            dt.addColumn("Id");
            dt.addColumn("Nombre");
            dt.addColumn("Apellido");
            dt.addColumn("Usuario");
            dt.addColumn("Tipo de Usuario");
            use = new IngUsuarios();
            
            usuarios us = new usuarios();
            ArrayList<usuarios> list = use.Listar_Usuarios();
             if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[6];
                us = list.get(i);
                fila[0] = us.id;
                fila[1] = us.nombre;
                fila[2] = us.apellido;
                fila[3] = us.usuario;
                fila[4] = us.tipo_usuario; 
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(20);
        }
    
    }
    public void ver_producto(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new Render());
          DefaultTableModel dt = new DefaultTableModel(){
              
            public boolean isCellEditable(int row, int column){
                return true;
            }
        }; 
          dt.addColumn("Id");
            dt.addColumn("Nombre");
            dt.addColumn("Precio Normal");
            dt.addColumn("Precio Descuento");
            dt.addColumn("Cantidad");
            dt.addColumn("Tipo de medicina");
            dt.addColumn("Modificar");
            dt.addColumn("Eliminar");
            JButton btn_modificar = new JButton("Modificar");
            btn_modificar.setName("m");
            JButton btn_eliminar = new JButton("Eliminar");
            btn_eliminar.setName("e");
            pro= new IngProducto();
            Producto p = new Producto();
             ArrayList<Producto> list = pro.Listar_Producto();
               if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[8];
                p = list.get(i);
                fila[0] = p.id;
                fila[1] = p.nombre;
                fila[2] = p.nprecio;
                fila[3] = p.dprecio;
                fila[4] = p.cantidad;
                fila[5] = p.tipo;
                fila[6] = btn_modificar;
                fila[7] = btn_eliminar;
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(20);
        }
    }
    public void ver_proveedor(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new Render());
          DefaultTableModel dt = new DefaultTableModel(){
              
            public boolean isCellEditable(int row, int column){
                return true;
            }
        }; 
            dt.addColumn("Id");
            dt.addColumn("Cedula");
            dt.addColumn("Nombre");
            dt.addColumn("Apellido");
            dt.addColumn("Direccion");
            dt.addColumn("Telefono");
            dt.addColumn("Modificar");
            dt.addColumn("Eliminar");
            JButton btn_modificar = new JButton("Modificar");
            btn_modificar.setName("m");
            JButton btn_eliminar = new JButton("Eliminar");
            btn_eliminar.setName("e");
            dor = new IngProveedor();
            Proveedor p= new Proveedor();
            ArrayList<Proveedor> list = dor.Listar_Producto();
            if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[8];
                p = list.get(i);
                fila[0] = p.idProveedor;
                fila[1] = p.cedula;
                fila[2] = p.nombre;
                fila[3] = p.apellido;
                fila[4] = p.direccion;
                fila[5] = p.numero;
                fila[6] = btn_modificar;
                fila[7] = btn_eliminar;
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(20);
            } 
    }
        public void ver_cliente(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new Render());
          DefaultTableModel dt = new DefaultTableModel(){
              
            public boolean isCellEditable(int row, int column){
                return true;
            }
        }; 
            dt.addColumn("Cedula");
            dt.addColumn("Nombre");
            dt.addColumn("Apellido");
            dt.addColumn("Correo");
            dt.addColumn("Direccion"); 
            dt.addColumn("Modificar");
            dt.addColumn("Eliminar");
            JButton btn_modificar = new JButton("Modificar");
            btn_modificar.setName("m");
            JButton btn_eliminar = new JButton("Eliminar");
            btn_eliminar.setName("e");
            cli = new IngCliente();
            cliente p= new cliente();
            ArrayList<cliente> list = cli.Listar_Cliente();
            if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[7];
                p = list.get(i);
                fila[0] = p.cedula;
                fila[1] = p.nombre;
                fila[2] = p.apellido;
                fila[3] = p.correo;
                fila[4] = p.direccion;
                fila[5] = btn_modificar;
                fila[6] = btn_eliminar;
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(20);
            } 
    }
        public void factura(JTable tabla,String cantidad,String nombre){
               tabla.setDefaultRenderer(Object.class, new Render());
          DefaultTableModel dt = new DefaultTableModel(){
              
            public boolean isCellEditable(int row, int column){
                
                return true;
            }
            
        }; 
            dt.addColumn("Producto");
            dt.addColumn("Cantidad");
            dt.addColumn("Precio Normal");
            dt.addColumn("Precio descuento");
            dt.addColumn("Eliminar");
            JButton btn_eliminar = new JButton("Eliminar");
            btn_eliminar.setName("e");
            pro= new IngProducto();
            Producto p = new Producto();
             ArrayList<Producto> list = pro.Listar_Producto();
         
            for(int i=0; i<list.size(); i++){
                p = list.get(i);
                if(list.get(i).getNombre().equals(nombre)){
                    
                    
                    dt.addRow(new Object[]{p.nombre,cantidad,p.nprecio,p.dprecio,btn_eliminar});
                    
                    break;  
                }
            
            tabla.setModel(dt);
            tabla.setRowHeight(20);
            
        }
        
        }
}
//
//tblTaskList = new JTable();
//    tblTaskList.setShowVerticalLines(false);
//    tblTaskList.setCellSelectionEnabled(true);
//    tblTaskList.setColumnSelectionAllowed(true);
//    tblTaskList.setBorder(new LineBorder(null));
//    for (int count = 1; count <= 10; count++) {
//        tblTaskList.setModel(new DefaultTableModel(new Object[][] { {
//                count, "title1", "start", "stop", "pause", "status" }, },
//                new String[] { "status", "Task Title", "Start", "Stop",
//                        "Pause", "Status" }));
//    }
//    tblTaskList.getColumnModel().getColumn(0).setPreferredWidth(31);
//    tblTaskList.getColumnModel().getColumn(1).setPreferredWidth(346);
//    tblTaskList.getColumnModel().getColumn(2).setPreferredWidth(33);
//    tblTaskList.getColumnModel().getColumn(3).setPreferredWidth(31);
//    tblTaskList.getColumnModel().getColumn(4).setPreferredWidth(28);
//
//    tblTaskList.setBounds(93, 34, 614, 160);
//    frmTaskList.getContentPane().add(tblTaskList);