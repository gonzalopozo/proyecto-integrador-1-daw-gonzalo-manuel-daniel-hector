package testsProyecto;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.*;
import model.AccesoBD;


public class DevolverPersonajeTest {
	
	private AccesoBD acceso = new AccesoBD();
	private Connection con = acceso.getConexion();
	
	@Test
    public void testDevolverPersonaje() throws SQLException {
        int result = 0;

        try {
			result = acceso.devolverPersonajeId(con, "Joselito", 9);
		} catch (SQLException e) {
		}
        assertNotNull(result);
        assertEquals(9, result);
    }

}
	
