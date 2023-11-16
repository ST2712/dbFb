/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author admin
 */
public class Grupo {

    int codigogru, nitemp;
    String nombre;

    public void setCodigogru(int codigogru) {
        this.codigogru = codigogru;
    }

    public void setNitemp(int nitemp) {
        this.nitemp = nitemp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigogru() {
        return codigogru;
    }

    public int getNitemp() {
        return nitemp;
    }

    public String getNombre() {
        return nombre;
    }

    public Grupo() {
        this.codigogru = 0;
        this.nitemp = 0;
        this.nombre = "";
    }

    public void SetGrupo(int codigogru, int nitemp, String nombre) {
        this.codigogru = codigogru;
        this.nitemp = nitemp;
        this.nombre = nombre;
    }
}
