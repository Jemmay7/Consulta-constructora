/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macbook
 */
public class TerceraConsulta {
    public void terceraconsulta(DefaultTableModel modelo){
        
        ClienteVo cliente =new ClienteVo();
        
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID_Compra, p.Constructora, p.Banco_Vinculado FROM Compra c JOIN Proyecto p on (c.ID_Proyecto= p.ID_Proyecto) where Proveedor = 'Homecenter' and p.ciudad ='Salento';");
            
            while(rs.next()){
                cliente.setId_compra(rs.getInt(1));
                cliente.setConstructora(rs.getString(2));
                cliente.setBanco(rs.getString(3));
                
             modelo.addRow(new Object[]{cliente.getId_compra(), cliente.getConstructora(), cliente.getBanco()});
            }
            rs.close();
            cn.close();
        }catch (SQLException ex) {
            Logger.getLogger(PrimerConsulta.class.getName()).log(System.Logger.Level.SEVERE, null, ex);
    }
}

}
