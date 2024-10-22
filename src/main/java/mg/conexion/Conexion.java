package mg.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConextion() {
        Connection conexion = null;
        var baseDatos = "estudiante_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "root";

        // Cargamos la clase del drive de mysql en memoria
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurio un error en la conexion: " + e.getMessage());
        }

        return conexion;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConextion();
        if (conexion != null)
            System.out.println("Conexion exitosa: " + conexion);
        else
            System.out.println("Error al conectarse");
    }
}
