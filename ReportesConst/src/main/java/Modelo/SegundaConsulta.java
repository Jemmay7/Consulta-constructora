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
public class SegundaConsulta {
    public void segundaconsulta(DefaultTableModel modelo){
        
        ProyectoVo proyecto =new ProyectoVo();
        
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_proyecto, constructora, numero_habitaciones, ciudad from Proyecto where clasificacion = 'Casa Campestre' and ciudad in ('Santa Marta', 'Barranquilla', 'Cartagena')");
            
            while(rs.next()){
                proyecto.setId_Proyecto(rs.getInt(1));
                proyecto.setConstructora(rs.getString(2));
                proyecto.setNumero_habitaciones(rs.getInt(3));
                proyecto.setCiudad(rs.getString(4));
                
             modelo.addRow(new Object[]{proyecto.getId_Proyecto(), proyecto.getConstructora(), proyecto.getNumero_habitaciones(), proyecto.getCiudad()});
            }
            rs.close();
            cn.close();
        }catch (SQLException ex) {
            Logger.getLogger(PrimerConsulta.class.getName()).log(System.Logger.Level.SEVERE, null, ex);
    }
}

}
