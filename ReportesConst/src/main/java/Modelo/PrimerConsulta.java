 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macbook
 */
public class PrimerConsulta {
    public void primerconsulta(DefaultTableModel modelo){
        
        LiderVo lider =new LiderVo();
        
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery("select id_lider, nombre, primer_apellido, ciudad_residencia from Lider order by ciudad_residencia");
            
            while(rs.next()){
                lider.setId_lider(rs.getInt(1));
                lider.setNombre(rs.getString(2));
                lider.setPrimer_apellido(rs.getString(3));
                lider.setCiudad_residencia(rs.getString(4));
                
             modelo.addRow(new Object[]{lider.getId_lider(), lider.getNombre(), lider.getPrimer_apellido(), lider.getCiudad_residencia()});
            }
            rs.close();
            cn.close();
        }catch (SQLException ex) {
            Logger.getLogger(PrimerConsulta.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
