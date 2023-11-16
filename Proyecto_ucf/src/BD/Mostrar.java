/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

//import oracle.jdbc.pool.OracleDataSource;
import java.util.*;
/**
 *
 * @author admin
 */
import java.sql.*;
import javax.swing.JOptionPane;
//import oracle.jdbc.pool.OracleDataSource;

public class Mostrar {
//private OracleDataSource ods;
    private ResultSet rset;
    private IngresoBD conectar;

    public Mostrar(IngresoBD base) {
        conectar = base;
    }

    public ArrayList empresa() {

        ArrayList listaveh = new ArrayList();
        try {

            rset = conectar.executeQueryStatement("select * from empresa order by 1");

            String nom, ape, tel, dir, cc, ti, sal;
            while (rset.next()) {

                nom = rset.getString(1);
                ape = rset.getString(2);
                dir = rset.getString(3);
                ti = rset.getString(4);
                sal = rset.getString(5);
                listaveh.add(nom);
                listaveh.add(ape);
                listaveh.add(dir);
                listaveh.add(ti);
                listaveh.add(sal);
            }

            // Close the Statement

        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error  " + q, "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);

        }
        return listaveh;

    }

    public ArrayList empleado() {

        ArrayList listaveh = new ArrayList();
        try {
            rset = conectar.executeQueryStatement("select * from empleado order by 1");

            String nom, ape, tel, dir, cc, ti, sal;
            while (rset.next()) {

                nom = rset.getString(1);
                ape = rset.getString(2);
                dir = rset.getString(3);
                ti = rset.getString(4);
                sal = rset.getString(5);
                tel = rset.getString(6);
                cc = rset.getString(7);
                listaveh.add(nom);
                listaveh.add(ape);
                listaveh.add(dir);
                listaveh.add(ti);
                listaveh.add(sal);
                listaveh.add(tel);
                listaveh.add(cc);

            }

        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error  " + q, "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);

        }
        return listaveh;

    }

    public ArrayList municipio() {

        ArrayList listaveh = new ArrayList();
        String nom;

        try {
            rset = conectar.executeQueryStatement("select * from municipio order by 2");

            while (rset.next()) {
                nom = rset.getString(2);
                System.out.println(nom);
                listaveh.add(nom);
            }

        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error  " + q, "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);

        }
        return listaveh;
    }

    public ArrayList busqueda(String nom) {

        ArrayList listaveh = new ArrayList();
        try {
            rset = conectar.executeQueryStatement("select * from empresa where NOMMUNIC=" + "'" + nom + "'" + "");

            String nomb, ape, tel, dir, cc, ti, sal;
            while (rset.next()) {

                nomb = rset.getString(1);
                ape = rset.getString(2);
                dir = rset.getString(3);
                ti = rset.getString(4);
                sal = rset.getString(5);
                listaveh.add(nomb);
                listaveh.add(ape);
                listaveh.add(dir);
                listaveh.add(ti);
                listaveh.add(sal);


            }

        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error  " + q, "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);

        }
        return listaveh;

    }

    public ArrayList grupo() {

        ArrayList listaveh = new ArrayList();
        try {
            rset = conectar.executeQueryStatement("select * from grupo order by 1");

            String nom, ape, tel, dir, cc, ti, sal;
            while (rset.next()) {

                nom = rset.getString(1);
                ape = rset.getString(2);
                dir = rset.getString(3);

                listaveh.add(nom);
                listaveh.add(ape);
                listaveh.add(dir);


            }

        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error  " + q, "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);

        }
        return listaveh;

    }

    public ArrayList linvestigacion() {

        ArrayList listaveh = new ArrayList();
        try {
            rset = conectar.executeQueryStatement("select * from MUNICIPIO order by 1");

            String nom, ape;
            while (rset.next()) {

                nom = rset.getString(1);
                ape = rset.getString(2);
                listaveh.add(nom);
                listaveh.add(ape);


            }
        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error  " + q, "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);

        }
        return listaveh;

    }

    public ArrayList investigacion() {

        ArrayList listaveh = new ArrayList();
        try {
            rset = conectar.executeQueryStatement("select * from proyecto order by 1");

            String nom, ape, tel, dir, cc, ti, sal, och;
            while (rset.next()) {

                nom = rset.getString(1);
                ape = rset.getString(2);
                dir = rset.getString(3);
                ti = rset.getString(4);
                sal = rset.getString(5);
                tel = rset.getString(6);
                och = rset.getString(7);
                cc = rset.getString(8);

                listaveh.add(nom);
                listaveh.add(ape);
                listaveh.add(dir);
                listaveh.add(ti);
                listaveh.add(sal);
                listaveh.add(tel);
                listaveh.add(och);
                listaveh.add(cc);


            }

        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error  " + q, "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);

        }
        return listaveh;

    }

    public ArrayList estudios() {

        ArrayList listaveh = new ArrayList();
        try {
            rset = conectar.executeQueryStatement("select * from estudios order by 1");

            String nom, ape, tel, dir, cc, ti, sal;
            while (rset.next()) {

                nom = rset.getString(1);
                ape = rset.getString(2);
                dir = rset.getString(3);
                ti = rset.getString(4);
                sal = rset.getString(5);

                listaveh.add(nom);
                listaveh.add(ape);
                listaveh.add(dir);
                listaveh.add(ti);
                listaveh.add(sal);



            }

        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error  " + q, "Mensaje de error", JOptionPane.INFORMATION_MESSAGE);

        }
        return listaveh;

    }
}
