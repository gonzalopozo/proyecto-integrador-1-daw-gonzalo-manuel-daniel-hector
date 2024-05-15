package model;

import java.net.ConnectException;
import java.sql.*;  
import org.sqlite.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

public class AccesoBD {

    private String url = "jdbc:sqlite:C:\\Users\\Manu\\Desktop\\proyecto\\proyecto-integrador-1-daw-gonzalo-manuel-daniel-hector";

    
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
        String query = "SELECT password FROM miembros WHERE nombre = '" + login + "'";
        Statement stmt = c.createStatement();

        ResultSet resultSet = stmt.executeQuery(query);

        while (resultSet.next()) {
            resultado = resultSet.getString("PASSWORD");
        }

        resultSet.close();
        stmt.close();

        return resultado;
    }

    public void obtenerDatos (Connection c) throws SQLException{
        String query = "SELECT * FROM PERSONAJES";

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

    /*
    public void hacerConsulta(Connection c) throws SQLException{
        String query = "SELECT * FROM MIEMBROS";

        ArrayList<String> datos = new ArrayList<String>();

        Statement stmt = c.createStatement();

        ResultSet result = stmt.executeQuery(query);

        while(result.next()) {
            System.out.print(result.getString("nombre"));
            String nombre = result.getString("nombre");
            datos.add(nombre);
            System.out.println(result.getString("raza"));
            String raza = result.getString("raza");
            datos.add(raza);
            System.out.println(result.getString("clase"));
            String clase = result.getString("clase");
            datos.add(clase);
            System.out.println(result.getInt("nivel"));
            int nivel = result.getInt("nivel");
            datos.add(nivel);                
            System.out.println(result.getInt("destreza"));
            int destreza = result.getInt("destreza");
            datos.add(destreza);
            System.out.println(result.getInt("sabiduria"));
            int sabiduria = result.getInt("sabiduria");
            datos.add(sabiduria);
            System.out.println(result.getInt("carisma"));
            int carisma = result.getInt("carisma");
            datos.add(carisma);
            System.out.println(result.getInt("inteligencia"));
            int inteligencia = result.getInt("inteligencia");
            datos.add(inteligencia);
            System.out.println(result.getInt("constitucion"));
            int constitución = result.getInt("constitucion");
            datos.add(constitucion);
            System.out.println();


        }

        result.close();
        stmt.close();

        return datos;
    }
    */

    public void crearPersonaje(Connection c, String nombre, String raza, String clase, int miembro_id)  {
        // insert tipo crear personaje --> INSERT INTO personajes (nombre, raza, clase, miembro_id) VALUES ('Gimli', 'Enano', 'Guerrero', 1);

		String query = "INSERT INTO personajes (nombre, raza, clase, miembro_id) VALUES (?, ?, ?, ?)";

        try (Connection con = getConexion(); PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, raza);
            pstmt.setString(3, clase);
            pstmt.setInt(4, miembro_id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage()); 
        }
    }

    public void unirsePartida(Connection c, int idPersonaje, int idPartida){

        String query = "INSERT INTO juega VALUES (1, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = getConexion(); PreparedStatement pstmt = con.prepareStatement(query)){

            pstmt.setInt(1, idPersonaje);
            pstmt.setInt(2, idPartida);

            Random rnd = new Random();

            for (int i = 3; i <= 9; i++) {
                pstmt.setInt(i, rnd.nextInt(100,141));
            }
            
            pstmt.executeUpdate();
            
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
