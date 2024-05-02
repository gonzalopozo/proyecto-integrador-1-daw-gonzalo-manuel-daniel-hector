package model;

import java.net.ConnectException;
import java.sql.*;  
import org.sqlite.*;

public class AccesoBD {

    private String url = "jdbc:sqlite:C:\\Users\\gonza\\OneDrive\\Escritorio\\pro-int\\proyecto-integrador-1-daw-gonzalo-manuel-daniel-hector\\database\\database.db";


    public Connection getConexion() {
        Connection con = null;
    
        try{
            con = DriverManager.getConnection(url);

            System.out.println("Conexión a la base de datos establecida.");
        } catch (SQLException e){
            System.err.println("Error al conectar con la BD: ");
			e.printStackTrace();
    } 

        return con;
    }

    public void cerrarConexion(Connection con) {
        try {
            if (con!= null) {
                con.close();
            }
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }


    public void hacerConsulta(Connection c) throws SQLException{
        String query = "SELECT * FROM MIEMBROS";

        Statement stmt = c.createStatement();

        ResultSet result = stmt.executeQuery(query);

        while(result.next()) {
            System.out.print(result.getString("nombre") + " - ");
            System.out.print(result.getInt("num_expediente"));
            System.out.println();
        }

        result.close();
        stmt.close();
    }

    // public static void main(String[] args) {
    //     Connection abc = getConexion();
    //     try {
    //         hacerConsulta(abc);
            
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    //     cerrarConexion(abc);
    // }

}
