package testsProyecto;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.*;
import model.AccesoBD;


public class DevolverPartidasNombre {
	
	private AccesoBD acceso = new AccesoBD();
	private Connection con = acceso.getConexion();
	
	@Test
    public void testDevolverPartidasNombre() throws SQLException {
        ArrayList<String> result = null;

        try {
			result = acceso.devolverPartidasNombre(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        assertNotNull(result);
        assertInstanceOf(ArrayList.class, result);
    }

}
	
