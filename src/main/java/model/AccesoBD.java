package model;

import java.net.ConnectException;
import java.sql.*;
import org.sqlite.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

import main.*;
import views.PaginaPrincipal;

/**
 * Clase que se encarga de gestionar la conexión con la base de datos y de realizar las consultas necesarias para la aplicación.
 */
public class AccesoBD {

    private String url = "jdbc:sqlite:database/database.db";

    
    // private String url =
    // "jdbc:sqlite:C:\\Users\\gonza\\OneDrive\\Escritorio\\pro-intega\\proyecto-integrador-1-daw-gonzalo-manuel-daniel-hector\\database\\database.db";

    /**
     * Método que se encarga de establecer la conexión con la base de datos.
     */
    public Connection getConexion() { 
        Connection con = null; // Inicializamos la conexión a null

        try {
            con = DriverManager.getConnection(url); // Establecemos la conexión con la base de datos

            System.out.println("Conexión a la base de datos establecida.");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la BD: ");
            e.printStackTrace();
        }

        return con;
    }
    
    /**
     * Método que se encarga de cerrar la conexión con la base de datos una vez que ya no se necesite.
     */
    public void cerrarConexion(Connection con) {
        try {
            if (con != null) { // Si la conexión no es nula
                con.close(); // Cerramos la conexión
            }
            System.out.println("Conexión cerrada."); // Mostramos un mensaje por consola
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    /**
     * Método que se encarga de comprobar si el login introducido por el usuario es correcto.
     * @param c Conexión con la base de datos.
     * @param login Nombre de usuario introducido por el usuario.
     * @return Array de objetos con el id y la contraseña del usuario.
     */
    public Object[] comprobarLogin(Connection c, String login) throws SQLException {

        Object resultado[] = new Object[2]; // Creamos un array de objetos con dos posiciones
        String query = "SELECT id, password FROM miembros WHERE nombre = '" + login + "'"; // Consulta para obtener el id y la contraseña del usuario
        Statement stmt = c.createStatement(); // Creamos un objeto de tipo Statement

        ResultSet resultSet = stmt.executeQuery(query);

        while (resultSet.next()) { // Mientras haya resultados en el ResultSet
            resultado[0] = resultSet.getInt("id"); // Guardamos el id del usuario en la primera posición del array
            resultado[1] = resultSet.getString("password"); // Guardamos la contraseña del usuario en la segunda posición del array
        }

        resultSet.close();
        stmt.close();

        return resultado;
    }

    /**
     * Método que se encarga de obtener los datos de un usuario.
     * @param c Conexión con la base de datos.
     * @param id Id del usuario.
     * @return Array de objetos con los datos del usuario.
     */
    public void obtenerDatos(Connection c) throws SQLException {
        String query = "SELECT * FROM PERSONAJES where miembro_id=" + App.getMiembroActualId();

        Statement stmt = c.createStatement();

        ResultSet result = stmt.executeQuery(query);

        while (result.next()) { // Mientras haya resultados en el ResultSet
            System.out.println("-------------------------------");
            System.out.print(result.getInt(1) + " - "); // Imprimimos el id del usuario
            System.out.print(result.getString(2)); // Imprimimos el nombre del usuario
            System.out.println();
        }

        result.close();
        stmt.close();
    }

    /**
     * Método que se encarga de obtener los datos de un usuario.
     * @param c Conexión con la base de datos.
     * @param id Id del usuario.
     * @return Array de objetos con los datos del usuario.
     */
    public ArrayList<String[]> hacerConsultaTablaCuenta(Connection c) throws SQLException {
        ArrayList<String[]> arrayListBidimensional = new ArrayList<>(); // Creamos un ArrayList bidimensional

        String query = "SELECT id, nombre, raza, clase FROM personajes WHERE miembro_id = ?";
        String query2 = "SELECT nivel, partida_id, salud, fuerza, destreza, sabiduria, carisma, inteligencia, constitucion "
                +
                "FROM juega j1 " +
                "WHERE personaje_id = ? AND nivel = ( " +
                "    SELECT MAX(nivel) " +
                "    FROM juega j2 " +
                "    WHERE j1.personaje_id = j2.personaje_id AND j1.partida_id = j2.partida_id " +
                ")";
        String query3 = "SELECT nombre FROM partidas WHERE id = ?";

        ResultSet resultados = null; // Inicializamos el ResultSet a null
        ResultSet resultados2 = null;
        ResultSet resultados3 = null;

        PreparedStatement pstmt1 = null; // Inicializamos el PreparedStatement a null
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;

        try {
            Connection con = getConexion(); // Establecemos la conexión con la base de datos
            pstmt1 = con.prepareStatement(query); // Creamos un objeto de tipo PreparedStatement con la consulta
            pstmt1.setInt(1, App.getMiembroActualId()); // Establecemos el id del usuario en la consulta
            resultados = pstmt1.executeQuery();

            while (resultados.next()) { // Mientras haya resultados en el ResultSet
                int personajeId = resultados.getInt("id"); // Guardamos el id del personaje en una variable

                try {
                    pstmt2 = con.prepareStatement(query2); // Creamos un objeto de tipo PreparedStatement con la consulta
                    pstmt2.setInt(1, personajeId);
                    resultados2 = pstmt2.executeQuery();

                    while (resultados2.next()) { // Mientras haya resultados en el ResultSet
                        String[] fila = new String[12]; // Crear una nueva instancia de fila para cada partida

                        fila[0] = resultados.getString("nombre"); // Guardamos el nombre del personaje en la primera posición de la fila
                        fila[1] = resultados.getString("raza"); // Guardamos la raza del personaje en la segunda posición de la fila
                        fila[2] = resultados.getString("clase"); // Guardamos la clase del personaje en la tercera posición de la fila

                        int partidaId = resultados2.getInt("partida_id"); // Guardamos el id de la partida en una variable

                        fila[4] = String.valueOf(resultados2.getInt("nivel")); // Guardamos el nivel del personaje en la cuarta posición de la fila
                        fila[5] = String.valueOf(resultados2.getInt("salud")); // Guardamos la salud del personaje en la quinta posición de la fila
                        fila[6] = String.valueOf(resultados2.getInt("fuerza")); // Guardamos la fuerza del personaje en la sexta posición de la fila
                        fila[7] = String.valueOf(resultados2.getInt("destreza")); // Guardamos la destreza del personaje en la séptima posición de la fila
                        fila[8] = String.valueOf(resultados2.getInt("sabiduria")); // Guardamos la sabiduría del personaje en la octava posición de la fila
                        fila[9] = String.valueOf(resultados2.getInt("carisma")); // Guardamos el carisma del personaje en la novena posición de la fila
                        fila[10] = String.valueOf(resultados2.getInt("inteligencia")); // Guardamos la inteligencia del personaje en la décima posición de la fila
                        fila[11] = String.valueOf(resultados2.getInt("constitucion")); // Guardamos la constitución del personaje en la undécima posición de la fila

                        try {
                            pstmt3 = con.prepareStatement(query3); // Creamos un objeto de tipo PreparedStatement con la consulta
                            pstmt3.setInt(1, partidaId); // Establecemos el id de la partida en la consulta
                            resultados3 = pstmt3.executeQuery(); // Ejecutamos la consulta

                            if (resultados3.next()) { // Si hay resultados en el ResultSet
                                String nombrePartida = resultados3.getString("nombre"); // Guardamos el nombre de la partida en una variable
                                if (nombrePartida != null && !nombrePartida.trim().isEmpty()) { // Si el nombre de la partida no es nulo ni está vacío
                                    fila[3] = nombrePartida; // Guardamos el nombre de la partida en la tercera posición de la fila
                                    arrayListBidimensional.add(fila); // Añadimos la fila al ArrayList bidimensional
                                }
                            }

                        } finally {
                            if (resultados3 != null) { // Si hay resultados en el ResultSet
                                resultados3.close(); // Cerramos el ResultSet
                            }
                            if (pstmt3 != null) { // Si el PreparedStatement no es nulo
                                pstmt3.close(); // Cerramos el PreparedStatement
                            }
                        }
                    }

                } finally {
                    if (resultados2 != null) { // Si hay resultados en el ResultSet
                        resultados2.close(); // Cerramos el ResultSet
                    }
                    if (pstmt2 != null) { // Si el PreparedStatement no es nulo
                        pstmt2.close(); // Cerramos el PreparedStatement
                    }
                }
            }

        } finally { // Finalmente
            if (resultados != null) { // Si hay resultados en el ResultSet
                resultados.close(); // Cerramos el ResultSet
            }
            if (pstmt1 != null) { // Si el PreparedStatement no es nulo
                pstmt1.close(); // Cerramos el PreparedStatement
            }
        }

        return arrayListBidimensional; // Devolvemos el ArrayList bidimensional
    }

    /**
     * Método para hacer una consulta a la base de datos y obtener los niveles de un personaje en concreto.
     * @param c Conexión con la base de datos.
     * @param personajeId Id del personaje.
     * @return Array de objetos con los datos del usuario.
     */
    public ArrayList<String[]> hacerConsultaNivelesPersonaje(Connection c, int personajeId, int partidaId) 
            throws SQLException { // Método que lanza una excepción de tipo SQLException
        ArrayList<String[]> arrayListBidimensional = new ArrayList<>();

        String query = "SELECT nivel, salud, fuerza, destreza, sabiduria, carisma, inteligencia, constitucion FROM juega WHERE personaje_id = ? AND partida_id = ?";

        ResultSet resultados = null;

        PreparedStatement pstmt1 = null;

        try {
            pstmt1 = c.prepareStatement(query);
            pstmt1.setInt(1, personajeId);
            pstmt1.setInt(2, partidaId);
            resultados = pstmt1.executeQuery();

            while (resultados.next()) { // Mientras haya resultados en el ResultSet
                String[] fila = new String[8]; // Crear una nueva instancia de fila para cada partida

                fila[0] = String.valueOf(resultados.getString("nivel")); // Guardamos el nivel del personaje en la primera posición de la fila
                fila[1] = String.valueOf(resultados.getString("salud")); // Guardamos la salud del personaje en la segunda posición de la fila
                fila[2] = String.valueOf(resultados.getString("fuerza")); // Guardamos la fuerza del personaje en la tercera posición de la fila
                fila[3] = String.valueOf(resultados.getString("destreza")); // Guardamos la destreza del personaje en la cuarta posición de la fila
                fila[4] = String.valueOf(resultados.getString("sabiduria")); // Guardamos la sabiduría del personaje en la quinta posición de la fila
                fila[5] = String.valueOf(resultados.getString("carisma")); // Guardamos el carisma del personaje en la sexta posición de la fila
                fila[6] = String.valueOf(resultados.getString("inteligencia")); // Guardamos la inteligencia del personaje en la séptima posición de la fila
                fila[7] = String.valueOf(resultados.getString("constitucion")); // Guardamos la constitución del personaje en la octava posición de la fila

                arrayListBidimensional.add(fila);
            }
        } finally { 
            if (resultados != null) { // Si hay resultados en el ResultSet
                resultados.close(); // Cerramos el ResultSet
            }
            if (pstmt1 != null) { // Si el PreparedStatement no es nulo
                pstmt1.close(); // Cerramos el PreparedStatement
            }
        }

        return arrayListBidimensional; // Devolvemos el ArrayList bidimensional
    }

    /**
     * Método para hacer una consulta a la base de datos y obtener los detalles de una partida en concreto.
     * @param c Conexión con la base de datos.
     * @param nombrePartida Nombre de la partida.
     * @param ambientacionPartida Ambientación de la partida.
     * @return Array de objetos con los datos de la partida.
     */
    public ArrayList<String[]> hacerConsultaTablaDetallesPartida(Connection c, String nombrePartida,
            String ambientacionPartida) throws SQLException {
        ArrayList<String[]> arrayListBidimensional = new ArrayList<>(); // Creamos un ArrayList bidimensional

        String query = "SELECT id FROM partidas WHERE nombre = ? AND ambientacion = ?"; 
        String query2 = "SELECT personaje_id, nivel, salud, fuerza, destreza, sabiduria, carisma, inteligencia, constitucion FROM juega j1 WHERE partida_id = ? AND nivel = (SELECT MAX(nivel) from juega j2 WHERE j1.personaje_id = j2.personaje_id AND j1.partida_id = j2.partida_id)";
        String query3 = "SELECT nombre, raza, clase FROM personajes WHERE id = ?";

        try (PreparedStatement pstmt1 = c.prepareStatement(query)) { // Creamos un objeto de tipo PreparedStatement con la consulta
            pstmt1.setString(1, nombrePartida); // Establecemos el nombre de la partida en la consulta
            pstmt1.setString(2, ambientacionPartida); // Establecemos la ambientación de la partida en la consulta

            try (ResultSet resultados = pstmt1.executeQuery()) { 
                while (resultados.next()) { // Mientras haya resultados en el ResultSet
                    int partidaId = resultados.getInt("id"); // Guardamos el id de la partida en una variable

                    try (PreparedStatement pstmt2 = c.prepareStatement(query2)) {
                        pstmt2.setInt(1, partidaId);

                        try (ResultSet resultados2 = pstmt2.executeQuery()) {
                            while (resultados2.next()) { // Mientras haya resultados en el ResultSet
                                int personajeId = resultados2.getInt("personaje_id"); // Guardamos el id del personaje en una variable
                                String[] fila = new String[11]; // Crear una nueva instancia de fila para cada partida

                                // fila[0] = resultados2.getString("nombre");
                                // fila[1] = resultados2.getString("raza");
                                // fila[2] = resultados2.getString("clase");
                                fila[3] = String.valueOf(resultados2.getInt("nivel")); // Guardamos el nivel del personaje en la cuarta posición de la fila
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
                                        if (resultados3.next()) { // Si hay resultados en el ResultSet
                                            fila[0] = resultados3.getString("nombre"); // Guardamos el nombre del personaje en la primera posición de la fila
                                            fila[1] = resultados3.getString("raza"); // Guardamos la raza del personaje en la segunda posición de la fila
                                            fila[2] = resultados3.getString("clase"); // Guardamos la clase del personaje en la tercera posición de la fila

                                        }
                                    }
                                }

                                arrayListBidimensional.add(fila); // Añadimos la fila al ArrayList bidimensional
                            }
                        }
                    }
                }
            }
        }

        return arrayListBidimensional;
    }

    /**
     * Método para hacer una consulta a la base de datos y obtener los detalles de una partida en concreto.
     * @param c Conexión con la base de datos.
     * @param personaje_id Id del personaje.
     * @return Array de objetos con los datos de la partida.
     */

    public ArrayList<String[]> hacerConsultaTablaPartidas(Connection c, int personaje_id) throws SQLException {
        ArrayList<String[]> arrayListBidimensional = new ArrayList<>(); // Creamos un ArrayList bidimensional

        String query = "SELECT id, nombre, ambientacion FROM partidas";
        String query2 = "SELECT AVG(nivel) FROM juega WHERE partida_id = ?";
        String query3 = "SELECT * FROM juega WHERE personaje_id = ? AND partida_id = ?";

        try (
                PreparedStatement pstmt1 = c.prepareStatement(query);
                ResultSet resultados = pstmt1.executeQuery()) {
            while (resultados.next()) { // Mientras haya resultados en el ResultSet
                int partidaId = resultados.getInt("id"); // Guardamos el id de la partida en una variable
                String[] fila = new String[4]; // Crear una nueva instancia de fila para cada partida

                fila[0] = ""; // Inicializamos la primera posición de la fila
                fila[1] = resultados.getString("nombre"); // Guardamos el nombre de la partida en la segunda posición de la fila
                fila[2] = resultados.getString("ambientacion"); // Guardamos la ambientación de la partida en la tercera posición de la fila

                try (
                        PreparedStatement pstmt2 = c.prepareStatement(query2)) {
                    pstmt2.setInt(1, partidaId);
                    try (ResultSet resultados2 = pstmt2.executeQuery()) {
                        if (resultados2.next()) { // Si hay resultados en el ResultSet
                            fila[3] = String.valueOf(resultados2.getDouble(1)); // Usar getDouble para AVG
                        }
                    }
                }

                try (
                        PreparedStatement pstmt3 = c.prepareStatement(query3)) {
                    pstmt3.setInt(1, personaje_id);
                    pstmt3.setInt(2, partidaId);
                    try (ResultSet resultados3 = pstmt3.executeQuery()) {
                        if (resultados3.next()) { // Si hay resultados en el ResultSet
                            fila[0] = "✔"; // Guardamos un tick en la primera posición de la fila
                        } else {
                            fila[0] = "✘"; // Guardamos una cruz en la primera posición de la fila
                        }
                    }
                }

                arrayListBidimensional.add(fila); // Añadimos la fila al ArrayList bidimensional
            }
        } catch (SQLException e) {
            throw new SQLException("Error ejecutando consultas", e);
        }

        return arrayListBidimensional;
    }

    /**
     * Metodo para crear un personaje en la base de datos con los datos introducidos por el usuario.
     * @param c Conexión con la base de datos.
     * @param nombre Nombre del personaje.
     * @param sexo Sexo del personaje.
     * @param raza Raza del personaje.
     * @param clase Clase del personaje.
     * @param miembro_id Id del usuario.
     * @return Booleano que indica si se ha creado el personaje correctamente.
     * @throws SQLException Excepción de tipo SQLException.
     */
    public boolean crearPersonaje(Connection c, String nombre, String sexo, String raza, String clase, int miembro_id) {
        // insert tipo crear personaje --> INSERT INTO personajes (nombre, raza, clase,
        // miembro_id) VALUES ('Gimli', 'Enano', 'Guerrero', 1);
        // INSERT INTO personajes (nombre, sexo, raza, clase, miembro_id) VALUES

        boolean value = false; // Inicializamos el booleano a false

        String queryComprobacion = "SELECT id FROM personajes WHERE nombre = ? AND miembro_id = ?";

        String query = "INSERT INTO personajes (nombre, sexo, raza, clase, miembro_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = c.prepareStatement(queryComprobacion)) {

            pstmt.setString(1, nombre); // Establecemos el nombre del personaje en la consulta
            pstmt.setInt(2, miembro_id); // Establecemos el id del usuario en la consulta

            ResultSet resultados = pstmt.executeQuery();

            pstmt.close();

            if (!resultados.next()) { // Si no hay resultados en el ResultSet
                try (PreparedStatement pstmt2 = c.prepareStatement(query)) { // Creamos un objeto de tipo PreparedStatement con la consulta

                    pstmt2.setString(1, nombre); // Establecemos el nombre del personaje en la consulta
                    pstmt2.setString(2, sexo); // Establecemos el sexo del personaje en la consulta
                    pstmt2.setString(3, raza); // Establecemos la raza del personaje en la consulta
                    pstmt2.setString(4, clase); // Establecemos la clase del personaje en la consulta
                    pstmt2.setInt(5, miembro_id); // Establecemos el id del usuario en la consulta

                    pstmt2.executeUpdate(); // Ejecutamos la consulta

                    value = true; // Cambiamos el valor del booleano a true
                    pstmt2.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }

            }
            resultados.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return value; // Devolvemos el valor del booleano
    }

    /**
     * Método para crear un miembro en la base de datos con los datos introducidos por el usuario.
     * @param c Conexión con la base de datos.
     * @param nombre Nombre del miembro.
     * @param apellidos Apellidos del miembro.
     * @param password Contraseña del miembro.
     * @param num_expediente Número de expediente del miembro.
     * @param estudios Estudios del miembro.
     * @return Booleano que indica si se ha creado el miembro correctamente.
     * @throws SQLException Excepción de tipo SQLException.
     */
    public void crearMiembro(Connection c, String nombre, String apellidos, String password, int num_expediente,
            String estudios) {
        // insert tipo crear cuenta --> INSERT INTO miembros (nombre, apellidos,
        // password, num_expediente, estudios) VALUES ('Gonzalo', 'Pozo Sánchez',
        // 'lebron', '10001', 'SMIR');

        String query = "INSERT INTO miembros (nombre, apellidos, password, num_expediente, estudios) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = c.prepareStatement(query)) {

            pstmt.setString(1, nombre); // Establecemos el nombre del miembro en la consulta
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

    /**
     * Método para crear una partida en la base de datos con los datos introducidos por el usuario.
     * @param c Conexión con la base de datos.
     * @param nombre Nombre de la partida.
     * @param gameMasterId Id del game master.
     * @param ambientacion Ambientación de la partida.
     * @throws SQLException Excepción de tipo SQLException.
     */
    public void crearPartida(Connection c, String nombre, int gameMasterId, String ambientacion) {
        // INSERT INTO partidas (nombre, game_master_id, ambientacion, esta_en_curso,
        // num_sesion, duración, fecha) VALUES ('La batalla por el templo del Tigre
        // Blanco', 1, 'Estepas de Tong Long', false, 7, 315, '2023-08-02');

        String query = "INSERT INTO partidas (nombre, game_master_id, ambientacion, esta_en_curso, num_sesion, duración, fecha) VALUES (?, ?, ?, false, 0, 0,  datetime('now','localtime'));";

        try (PreparedStatement pstmt = c.prepareStatement(query)) {

            pstmt.setString(1, nombre); // Establecemos el nombre de la partida en la consulta
            pstmt.setInt(2, gameMasterId);
            pstmt.setString(3, ambientacion);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Método para unir un personaje a una partida en la base de datos.
     * @param c Conexión con la base de datos.
     * @param personajeId Id del personaje.
     * @param partidaId Id de la partida.
     * @throws SQLException Excepción de tipo SQLException.
     */
    public void unirsePartida(Connection c, int personajeId, int partidaId) {
        // TODO: IMPLEMENTAR MÉTODO

        // insert tipo --> INSERT INTO juega VALUES (70, 1, 2, 50000, 10000, 1000, 1000,
        // 3000, 1000, 450);

        String query = "INSERT INTO juega VALUES (1, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConexion(); PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, personajeId);
            pstmt.setInt(2, partidaId);

            Random rnd = new Random();

            for (int i = 3; i <= 9; i++) { // Bucle para recorrer las columnas de la tabla
                pstmt.setInt(i, rnd.nextInt(100, 141)); // Establecemos un valor aleatorio entre 100 y 140
            }

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Método iniciar una partida en la base de datos.
     * @param c Conexión con la base de datos.
     * @param partidaId Id de la partida.
     * @throws SQLException Excepción de tipo SQLException.
     */

    public void iniciarPartida(Connection c, int partidaId) throws SQLException {

        String query = "UPDATE partidas SET esta_en_curso = true, num_sesion = num_sesion + 1, duración = duración + 15 WHERE id = ?";

        System.out.println(query); // Mostramos la consulta por consola

        PreparedStatement pstmt = null; // Inicializamos el PreparedStatement a null

        try {
            pstmt = c.prepareStatement(query); // Creamos un objeto de tipo PreparedStatement con la consulta
            pstmt.setInt(1, partidaId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (pstmt != null) { // Si el PreparedStatement no es nulo
                try {
                    pstmt.close(); // Cerramos el PreparedStatement
                } catch (SQLException e) {
                    System.err.println(e.getMessage()); // Mostramos un mensaje de error por consola
                }
            }
        }

    }

    /**
     * Método para editar partida en la base de datos con los datos introducidos por el usuario.
     * @param c Conexión con la base de datos.
     * @param nuevoNombrePartida Nuevo nombre de la partida.
     * @param nuevaAmbientacionPartida Nueva ambientación de la partida.
     * @param partidaId Id de la partida.
     */
    public void editarPartida(Connection c, String nuevoNombrePartida, String nuevaAmbientacionPartida, int partidaId)
            throws SQLException {

        String query = "UPDATE partidas SET nombre = ?, ambientacion = ? WHERE id = ?";

        System.out.println(query); // Mostramos la consulta por consola

        PreparedStatement pstmt = null;

        try { 
            pstmt = c.prepareStatement(query); // Creamos un objeto de tipo PreparedStatement con la consulta
            pstmt.setString(1, nuevoNombrePartida); // Establecemos el nuevo nombre de la partida en la consulta
            pstmt.setString(2, nuevaAmbientacionPartida); // Establecemos la nueva ambientación de la partida en la consulta
            pstmt.setInt(3, partidaId);

            pstmt.executeUpdate(); // Ejecutamos la consulta

        } catch (SQLException e) { // Capturamos la excepción de tipo SQLException
            System.err.println(e.getMessage());
        } finally { 
            if (pstmt != null) { // Si el PreparedStatement no es nulo
                try {
                    pstmt.close(); // Cerramos el PreparedStatement
                } catch (SQLException e) {
                    System.err.println(e.getMessage()); // Mostramos un mensaje de error por consola
                }
            }
        }

    }

    /**
     * Método para subir de nivel a un personaje en la base de datos 
     * @param c Conexión con la base de datos.
     * @param personajeId Id del personaje.
     * @param partidaId Id de la partida.
     * @throws SQLException Excepción de tipo SQLException.
     */
    public void subirNivelPersonaje(Connection c, int personajeId, int partidaId) throws SQLException {
        // insert tipo --> INSERT INTO juega VALUES (70, 1, 2, 50000, 10000, 1000, 1000,
        // 3000, 1000, 450);

        String querySelect = "SELECT * FROM juega WHERE personaje_id = ? AND partida_id = ? ORDER BY nivel DESC LIMIT 1";
        String queryInsert = "INSERT INTO juega VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        ResultSet resultados = null; // Inicializamos el ResultSet a null
        PreparedStatement pstmt1 = null; // Inicializamos el PreparedStatement a null
        PreparedStatement pstmt2 = null;

        try {

            pstmt1 = c.prepareStatement(querySelect);
            pstmt1.setInt(1, personajeId);
            pstmt1.setInt(2, partidaId);
            resultados = pstmt1.executeQuery();

            try {
                pstmt2 = c.prepareStatement(queryInsert);

                pstmt2.setInt(1, resultados.getInt("nivel") + 1); // Establecemos el nivel del personaje en la consulta
                pstmt2.setInt(2, personajeId); // Establecemos el id del personaje en la consulta
                pstmt2.setInt(3, partidaId); // Establecemos el id de la partida en la consulta

                Random rnd = new Random(); // Creamos un objeto de tipo Random

                for (int i = 4; i <= 10; i++) { // Bucle para recorrer las columnas de la tabla
                    pstmt2.setInt(i, rnd.nextInt(resultados.getInt(i), resultados.getInt(i) + 101)); // Establecemos un valor aleatorio entre el valor actual y el valor actual + 100
                }

                pstmt2.executeUpdate(); // Ejecutamos la consulta
            } catch (SQLException e) {
                // TODO: handle exception
            } finally {
                if (pstmt2 != null) { // Si el PreparedStatement no es nulo
                    pstmt2.close();
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally { 
            if (pstmt1 != null) { // Si el PreparedStatement no es nulo
                pstmt1.close(); // Cerramos el PreparedStatement
            }

            if (resultados != null) { // Si hay resultados en el ResultSet
                resultados.close(); // Cerramos el ResultSet
            }
        }
    }

    /**
     * Método para subir de nivel a un personaje en la base de datos 
     * @param c Conexión con la base de datos.
     * @param personajeId Id del personaje.
     * @param partidaId Id de la partida.
     * @throws SQLException Excepción de tipo SQLException.
     */
    public int[][] subidaNivelPersonajeDatos(Connection c, int personajeId, int partidaId) throws SQLException {
        // insert tipo --> INSERT INTO juega VALUES (70, 1, 2, 50000, 10000, 1000, 1000,
        // 3000, 1000, 450);

        int[][] datosSubidaNivel = new int[2][8]; // Inicializamos un array bidimensional con 2 filas y 8 columnas

        String querySelect = "SELECT nivel, salud, fuerza, destreza, sabiduria, carisma, inteligencia, constitucion FROM juega WHERE personaje_id = ? AND partida_id = ? ORDER BY nivel DESC LIMIT 2";
        ResultSet resultados = null;
        PreparedStatement pstmt1 = null;

        try {

            pstmt1 = c.prepareStatement(querySelect); // Creamos un objeto de tipo PreparedStatement con la consulta
            pstmt1.setInt(1, personajeId);
            pstmt1.setInt(2, partidaId);
            resultados = pstmt1.executeQuery();

            int contadorFila = 0;
            while (resultados.next()) {

                datosSubidaNivel[contadorFila][0] = resultados.getInt(1); // Establecemos el nivel del personaje en la consulta
                datosSubidaNivel[contadorFila][1] = resultados.getInt(2);
                datosSubidaNivel[contadorFila][2] = resultados.getInt(3);
                datosSubidaNivel[contadorFila][3] = resultados.getInt(4);
                datosSubidaNivel[contadorFila][4] = resultados.getInt(5);
                datosSubidaNivel[contadorFila][5] = resultados.getInt(6);
                datosSubidaNivel[contadorFila][6] = resultados.getInt(7);
                datosSubidaNivel[contadorFila][7] = resultados.getInt(8);
                contadorFila++;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (pstmt1 != null) { // Si el PreparedStatement no es nulo
                pstmt1.close(); // Cerramos el PreparedStatement
            }

            if (resultados != null) { // Si hay resultados en el ResultSet
                resultados.close(); // Cerramos el ResultSet
            }
        }

        return datosSubidaNivel; // Devolvemos el array bidimensional
    }

    /**
     * Método devolver el id de un personaje en la base de datos.
     * @param c Conexión con la base de datos.
     * @param nombrePersonaje Nombre del personaje.
     * @param miembroId Id del miembro.
     */
    public int devolverPersonajeId(Connection c, String nombrePersonaje, int miembroId) throws SQLException {
        int personajeId = 0;
    
        String query = "SELECT id FROM personajes WHERE nombre = ? AND miembro_id = ?";
    
        ResultSet resultados = null; // Inicializamos el ResultSet a null
        PreparedStatement pstmt1 = null; // Inicializamos el PreparedStatement a null
    
        try {
            pstmt1 = c.prepareStatement(query); // Creamos un objeto de tipo PreparedStatement con la consulta
            pstmt1.setString(1, nombrePersonaje);
            pstmt1.setInt(2, miembroId);
    
            System.out.println("Ejecutando consulta: " + query); // Mostramos la consulta por consola
            System.out.println("Con nombrePersonaje: " + nombrePersonaje + " y miembroId: " + miembroId); // Mostramos el nombre del personaje y el id del miembro por consola
    
            resultados = pstmt1.executeQuery(); // Ejecutamos la consulta
    
            if (resultados.next()) { // Si hay resultados en el ResultSet
                personajeId = resultados.getInt(1); // Guardamos el id del personaje en una variable
                System.out.println("personajeId encontrado: " + personajeId); // Mostramos el id del personaje por consola
            } else {
                System.out.println("No se encontraron resultados.");
            }
        } finally {
            if (resultados != null) { // Si hay resultados en el ResultSet
                resultados.close(); // Cerramos el ResultSet
            }
            if (pstmt1 != null) { // Si el PreparedStatement no es nulo
                pstmt1.close(); // Cerramos el PreparedStatement
            }
        }
    
        return personajeId; // Devolvemos el id del personaje
    }
    

    
    /**
     * Método para devolver los personajes de un miembro en la base de datos.
     * @param con Conexión con la base de datos.
     * @return ArrayList con los personajes de un miembro.
     */
    public ArrayList<String> devolverPersonajesMiembro(Connection con) throws SQLException {
        ArrayList<String> arrayPersonajesMiembro = new ArrayList<>(); // Creamos un ArrayList de tipo String

        String query = "SELECT nombre FROM personajes WHERE miembro_id = ?"; // Consulta para obtener los personajes de un miembro
        System.out.println(query); // Mostramos la consulta por consola

        ResultSet resultados = null;
        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, App.getMiembroActualId());
            resultados = pstmt.executeQuery();

            while (resultados.next()) { // Mientras haya resultados en el ResultSet
                arrayPersonajesMiembro.add(resultados.getString(1)); // Añadimos el nombre del personaje al ArrayList
                System.out.println(resultados.getString(1)); // Mostramos el nombre del personaje por consola
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultados != null) { // Si hay resultados en el ResultSet
                try {
                    resultados.close();
                } catch (SQLException e) {
                    System.err.println("Error closing ResultSet: " + e.getMessage()); // Mostramos un mensaje de error por consola
                }
            }
            if (pstmt != null) { // Si el PreparedStatement no es nulo
                try {
                    pstmt.close(); // Cerramos el PreparedStatement
                } catch (SQLException e) {
                    System.err.println("Error closing PreparedStatement: " + e.getMessage());
                }
            }
            if (con != null) { // Si la conexión no es nula
                try {
                    con.close(); // Cerramos la conexión
                } catch (SQLException e) {
                    System.err.println("Error closing Connection: " + e.getMessage());
                }
            }
        }

        return arrayPersonajesMiembro; // Devolvemos el ArrayList de personajes
    }

    /**
     * Método para devolver los personajes de una partida en la base de datos.
     * @param con Conexión con la base de datos.
     * @param partidaId Id de la partida.
     * @return ArrayList con los personajes de una partida.
     */
    public ArrayList<String> devolverPersonajespPartida(Connection con, int partidaId) throws SQLException {
        ArrayList<String> arrayPersonajesPartida = new ArrayList<>(); // Creamos un ArrayList de tipo String

        String query = "SELECT nombre FROM personajes WHERE id IN (SELECT personaje_id FROM juega WHERE partida_id = ?)";
        System.out.println(query);

        ResultSet resultados = null;
        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, partidaId);
            resultados = pstmt.executeQuery();

            while (resultados.next()) { // Mientras haya resultados en el ResultSet
                arrayPersonajesPartida.add(resultados.getString(1)); // Añadimos el nombre del personaje al ArrayList
                System.out.println(resultados.getString(1) + " || "); // Mostramos el nombre del personaje por consola
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultados != null) { // Si hay resultados en el ResultSet
                try {
                    resultados.close(); // Cerramos el ResultSet
                } catch (SQLException e) {
                    System.err.println("Error closing ResultSet: " + e.getMessage()); // Mostramos un mensaje de error por consola
                }
            }
            if (pstmt != null) { // Si el PreparedStatement no es nulo
                try {
                    pstmt.close(); // Cerramos el PreparedStatement
                } catch (SQLException e) {
                    System.err.println("Error closing PreparedStatement: " + e.getMessage()); // Mostramos un mensaje de error por consola
                }
            }
            if (con != null) { // Si la conexión no es nula
                try {
                    con.close(); // Cerramos la conexión
                } catch (SQLException e) {
                    System.err.println("Error closing Connection: " + e.getMessage());
                }
            }
        }

        return arrayPersonajesPartida; // Devolvemos el ArrayList de personajes
    }

    /**
     * Método para devolver el nombre de las partidas de un game master en la base de datos.
     * @param c Conexión con la base de datos.
     * @return ArrayList con los nombres de las partidas de un game master.
     */
    public ArrayList<String> devolverPartidasNombre(Connection c) throws SQLException {
        ArrayList<String> arrayPartidasNombre = new ArrayList<>(); // Creamos un ArrayList de tipo String

        String query = "SELECT nombre FROM partidas WHERE game_master_id = ?";

        System.out.println(query);

        ResultSet resultados = null;
        PreparedStatement pstmt = null;

        try {

            pstmt = c.prepareStatement(query);
            pstmt.setInt(1, App.getMiembroActualId());

            resultados = pstmt.executeQuery();

            while (resultados.next()) { // Mientras haya resultados en el ResultSet
                arrayPartidasNombre.add(resultados.getString(1)); // Añadimos el nombre de la partida al ArrayList
                System.out.println(resultados.getString(1)); // Mostramos el nombre de la partida por consola
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally { // Bloque finally
            if (resultados != null) { // Si hay resultados en el ResultSet
                try {
                    resultados.close(); // Cerramos el ResultSet
                } catch (SQLException e) {
                    System.err.println("Error closing ResultSet: " + e.getMessage());
                }
            }
            if (pstmt != null) { // Si el PreparedStatement no es nulo
                try {
                    pstmt.close(); // Cerramos el PreparedStatement
                } catch (SQLException e) {
                    System.err.println("Error closing PreparedStatement: " + e.getMessage());
                }
            }
            if (c != null) { // Si la conexión no es nula
                try {
                    c.close(); // Cerramos la conexión
                } catch (SQLException e) {
                    System.err.println("Error closing Connection: " + e.getMessage());
                }
            }
        }

        resultados.close(); // Cerramos el ResultSet

        return arrayPartidasNombre; // Devolvemos el ArrayList de nombres de partidas
    }

    
    /**
     * Método para devolver el ID de una partida en la base de datos.
     * @param c Conexión con la base de datos.
     * @param nombrePartida Nombre de la partida.
     * @param ambientacionPartida Ambientación de la partida.
     */

    public int devolverIdPartida(Connection c, String nombrePartida, String ambientacionPartida) throws SQLException {
        int partidaSeleccionadaId = 0; // Inicializamos el id de la partida a 0

        String query = "SELECT id FROM partidas WHERE nombre = ? AND ambientacion = ?";

        System.out.println(query);

        ResultSet resultados = null;
        PreparedStatement pstmt = null;

        try {
            pstmt = c.prepareStatement(query);
            pstmt.setString(1, nombrePartida);
            pstmt.setString(2, ambientacionPartida);

            resultados = pstmt.executeQuery();

            if (resultados.next()) { // Si hay resultados en el ResultSet
                partidaSeleccionadaId = resultados.getInt("id"); // Guardamos el id de la partida en una variable
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultados != null) { // Si hay resultados en el ResultSet
                try {
                    resultados.close(); // Cerramos el ResultSet
                } catch (SQLException e) {
                    System.err.println(e.getMessage()); // Mostramos un mensaje de error por consola
                }
            }
            if (pstmt != null) { // Si el PreparedStatement no es nulo
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        return partidaSeleccionadaId; // Devolvemos el id de la partida
    }

    /**
     * Método para devolver el ID de una partida del game master en la base de datos.
     * @param c Conexión con la base de datos.
     * @param nombrePartida Nombre de la partida.
     * @param gameMasterId Id del game master.
     * @return Id de la partida.
     */
    public int devolverIdPartidaGM(Connection c, String nombrePartida, int gameMasterId) throws SQLException {
        int partidaSeleccionadaId = 0; // Inicializamos el id de la partida a 0

        String query = "SELECT id FROM partidas WHERE nombre = ? AND game_master_id = ?";

        System.out.println(query); // Mostramos la consulta por consola

        ResultSet resultados = null; 
        PreparedStatement pstmt = null; 

        try {
            pstmt = c.prepareStatement(query);
            pstmt.setString(1, nombrePartida);
            pstmt.setInt(2, gameMasterId);

            resultados = pstmt.executeQuery();

            if (resultados.next()) { // Si hay resultados en el ResultSet
                partidaSeleccionadaId = resultados.getInt("id"); // Guardamos el id de la partida en una variable
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultados != null) { // Si hay resultados en el ResultSet
                try {
                    resultados.close(); // Cerramos el ResultSet
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
            if (pstmt != null) { // Si el PreparedStatement no es nulo
                try { 
                    pstmt.close(); // Cerramos el PreparedStatement
                } catch (SQLException e) {
                    System.err.println(e.getMessage());     
                }
            }
        }

        return partidaSeleccionadaId; // Devolvemos el id de la partida
    }

    /**
     * Método para devolver el personaje seleccionado de un miembro en la base de datos.
     * @param c Conexión con la base de datos.
     * @param nombrePersonaje Nombre del personaje.
     * @return Array de objetos con los datos del personaje seleccionado.
     * @throws SQLException Excepción de tipo SQLException.
     */
    public Object[] devolverPersonajeSeleccionadoMiembro(Connection c, String nombrePersonaje) throws SQLException {
        Object[] datosPersonajeSeleccionado = new Object[3]; // Creamos un array de objetos con 3 posiciones

        String query = "SELECT id, raza, sexo FROM personajes WHERE nombre = ? AND miembro_id = ?";

        System.out.println(query); // Mostramos la consulta por consola

        ResultSet resultados = null;

        try {

            Connection con = getConexion(); // Creamos un objeto de tipo Connection
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, nombrePersonaje);
            pstmt.setInt(2, App.getMiembroActualId());

            resultados = pstmt.executeQuery();

            if (resultados.next()) { // Si hay resultados en el ResultSet
                datosPersonajeSeleccionado[0] = (Integer) resultados.getInt(1); // Guardamos el id del personaje en la primera posición del array
                datosPersonajeSeleccionado[1] = (String) resultados.getString(2); // Guardamos la raza del personaje en la segunda posición del array
                datosPersonajeSeleccionado[2] = (String) resultados.getString(3); // Guardamos el sexo del personaje en la tercera posición del array
            }

            pstmt.close(); // Cerramos el PreparedStatement

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        resultados.close();
        return datosPersonajeSeleccionado; // Devolvemos el array de objetos
    }

    /**
     * Método para devolver el id de un miembro en la base de datos.
     * @param c Conexión con la base de datos.
     * @param nombreMiembro Nombre del miembro.
     */
    public int devolverIdMiembro(Connection c, String nombreMiembro) throws SQLException {
        int miembroId = 0; // Inicializamos el id del miembro a 0

        String query = "SELECT id FROM miembros WHERE nombre = ? ";

        ResultSet resultados = null; // Inicializamos el ResultSet a null
        PreparedStatement pstmt = c.prepareStatement(query);
        
        try {

            pstmt.setString(1, nombreMiembro);

            resultados = pstmt.executeQuery();

            while (resultados.next()) { // Mientras haya resultados en el ResultSet
                miembroId = resultados.getInt("id"); // Guardamos el id del miembro en una variable
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage()); // Mostramos un mensaje de error por consola
        } finally {
             if(pstmt!= null) { // Si el PreparedStatement no es nulo
                 pstmt.close();
             }

             if(resultados != null) { // Si hay resultados en el ResultSet
                 resultados.close(); // Cerramos el ResultSet
             }
        }

        return miembroId; // Devolvemos el id del miembro

    }

    /**
     * Método para borar un personaje en la base de datos.
     * @param c Conexión con la base de datos.
     * @param nombrePersonaje Nombre del personaje.
     * @param personajeId Id del personaje.
     * @throws SQLException Excepción de tipo SQLException.
     */
    public void borrarPersonaje(Connection c, String nombrePersonaje, int personajeId) {
        String query = "DELETE FROM personajes WHERE nombre = ? AND miembro_id = ?"; // ! La wea que borra personaje
        String query2 = "DELETE FROM juega WHERE personaje_id = ?";
        System.out.println(query);
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, nombrePersonaje); // ! Nombre del personaje
            ps.setInt(2, App.getMiembroActualId()); // ! Id del miembro
            int exito = ps.executeUpdate(); // ! Ejecuta la consulta
            if (exito == 1) { // ! Si se ha borrado correctamente
                System.out.println("Borrado exitoso en personajes");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        try (PreparedStatement ps = c.prepareStatement(query2)) {
            ps.setInt(1, personajeId);
            int exito = ps.executeUpdate(); // ! Ejecuta la consulta
            if (exito == 1) { // ! Si se ha borrado correctamente
                System.out.println("Borrado exitoso en juega");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
