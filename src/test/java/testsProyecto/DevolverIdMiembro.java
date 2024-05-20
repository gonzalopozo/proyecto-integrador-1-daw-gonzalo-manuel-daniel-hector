package testsProyecto;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

import org.junit.jupiter.api.*;
import model.AccesoBD;

public class DevolverIdMiembro {

    private AccesoBD acceso = new AccesoBD();
    private Connection con = acceso.getConexion();

    @Test
    public void testDevolverIdMiembro() throws SQLException {
        int result = 0;

        try {
            result = acceso.devolverIdMiembro(con, "Daniel");
        } catch (SQLException e) {
        }
        assertNotNull(result);
        assertEquals(2, result);
    }

}
