/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fisico;

import BD.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author admin
 */
public class MostrarEmpleado {

    Mostrar ser;
    private JTable tabla;
    private JScrollPane panelScroll;
    private String titColumna[];
    private String datoColumna[][];
    private JPanel datos;
    private IngresoBD conectar;
    ArrayList veh;
    JFrame usua = new JFrame("   EMPLEADOS  ");

    public MostrarEmpleado(IngresoBD base, Mostrar servicio) {
        usua.getContentPane().setLayout(new BorderLayout());
        // Creamos las columnas y las cargamos con los datos que van a
        // aparecer en la pantalla
        datos = new JPanel();
        conectar = base;
        ser  = servicio;
        veh = ser.empleado();
        CreaColumnas();
        CargaDatos();
        // Creamos una instancia del componente Swing
        tabla = new JTable(datoColumna, titColumna);
        // Aquí se configuran algunos de los parámetros que permite
        // variar la JTable
        tabla.setShowHorizontalLines(false);
        tabla.setRowSelectionAllowed(true);
        tabla.setColumnSelectionAllowed(true);
        // Cambiamos el color de la zona seleccionada (rojo/blanco)
        tabla.setSelectionForeground(Color.white);
        tabla.setSelectionBackground(Color.red);
        // Incorporamos la tabla a un panel que incorpora ya una barra
        // de desplazamiento, para que la visibilidad de la tabla sea
        // automática
        panelScroll = new JScrollPane(tabla);
        datos.add(panelScroll, BorderLayout.CENTER);
        usua.add(datos, BorderLayout.CENTER);
        usua.pack();
        usua.setVisible(true);
    //usua.setSize(400,200);
    }

    public void CreaColumnas() {
        titColumna = new String[7];


        titColumna[0] = " CODIGO ";
        titColumna[1] = " CODIGO_GRUPO";
        titColumna[2] = " NOMBRE";
        titColumna[3] = " DIRECCION";
        titColumna[4] = " TELEFONO";
        titColumna[5] = " CEDULA";
        titColumna[6] = " TIPO.DOC";

    }

    public void CargaDatos() {
        datoColumna = new String[100][7];
        int i = 0;
        //System.out.println(veh.size() + "" + veh.get(1));
        int d = veh.size();
        d = d / 7;
        while (i < d) {
            datoColumna[i][0] = (String) veh.get((i * 7) + 0);
            datoColumna[i][1] = (String) veh.get((i * 7) + 1);
            datoColumna[i][2] = (String) veh.get((i * 7) + 2);
            datoColumna[i][3] = (String) veh.get((i * 7) + 3);
            datoColumna[i][4] = (String) veh.get((i * 7) + 4);
            datoColumna[i][5] = (String) veh.get((i * 7) + 5);
            datoColumna[i][6] = (String) veh.get((i * 7) + 6);
            i++;
        }

    }
}
