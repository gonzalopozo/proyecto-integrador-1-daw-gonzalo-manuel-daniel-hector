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

    public String comprobarLogin(Connection c, String login) throws SQLException{

        String resultado = "";
        String query = "SELECT password FROM miembros WHERE miembros = '" + login + "'";
        Statement stmt = c.createStatement();

        ResultSet resultSet = stmt.executeQuery(query);

        while (resultSet.next()) {
            resultado = resultSet.getString("PASSWORD");
        }

        resultSet.close();
        stmt.close();

        return resultado;

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

    public void crearPersonaje(Connection c, String nombre, String raza, String clase, int miembro_id)  {
        // insert tipo crear personaje --> INSERT INTO personajes (nombre, raza, clase, miembro_id) VALUES ('Gimli', 'Enano', 'Guerrero', 1);

		String query = "INSERT INTO personajes (nombre, raza, clase, miembro_id) VALUES (?, ?, ?, ?)";

        try (Connection con = getConexion(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, raza);
            pstmt.setString(3, clase);
            pstmt.setInt(4, miembro_id);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
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
