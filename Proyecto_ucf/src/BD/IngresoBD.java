/* MNTE
 * IngresoBD.java
 *
 * @author vGus
 * @version 1.00 2009/06/27
 */
package BD;

import java.sql.*;


public class IngresoBD {

    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    String url = "jdbc:firebirdsql://localhost:3050/c:/sosdb/proy.fdb";

    public IngresoBD() {
        try {
            DriverManager.registerDriver(new org.firebirdsql.jdbc.FBDriver());
        } catch (Exception e) {
            System.err.println("Error al intentar cargar Driver. " + e.getMessage());
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url, "GMV", "gustavazo");
        //System.out.println("Conexion exitosa...");
        } catch (Exception e) {
            System.out.println("Error al conectarce: " + e);
        }
    }

    public ResultSet executeQueryStatement(String cad) {
        rset = null;
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(cad);
            System.out.println("Consulta realizada...  ");
        } catch (Exception ex) {
            System.out.println("No se pudo efectuar la consultaxx..." + ex);
        }
        return rset;
    }

    public boolean executeUpdateStatement(String cad) {
        int r = 0;
        try {
            stmt = conn.createStatement();
            r = stmt.executeUpdate(cad);
            System.out.println("Actualizacion realizada...  " + r);
            stmt.close();
            return true;
        } catch (Exception ex) {
            System.out.println("No se pudo efectuar la grabacion..." + ex);
            return false;
        }
    }
}