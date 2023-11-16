/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.SQLException;

public class Estudios {

    private int nudousua,  code;
    private String institucion,  tipoestudio,  titulo;

    public Estudios() {
        this.code = 0;
        this.nudousua = 0;
        this.institucion = "";
        this.tipoestudio = "";
        this.titulo = "";
    }

    public void setEstudios(int code, int nudousua, String institucion, String tipoestudio, String titulo) throws SQLException {
        this.code = code;
        this.nudousua = nudousua;
        this.institucion = institucion;
        this.tipoestudio = tipoestudio;
        this.titulo = titulo;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public void setNudousua(int nudousua) {
        this.nudousua = nudousua;
    }

    public void setTipoestudio(String tipoestudio) {
        this.tipoestudio = tipoestudio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public int getNudousua() {
        return nudousua;
    }

    public String getTipoestudio() {
        return tipoestudio;
    }

    public String getTitulo() {
        return titulo;
    }
}
