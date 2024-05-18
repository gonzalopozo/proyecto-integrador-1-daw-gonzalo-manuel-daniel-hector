package model;

import java.net.ConnectException;
import java.sql.*;  
import org.sqlite.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

import main.*;
import views.PaginaPrincipal;

public class AccesoBD {

    private String url = "jdbc:sqlite:database/database.db";


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

    public ArrayList<String[]> hacerConsultaTablaCuenta(Connection c) throws SQLException {
        ArrayList<String[]> arrayListBidimensional = new ArrayList<>();
    
        String query = "SELECT id, nombre, raza, clase FROM personajes WHERE miembro_id = ?";
        String query2 = "SELECT nivel, partida_id, salud, fuerza, destreza, sabiduria, carisma, inteligencia, constitucion FROM juega WHERE personaje_id = ?";
        String query3 = "SELECT nombre FROM partidas WHERE id = ?";
    
        ResultSet resultados = null;
        ResultSet resultados2 = null;
        ResultSet resultados3 = null;
    
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
    
        try {
            Connection con = getConexion();
            pstmt1 = con.prepareStatement(query);
            pstmt1.setInt(1, App.getMiembroActualId());
            resultados = pstmt1.executeQuery();
    
            while (resultados.next()) {
                int personajeId = resultados.getInt("id");
    
                try {
                    pstmt2 = con.prepareStatement(query2);
                    pstmt2.setInt(1, personajeId);
                    resultados2 = pstmt2.executeQuery();
    
                    while (resultados2.next()) {
                        String[] fila = new String[12];  // Crear una nueva instancia de fila para cada partida
    
                        fila[0] = resultados.getString("nombre");
                        fila[1] = resultados.getString("raza");
                        fila[2] = resultados.getString("clase");
    
                        int partidaId = resultados2.getInt("partida_id");
    
                        fila[4] = String.valueOf(resultados2.getInt("nivel"));
                        fila[5] = String.valueOf(resultados2.getInt("salud"));
                        fila[6] = String.valueOf(resultados2.getInt("fuerza"));
                        fila[7] = String.valueOf(resultados2.getInt("destreza"));
                        fila[8] = String.valueOf(resultados2.getInt("sabiduria"));
                        fila[9] = String.valueOf(resultados2.getInt("carisma"));
                        fila[10] = String.valueOf(resultados2.getInt("inteligencia"));
                        fila[11] = String.valueOf(resultados2.getInt("constitucion"));
    
                        try {
                            pstmt3 = con.prepareStatement(query3);
                            pstmt3.setInt(1, partidaId);
                            resultados3 = pstmt3.executeQuery();
    
                            if (resultados3.next()) {
                                fila[3] = resultados3.getString("nombre");
                            }
    
                        } finally {
                            if (resultados3 != null) {
                                resultados3.close();
                            }
                            if (pstmt3 != null) {
                                pstmt3.close();
                            }
                        }
    
                        arrayListBidimensional.add(fila);
                    }
    
                } finally {
                    if (resultados2 != null) {
                        resultados2.close();
                    }
                    if (pstmt2 != null) {
                        pstmt2.close();
                    }
                }
            }
    
        } finally {
            if (resultados != null) {
                resultados.close();
            }
            if (pstmt1 != null) {
                pstmt1.close();
            }
        }
    
        return arrayListBidimensional;
    }

    // public ArrayList<String[]> hacerConsultaTablaDetallesPartida(Connection c, String nombrePartida, String ambientacionPartida) throws SQLException {
    //     ArrayList<String[]> arrayListBidimensional = new ArrayList<>();
    
    //     String query = "SELECT personaje_id, nivel, salud, fuerza, destreza, sabiduria, carisma, inteligencia, constitucion FROM juega WHERE nombre = ? AND ambientacion = ?";
    //     String query2 = "SELECT nombre, raza, clase FROM personajes WHERE personaje_id = ?";
    
    //     ResultSet resultados = null;
    //     ResultSet resultados2 = null;
    
    //     PreparedStatement pstmt1 = null;
    //     PreparedStatement pstmt2 = null;
    
    //     try {
    //         Connection con = getConexion();
    //         pstmt1 = con.prepareStatement(query);
    //         pstmt1.setString(1, nombrePartida);
    //         pstmt1.setString(2, ambientacionPartida);
    //         resultados = pstmt1.executeQuery();
    
    //         while (resultados.next()) {
    //             int personajeId = resultados.getInt("personaje_id");
    
    //             try {
    //                 pstmt2 = con.prepareStatement(query2);
    //                 pstmt2.setInt(1, personajeId);
    //                 resultados2 = pstmt2.executeQuery();
    
    //                 while (resultados2.next()) {
    //                     String[] fila = new String[11];  // Crear una nueva instancia de fila para cada partida
    
    //                     fila[0] = resultados2.getString("nombre");
    //                     fila[1] = resultados2.getString("raza");
    //                     fila[2] = resultados2.getString("clase");
    
    //                     // int personajeId = resultados2.getInt("personaje_id");
    
    //                     fila[3] = String.valueOf(resultados.getInt("nivel"));
    //                     fila[4] = String.valueOf(resultados.getInt("salud"));
    //                     fila[5] = String.valueOf(resultados.getInt("fuerza"));
    //                     fila[6] = String.valueOf(resultados.getInt("destreza"));
    //                     fila[7] = String.valueOf(resultados.getInt("sabiduria"));
    //                     fila[8] = String.valueOf(resultados.getInt("carisma"));
    //                     fila[9] = String.valueOf(resultados.getInt("inteligencia"));
    //                     fila[10] = String.valueOf(resultados.getInt("constitucion"));
    
    //                     arrayListBidimensional.add(fila);
    //                 }
    
    //             } finally {
    //                 if (resultados2 != null) {
    //                     resultados2.close();
    //                 }
    //                 if (pstmt2 != null) {
    //                     pstmt2.close();
    //                 }
    //             }
    //         }
    
    //     } finally {
    //         if (resultados != null) {
    //             resultados.close();
    //         }
    //         if (pstmt1 != null) {
    //             pstmt1.close();
    //         }
    //     }
    
    //     return arrayListBidimensional;
    // }

    public ArrayList<String[]> hacerConsultaTablaDetallesPartida(Connection c, String nombrePartida, String ambientacionPartida) throws SQLException {
    ArrayList<String[]> arrayListBidimensional = new ArrayList<>();

    String query = "SELECT id FROM partidas WHERE nombre = ? AND ambientacion = ?";
    String query2 = "SELECT personaje_id, nivel, salud, fuerza, destreza, sabiduria, carisma, inteligencia, constitucion FROM juega WHERE partida_id = ?";
    String query3 = "SELECT nombre, raza, clase FROM personajes WHERE id = ?";

    try (PreparedStatement pstmt1 = c.prepareStatement(query)) {
        pstmt1.setString(1, nombrePartida);
        pstmt1.setString(2, ambientacionPartida);
        
        try (ResultSet resultados = pstmt1.executeQuery()) {
            while (resultados.next()) {
                int partidaId = resultados.getInt("id");
                
                try (PreparedStatement pstmt2 = c.prepareStatement(query2)) {
                    pstmt2.setInt(1, partidaId);
                    
                    try (ResultSet resultados2 = pstmt2.executeQuery()) {
                        while (resultados2.next()) {
                            int personajeId = resultados2.getInt("personaje_id");
                            String[] fila = new String[11];



                            // fila[0] = resultados2.getString("nombre");
                            // fila[1] = resultados2.getString("raza");
                            // fila[2] = resultados2.getString("clase");
                            fila[3] = String.valueOf(resultados2.getInt("nivel"));
                            fila[4] = String.valueOf(resultados2.getInt("salud"));
                            fila[5] = String.valueOf(resultados2.getInt("fuerza"));
                            fila[6] = String.valueOf(resultados2.getInt("destreza"));
                            fila[7] = String.valueOf(resultados2.getInt("sabiduria"));
                            fila[8] = String.valueOf(resultados2.getInt("carisma"));
                            fila[9] = String.valueOf(resultados2.getInt("inteligencia"));
                            fila[10] = String.valueOf(resultados2.getInt("constitucion"));

                            try (PreparedStatement pstmt3 = c.prepareStatement(query3)) {
                                pstmt3.setInt(1, personajeId);
                                try (ResultSet resultados3 = pstmt3.executeQuery()) {
                                    if (resultados3.next()) {
                                        fila[0] = resultados3.getString("nombre");
                                        fila[1] = resultados3.getString("raza");
                                        fila[2] = resultados3.getString("clase");

                                    }
                                } 
                            } 
                            
                            arrayListBidimensional.add(fila);
                        }
                    }
                }
            }
        }
    }

    return arrayListBidimensional;
}

    

    // public ArrayList<String[]> hacerConsultaTablaPartidas(Connection c, int personaje_id) throws SQLException{
    //     ArrayList<String[]> arrayListBidimensional = new ArrayList<>();

    //     String query = "SELECT id, nombre, ambientacion FROM partidas";

    //     String query2 = "SELECT AVG(nivel) FROM juega WHERE partida_id = ?";

    //     String query3 = "SELECT * FROM juega WHERE personaje_id = ? AND partida_id = ?";

    //     ResultSet resultados = null;
    //     ResultSet resultados2 = null;
    //     ResultSet resultados3 = null;

    //     try {
            
    //         Connection con = getConexion();
    //         PreparedStatement pstmt = con.prepareStatement(query);

    //         resultados = pstmt.executeQuery();

    //         pstmt.close();
    //     } catch (SQLException e) {
    //         System.err.println(e.getMessage()); 
    //     }

    //     while(resultados.next()) {
    //         System.out.println("RESULTADOS1 - WHILE");


    //         int partidaId = resultados.getInt("id");

    //         String[] fila = new String[4];
            
    //         fila[1] = resultados.getString("nombre");
    //         fila[2] = resultados.getString("ambientacion");
            
    //         try {
    //             Connection con = getConexion(); 
    //             PreparedStatement pstmt = con.prepareStatement(query2);
                
    //             pstmt.setInt(1, partidaId);
    
    //             resultados2 = pstmt.executeQuery();

    //             pstmt.close();
    
    //         } catch (SQLException e) {
    //             System.err.println(e.getMessage()); 
    //         }

    //         fila[3] = String.valueOf(resultados2.getInt(1));

    //         try {
    //             Connection con = getConexion(); 
    //             PreparedStatement pstmt = con.prepareStatement(query3);
                
    //             pstmt.setInt(1, personaje_id);
    //             pstmt.setInt(2, partidaId);
    
    //             resultados3 = pstmt.executeQuery();

    //             pstmt.close();
    
    //         } catch (SQLException e) {
    //             System.err.println(e.getMessage()); 
    //         }

    //         if (resultados3.next()) {
    //             fila[0] = "✔";
    //         } else {
    //             fila[0] = "✘";
    //         }

            

    //         arrayListBidimensional.add(fila);

    //     }

    //     resultados.close();
    //     resultados2.close();
    //     resultados3.close();



    //     // result.close();
    //     // stmt.close();

        

    //     return arrayListBidimensional;
    // }
    

    public ArrayList<String[]> hacerConsultaTablaPartidas(Connection c, int personaje_id) throws SQLException {
        ArrayList<String[]> arrayListBidimensional = new ArrayList<>();
    
        String query = "SELECT id, nombre, ambientacion FROM partidas";
        String query2 = "SELECT AVG(nivel) FROM juega WHERE partida_id = ?";
        String query3 = "SELECT * FROM juega WHERE personaje_id = ? AND partida_id = ?";
    
        try (
            PreparedStatement pstmt1 = c.prepareStatement(query);
            ResultSet resultados = pstmt1.executeQuery()
        ) {
            while (resultados.next()) {
                int partidaId = resultados.getInt("id");
                String[] fila = new String[4];
    
                fila[0] = ""; 
                fila[1] = resultados.getString("nombre");
                fila[2] = resultados.getString("ambientacion");
    
                try (
                    PreparedStatement pstmt2 = c.prepareStatement(query2)
                ) {
                    pstmt2.setInt(1, partidaId);
                    try (ResultSet resultados2 = pstmt2.executeQuery()) {
                        if (resultados2.next()) {
                            fila[3] = String.valueOf(resultados2.getDouble(1)); // Usar getDouble para AVG
                        }
                    }
                }
    
                try (
                    PreparedStatement pstmt3 = c.prepareStatement(query3)
                ) {
                    pstmt3.setInt(1, personaje_id);
                    pstmt3.setInt(2, partidaId);
                    try (ResultSet resultados3 = pstmt3.executeQuery()) {
                        if (resultados3.next()) {
                            fila[0] = "✔";
                        } else {
                            fila[0] = "✘";
                        }
                    }
                }
    
                arrayListBidimensional.add(fila);
            }
        } catch (SQLException e) {
            throw new SQLException("Error ejecutando consultas", e);
        }
    
        return arrayListBidimensional;
    }
    

    public boolean crearPersonaje(Connection c, String nombre, String sexo, String raza, String clase, int miembro_id)  {
        // insert tipo crear personaje --> INSERT INTO personajes (nombre, raza, clase, miembro_id) VALUES ('Gimli', 'Enano', 'Guerrero', 1);
        // INSERT INTO personajes (nombre, sexo, raza, clase, miembro_id) VALUES 

        boolean value = false;

        String queryComprobacion = "SELECT id FROM personajes WHERE nombre = ? AND miembro_id = ?";

		String query = "INSERT INTO personajes (nombre, sexo, raza, clase, miembro_id) VALUES (?, ?, ?, ?, ?)";
        


        try (PreparedStatement pstmt = c.prepareStatement(queryComprobacion)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2, miembro_id);

            ResultSet resultados = pstmt.executeQuery();

            pstmt.close();

            if (!resultados.next()) {
                try (PreparedStatement pstmt2 = c.prepareStatement(query)) {

                    pstmt2.setString(1, nombre);
                    pstmt2.setString(2, sexo);
                    pstmt2.setString(3, raza);
                    pstmt2.setString(4, clase);
                    pstmt2.setInt(5, miembro_id);
        
                    pstmt2.executeUpdate();

                    value = true;
                    pstmt2.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage()); 
                }

                
            } 
            resultados.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }        

        return value;
    }

    public void crearMiembro(Connection c, String nombre, String apellidos, String password, int num_expediente, String estudios)  {
        // insert tipo crear cuenta --> INSERT INTO miembros (nombre, apellidos, password, num_expediente, estudios) VALUES ('Gonzalo', 'Pozo Sánchez', 'lebron', '10001', 'SMIR');

		String query = "INSERT INTO miembros (nombre, apellidos, password, num_expediente, estudios) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = c.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, password);
            pstmt.setInt(4, num_expediente);
            pstmt.setString(5, estudios);
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearPartida(Connection c, String nombre, int gameMasterId, String ambientacion) {
        // INSERT INTO partidas (nombre, game_master_id, ambientacion, esta_en_curso, num_sesion, duración, fecha) VALUES ('La batalla por el templo del Tigre Blanco', 1, 'Estepas de Tong Long', false, 7, 315, '2023-08-02');
        
        String query = "INSERT INTO partidas (nombre, game_master_id, ambientacion, esta_en_curso, num_sesion, duración, fecha) VALUES (?, ?, ?, false, 0, 0,  datetime('now','localtime'));";

        try (PreparedStatement pstmt = c.prepareStatement(query)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2, gameMasterId);
            pstmt.setString(3, ambientacion);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage()); 
        }
    }

    public void unirsePartida(Connection c, int idPersonaje, int idPartida){
        // TODO: IMPLEMENTAR MÉTODO

        String query = "INSERT INTO juega VALUES (1, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = getConexion(); PreparedStatement pstmt = con.prepareStatement(query)){

            pstmt.setInt(1, idPersonaje);
            pstmt.setInt(2, idPartida);

            Random rnd = new Random();

            for (int i = 3; i <= 9; i++) {
                pstmt.setInt(i, rnd.nextInt(100,141));
            }
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // public ArrayList<String> devolverPersonajesMiembro(Connection c) throws SQLException{
    //     ArrayList<String> arrayPersonajesMiembro = new ArrayList<>();

        
    //     String query = "SELECT nombre FROM personajes WHERE miembro_id = ?";
        
    //     System.out.println(query);


    //     ResultSet resultados = null;

    //     try {
            
    //         Connection con = getConexion();
    //         PreparedStatement pstmt = con.prepareStatement(query);

    //         pstmt.setInt(1, App.getMiembroActualId());

    //         resultados = pstmt.executeQuery();
            
    //         pstmt.close();

    //     } catch (SQLException e) {
    //         System.err.println(e.getMessage()); 
    //     }
        
    //     if (resultados == null) {
    //     	System.out.println("ES NULLL");
    //     }
        
    //     while(resultados.next()) {
    //         arrayPersonajesMiembro.add(resultados.getString(1));
    //     	System.out.println(resultados.getString(1) + " calvo");
    //     }

    //     resultados.close();
        
    //     return arrayPersonajesMiembro;
    // }

    public ArrayList<String> devolverPersonajesMiembro(Connection con) throws SQLException {
        ArrayList<String> arrayPersonajesMiembro = new ArrayList<>();
    
        String query = "SELECT nombre FROM personajes WHERE miembro_id = ?";
        System.out.println(query);
    
        ResultSet resultados = null;
        PreparedStatement pstmt = null;
    
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, App.getMiembroActualId());
            resultados = pstmt.executeQuery();
    
            while (resultados.next()) {
                arrayPersonajesMiembro.add(resultados.getString(1));
                System.out.println(resultados.getString(1) + " Talleres Paco");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultados != null) {
                try {
                    resultados.close();
                } catch (SQLException e) {
                    System.err.println("Error closing ResultSet: " + e.getMessage());
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.err.println("Error closing PreparedStatement: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("Error closing Connection: " + e.getMessage());
                }
            }
        }
    
        return arrayPersonajesMiembro;
    }
    

    public ArrayList<String> devolverPartidasNombre(Connection c) throws SQLException{
        ArrayList<String> arrayPartidasNombre = new ArrayList<>();

        
        String query = "SELECT nombre FROM partidas WHERE game_master_id = ?";
        
        System.out.println(query);


        ResultSet resultados = null;

        try {
            
            Connection con = getConexion();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, App.getMiembroActualId());

            resultados = pstmt.executeQuery();
            
            
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage()); 
        }   
                
        while(resultados.next()) {
        	arrayPartidasNombre.add(resultados.getString(1));
        	System.out.println(resultados.getString(1));
        }
        resultados.close();

        return arrayPartidasNombre;
    }

    public Object [] devolverPersonajeSeleccionadoMiembro(Connection c, String nombrePersonaje) throws SQLException{
        Object [] datosPersonajeSeleccionado = new Object[3];

        
        String query = "SELECT id, raza, sexo FROM personajes WHERE nombre = ? AND miembro_id = ?";
        
        System.out.println(query);


        ResultSet resultados = null;

        try {
            
            Connection con = getConexion();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, nombrePersonaje);
            pstmt.setInt(2, App.getMiembroActualId());

            resultados = pstmt.executeQuery();
            
            

            if (resultados.next()) {
                datosPersonajeSeleccionado[0] = (Integer) resultados.getInt(1);
                datosPersonajeSeleccionado[1] = (String) resultados.getString(2);
                datosPersonajeSeleccionado[2] = (String) resultados.getString(3);
            }

            pstmt.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage()); 
        }

        

        

        resultados.close();
        return datosPersonajeSeleccionado;
    }

    public int devolverIdMiembro(Connection c, String nombreMiembro) throws SQLException{
        int miembroId = 0;

        String query = "SELECT id FROM miembros WHERE nombre = ? ";
        
        ResultSet resultados = null;

        try {
            
            Connection con = getConexion();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, nombreMiembro);

            resultados = pstmt.executeQuery();

            pstmt.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage()); 
        }

        while (resultados.next()) {
            miembroId = resultados.getInt("id");
        }

        resultados.close();
        
        return miembroId;
        
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

    // TODO Metodo BORRAR PERSONAJE
    public void borrarPersonaje(Connection c, String nombrePersonaje, int personajeId){
        String query = "DELETE FROM personajes WHERE nombre = ? AND miembro_id = ?"; // ! La wea que borra personaje
        String query2 = "DELETE FROM juega WHERE personaje_id = ?";
        System.out.println(query);
        try (PreparedStatement ps = c.prepareStatement(query)){
            ps.setString(1, nombrePersonaje); // ! Nombre del personaje
            ps.setInt(2, App.getMiembroActualId()); 
            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Borrado exitoso en personajes");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }

        try (PreparedStatement ps = c.prepareStatement(query2)){
            ps.setInt(1, personajeId); 
            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Borrado exitoso en juega");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }



}

