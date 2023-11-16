package Logica;

import java.sql.SQLException;

public class Municipio {

    private int codmun;
    private String nommun;

    public void setCodmun(int codmun) {
        this.codmun = codmun;
    }

    public int getCodmun() {
        return codmun;
    }

    public void setNommun(String nommun) {
        this.nommun = nommun;
    }

    public String getNommun() {
        return nommun;
    }

    public Municipio() {

        this.codmun = 0;
        this.nommun = "";
    }

    public void SetMunicipio(int codmun, String nommun) throws SQLException {
        this.codmun = codmun;
        this.nommun = nommun;
    }
}
