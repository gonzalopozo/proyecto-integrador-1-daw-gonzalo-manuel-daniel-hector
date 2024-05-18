package model;

import java.net.ConnectException;
import java.sql.*;  
import org.sqlite.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

import main.*;

public class AccesoBD {

    private String url = "jdbc:sqlite:C:\\Users\\Manu\\Desktop\\proyecto\\proyecto-integrador-1-daw-gonzalo-manuel-daniel-hector\\database\\database.db";


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
        String query = "SELECT * FROM PERSONAJES where miembro_id="+App.getMiembroActualId();

        Statement stmt = c.createStatement();

        ResultSet result = stmt.executeQuery(query);

        while(result.next()) {
            System.out.println("-------------------------------");
            System.out.print(result.getInt(1) + " - ");
            System.out.print(result.getString(2));
            System.out.println();
        }

        result.close();
        stmt.close();
    }

    
    public ArrayList<String[]> hacerConsultaTablaCuenta(Connection c) throws SQLException{
        ArrayList<String[]> arrayListBidimensional = new ArrayList<>();

        //String query = "SELECT p.nombre AS Nombre, p.raza AS Raza, p.clase AS Clase, j.partida_id AS Partida, j.nivel AS Nivel, j.salud AS Salud, j.fuerza AS Fuerza, j.destreza AS Destreza, j.sabiduria AS Sabiduría, j.carisma AS Carisma, j.inteligencia AS Inteligencia, j.constitucion AS Constitución FROM personajes p JOIN juega j ON p.id = j.personaje_id JOIN partidas pa ON j.partida_id = pa.id JOIN miembros m ON p.miembro_id = m.id WHERE m.id = ? AND pa.esta_en_curso = 1;";
        String query = "SELECT id, nombre, raza, clase FROM personajes WHERE miembro_id = ?";

        String query2 = "SELECT nivel, partida_id, salud, fuerza, destreza, sabiduria, carisma, inteligencia, constitucion FROM juega WHERE personaje_id = ?";

        String query3 = "SELECT nombre FROM partidas WHERE id = ?";

        /*
         * 
         * model.addColumn("Nombre");
        model.addColumn("Raza");
        model.addColumn("Clase");
        model.addColumn("Partida");
        model.addColumn("Nivel");
        model.addColumn("Salud");
        model.addColumn("Fuerza");
        model.addColumn("Destreza");
        model.addColumn("Sabiduría");
        model.addColumn("Carisma");
        model.addColumn("Inteligencia");
        model.addColumn("Constitución");
         * 
         */

        // System.out.println(App.getMiembroActualId());

        ResultSet resultados = null;
        ResultSet resultados2 = null;
        ResultSet resultados3 = null;



        try {
            
            Connection con = getConexion();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, App.getMiembroActualId());

            resultados = pstmt.executeQuery();

        } catch (SQLException e) {
            System.err.println(e.getMessage()); 
        }



        // while (resultados.next()) {

        //     int personaje_id;

        //     try (Connection con = getConexion(); PreparedStatement pstmt = con.prepareStatement(query2);) {
        //         pstmt.setInt(1, App.getMiembroActualId());
    
        //         resultados2 = pstmt.executeQuery();
    
        //     } catch (SQLException e) {
        //         System.err.println(e.getMessage()); 
        //     }
        // }

        // try {
        //     Connection con = getConexion(); 
        //     PreparedStatement pstmt = con.prepareStatement(query3);
        //     pstmt.setInt(1, App.getMiembroActualId());

        //     resultados3 = pstmt.executeQuery();

        // } catch (SQLException e) {
        //     System.err.println(e.getMessage()); 
        // }

        while(resultados.next()) {
            System.out.println("RESULTADOS1 - WHILE");


            int personajeId = resultados.getInt("id");

            String[] fila = new String[12];
            
            fila[0] = resultados.getString("nombre");
            fila[1] = resultados.getString("raza");
            fila[2] = resultados.getString("clase");
            
            try {
                Connection con = getConexion(); 
                PreparedStatement pstmt = con.prepareStatement(query2);
                
                pstmt.setInt(1, personajeId);
    
                resultados2 = pstmt.executeQuery();
    
            } catch (SQLException e) {
                System.err.println(e.getMessage()); 
            }

            // String query2 = "SELECT nivel, partida_id, salud, fuerza, destreza, sabiduria, carisma, inteligencia, constitucion FROM juega WHERE personaje_id = ?";



            while (resultados2.next()) {
                System.out.println("RESULTADOS2 - WHILE");

                int partidaId = resultados2.getInt(2);
                System.out.println("\n - " + partidaId +  "- \n");
                
                fila[4] = String.valueOf(resultados2.getString(1));
                fila[5] = String.valueOf(resultados2.getString(3));
                fila[6] = String.valueOf(resultados2.getString(4));
                fila[7] = String.valueOf(resultados2.getString(5));
                fila[8] = String.valueOf(resultados2.getString(6));
                fila[9] = String.valueOf(resultados2.getString(7));
                fila[10] = String.valueOf(resultados2.getString(8));
                fila[11] = String.valueOf(resultados2.getString(9));

                try {
                    Connection con = getConexion(); 
                    PreparedStatement pstmt = con.prepareStatement(query3);
                    
                    pstmt.setInt(1, partidaId);
        
                    resultados3 = pstmt.executeQuery();

                    fila[3] = resultados3.getString("nombre");

        
                } catch (SQLException e) {
                    System.err.println(e.getMessage()); 
                }


                for (String valor : fila) {
                    System.out.println(valor);
                }

                arrayListBidimensional.add(fila);

            }


            
            // System.out.println("-->"+fila);
            // for (String a : fila) {
            //     System.out.println(a);
            // }
        }

        



        // result.close();
        // stmt.close();

        for (String [] fila : arrayListBidimensional) {
            System.out.println("----------------");
            for (String a : fila) {
                System.err.println(a);
            }
            System.out.println("----------------");
        }

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

    public void crearMiembro(Connection c, String nombre, String apellidos, String password, int num_expediente, String estudios)  {
        // insert tipo crear cuenta --> INSERT INTO miembros (nombre, apellidos, password, num_expediente, estudios) VALUES ('Gonzalo', 'Pozo Sánchez', 'lebron', '10001', 'SMIR');

		String query = "INSERT INTO miembros (nombre, apellidos, password, num_expediente, estudios) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConexion(); PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, password);
            pstmt.setInt(4, num_expediente);
            pstmt.setString(5, estudios);
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
    

    public ArrayList<String> devolverPersonajesMiembro(Connection c) throws SQLException{
        ArrayList<String> arrayPersonajesMiembro = new ArrayList<>();

        
        String query = "SELECT nombre FROM personajes WHERE miembro_id = ?";
        
        System.out.println(query);


        ResultSet resultados = null;

        try {
            
            Connection con = getConexion();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, App.getMiembroActualId());

            resultados = pstmt.executeQuery();
            
            

        } catch (SQLException e) {
            System.err.println(e.getMessage()); 
        }
        
        if (resultados == null) {
        	System.out.println("ES NULLL");
        }
        
        while(resultados.next()) {
        	arrayPersonajesMiembro.add(resultados.getString(1));
        	System.out.println(resultados.getString(1));
        }

        return arrayPersonajesMiembro;
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

