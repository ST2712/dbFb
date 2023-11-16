/* MNTE
* Empresa.java
*
* @author vGus
* @version 1.00 2009/06/27
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

package Logica;
import java.sql.SQLException;

public class Empresa {

    private int nit;
    private String nombre,direccion,telefono,vinculacion,munici;

    public void setMunici(String munici) {
        this.munici = munici;
    }

    public String getMunici() {
        return munici;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getVinculacion() {
        return vinculacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setVinculacion(String vinculacion) {
        this.vinculacion = vinculacion;
    }

    public void SetEmpresa(int nit, String nombre, String direccion, String telefono,String munici) throws SQLException {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.munici=munici;
        System.out.println(telefono);
    }
    
public Empresa() {
        this.nit = 0;
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.vinculacion = "";
    }
}
