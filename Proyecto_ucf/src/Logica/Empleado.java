/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import BD.*;

import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Empleado {

    private String tidousua,  nomusua,  direusua;
    private int nudousua,  teleusua,  codiusua,  codgru;

    public Empleado() {
        tidousua = "";
        nomusua = "";
        direusua = "";
        nudousua = 0;
        teleusua = 0;
        codiusua = 0;
    }

    public void SetEmpleado(String tidousua, String nomusua, String direusua, int nudousua, int teleusua, int codiusua, int codgru) throws SQLException {
        this.tidousua = tidousua;
        this.nomusua = nomusua;
        this.direusua = direusua;
        this.nudousua = nudousua;
        this.teleusua = teleusua;
        this.codiusua = codiusua;
        this.codgru = codgru;
    }

    public int getCodgru() {
        return codgru;
    }

    public int getCodiusua() {
        return codiusua;
    }

    public String getDireusua() {
        return direusua;
    }

    public String getNomusua() {
        return nomusua;
    }

    public int getNudousua() {
        return nudousua;
    }

    public int getTeleusua() {
        return teleusua;
    }

    public String getTidousua() {
        return tidousua;
    }

    public void setCodgru(int codgru) {
        this.codgru = codgru;
    }

    public void setCodiusua(int codiusua) {
        this.codiusua = codiusua;
    }

    public void setDireusua(String direusua) {
        this.direusua = direusua;
    }

    public void setNomusua(String nomusua) {
        this.nomusua = nomusua;
    }

    public void setNudousua(int nudousua) {
        this.nudousua = nudousua;
    }

    public void setTeleusua(int teleusua) {
        this.teleusua = teleusua;
    }

    public void setTidousua(String tidousua) {
        this.tidousua = tidousua;
    }
}
