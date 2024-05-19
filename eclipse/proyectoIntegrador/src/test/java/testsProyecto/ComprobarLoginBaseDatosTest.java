package testsProyecto;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.*;
import model.AccesoBD;


public class ComprobarLoginBaseDatosTest {
	
	private AccesoBD acceso = new AccesoBD();
	private Connection con = acceso.getConexion();
	
	@Test
    public void testComprobarLogin() throws SQLException {
        Object[] result = null;

        try {
			result = acceso.comprobarLogin(con, "Gonzalo");
		} catch (SQLException e) {
			// TODO: handle exception
		}
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals("lebron", result[1]);
    }

}
	
