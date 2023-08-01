/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tutorsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bryga
 */
public class Conexion {
    private String url="jdbc:mysql://localhost:3306/tienda_celulares?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String usuario="root";
    private String clave="12345678"; 
    
    public ResultSet EjecutaSQL(String Sql) throws ClassNotFoundException{
        ResultSet resultado=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,usuario,clave);
            PreparedStatement pst = con.prepareStatement(Sql);
            resultado = pst.executeQuery();
            return resultado;
        }
        catch(SQLException e){
            return resultado;
        }
    }
    
    public void EjecutaSqlIUD(String sql) throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url, usuario, clave);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
        }catch (SQLException e){
        }
    }
}
