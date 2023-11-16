/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author admin
 */
public class Proyecto {

    private String mision,  vision,  objetivos,  nombre,  munic,  nomlin;
    private int codlinea,  codinv;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodlinea(int codlinea) {
        this.codlinea = codlinea;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public int getCodlinea() {
        return codlinea;
    }

    public String getMision() {
        return mision;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public String getVision() {
        return vision;
    }

    public Proyecto() {
        this.mision = "";
        this.vision = "";
        this.objetivos = "";
        this.nombre = "";
        this.codlinea = 0;
        this.codinv = 0;
    }

    public void SetProyecto(String mision, String vision, String objetivos, String nombre, int codlinea, int codinv, String munic, String nomlin) {
        this.mision = mision;
        this.vision = vision;
        this.objetivos = objetivos;
        this.nombre = nombre;
        this.codlinea = codlinea;
        this.codinv = codinv;
        this.munic = munic;
        this.nomlin = nomlin;
    }

    public int getCodinv() {
        return codinv;
    }

    public void setCodinv(int codinv) {
        this.codinv = codinv;
    }
}
