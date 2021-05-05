package com.emergentes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {

    private String url = "jdbc:mysql://localhost:3306/bd_proyectos";
    private String usuario = "root";
    private String password = "";
    protected Connection conn = null;
    public ConexionBD() throws ClassNotFoundException {

        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion OK : " + conn);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL : " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de Driver : " + ex.getMessage());
        }
    }
    public Connection Conectar() {
        return conn;
    }
    public void Desconectar() {
        System.out.println("CERRANDO LA CONEXION: " + conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}
