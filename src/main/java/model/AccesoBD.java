package model;

import java.net.ConnectException;
import java.sql.*;  
import org.sqlite.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

import main.*;

public class AccesoBD {

    private String url = "jdbc:sqlite:C:\\Users\\gonza\\Desktop\\AAAABBBB\\proyecto-integrador-1-daw-gonzalo-manuel-daniel-hector\\database\\database.db";


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

    public Object[] comprobarLogin(Connection c, String login) throws SQLException{

        Object resultado[] =  new Object[2];
        String query = "SELECT id, password FROM miembros WHERE nombre = '" + login + "'";
        Statement stmt = c.createStatement();

        ResultSet resultSet = stmt.executeQuery(query);

        while (resultSet.next()) {
            resultado[0] = resultSet.getInt("id");
            resultado[1] = resultSet.getString("password");
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

    
    public ArrayList<String[]> hacerConsultaTablaCuenta(Connection c) throws SQLException{
        ArrayList<String[]> arrayListBidimensional = new ArrayList<>();

        String query = "SELECT p.nombre AS Nombre, p.raza AS Raza, p.clase AS Clase, j.partida_id AS Partida, j.nivel AS Nivel, j.salud AS Salud, j.fuerza AS Fuerza, j.destreza AS Destreza, j.sabiduria AS Sabiduría, j.carisma AS Carisma, j.inteligencia AS Inteligencia, j.constitucion AS Constitución FROM personajes p JOIN juega j ON p.id = j.personaje_id JOIN partidas pa ON j.partida_id = pa.id JOIN miembros m ON p.miembro_id = m.id WHERE m.id = ? AND pa.esta_en_curso = 1;";

        System.out.println(App.getMiembroActual());

        ResultSet resultados = null;
        try (Connection con = getConexion(); PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, App.getMiembroActual());

            resultados = pstmt.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage()); 
        }


        while(resultados.next()) {
            String[] fila = new String[12];
            fila[1] = resultados.getString(1);
            fila[2] = resultados.getString(2);
            fila[3] = resultados.getString(3);
            fila[3] = resultados.getString(4);
            fila[4] = String.valueOf(resultados.getString(5));
            fila[5] = String.valueOf(resultados.getString(6));
            fila[6] = String.valueOf(resultados.getString(7));
            fila[7] = String.valueOf(resultados.getString(8));
            fila[8] = String.valueOf(resultados.getString(9));
            fila[9] = String.valueOf(resultados.getString(10));
            fila[10] = String.valueOf(resultados.getString(11));
            fila[11] = String.valueOf(resultados.getString(12));
            arrayListBidimensional.add(fila);
            for (String a : fila) {
                System.out.println(a);
            }
        }

        // result.close();
        // stmt.close();

        return arrayListBidimensional;
    }
    

    public void crearPersonaje(Connection c, String nombre, String sexo, String raza, String clase, int miembro_id)  {
        // insert tipo crear personaje --> INSERT INTO personajes (nombre, raza, clase, miembro_id) VALUES ('Gimli', 'Enano', 'Guerrero', 1);
        // INSERT INTO personajes (nombre, sexo, raza, clase, miembro_id) VALUES 

		String query = "INSERT INTO personajes (nombre, sexo, raza, clase, miembro_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConexion(); PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, sexo);
            pstmt.setString(3, raza);
            pstmt.setString(4, clase);
            pstmt.setInt(5, miembro_id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage()); 
        }
    }

    public void crearPartida(Connection c, String nombre, int gameMasterId, String ambientacion) {
        // INSERT INTO partidas (nombre, game_master_id, ambientacion, esta_en_curso, num_sesion, duración, fecha) VALUES ('La batalla por el templo del Tigre Blanco', 1, 'Estepas de Tong Long', false, 7, 315, '2023-08-02');
        
        String query = "INSERT INTO partidas (nombre, game_master_id, ambientacion, esta_en_curso, num_sesion, duración, fecha) VALUES (?, ?, ?, false, 0, 0,  datetime('now','localtime'));";

        try (Connection con = getConexion(); PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2, gameMasterId);
            pstmt.setString(3, ambientacion);
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
