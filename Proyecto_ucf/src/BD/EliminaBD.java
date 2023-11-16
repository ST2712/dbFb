package BD;

import java.sql.*;
import javax.swing.JOptionPane;

public class EliminaBD {

    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    IngresoBD conectar;

    public EliminaBD(IngresoBD base) {
        conectar = base;
    }

    public void EliminarDato(String cod, String tipo) throws SQLException {

        // Create a OracleDataSource instance and set properties
        int a = Integer.parseInt(cod);

        if (tipo.equals("Empresa")) {
            conectar.executeUpdateStatement("DELETE FROM EMPRESA where NITEMP=" + "'" + a + "'" + "");
        } else if (tipo.equals("Proyecto")) {
            conectar.executeUpdateStatement("DELETE FROM PROYECTO where CODPRO=" + "'" + a + "'" + "");
        } else if (tipo.equals("Grupo")) {
            conectar.executeUpdateStatement("DELETE FROM GRUPO where CODGRU=" + "'" + a + "'" + "");
        } else if (tipo.equals("Persona")) {
            conectar.executeUpdateStatement("DELETE FROM EMPLEADO where CODEMP=" + "'" + a + "'" + "");
        } else if (tipo.equals("Estudios")) {
            conectar.executeUpdateStatement("DELETE FROM ESTUDIOS where CODEST=" + "'" + a + "'" + "");
        } else if (tipo.equals("Municipio")) {
            conectar.executeUpdateStatement("DELETE FROM Municipio where CODMUN=" + "'" + a + "'" + "");
        }

    }
}
