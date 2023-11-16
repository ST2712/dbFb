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
public class MostrarEstudios {

    Mostrar ser;
    private JTable tabla;
    private JScrollPane panelScroll;
    private String titColumna[];
    private String datoColumna[][];
    private JPanel datos;
    private IngresoBD conectar;
    ArrayList veh;
    JFrame usua = new JFrame("   ESTUDIOS  ");

    public MostrarEstudios(IngresoBD base) {
        usua.getContentPane().setLayout(new BorderLayout());
        // Creamos las columnas y las cargamos con los datos que van a
        // aparecer en la pantalla
        datos = new JPanel();
        conectar = base;
        ser  = new Mostrar(conectar);
        veh = ser.estudios();
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
        titColumna = new String[5];


        titColumna[0] = " CODIGO ";
        titColumna[1] = " COD_EMPLEADO";
        titColumna[2] = " TITULO";
        titColumna[3] = " INSTITUTO";
        titColumna[4] = " TIPO_ESTUDIO";

    }

    public void CargaDatos() {
        datoColumna = new String[100][5];
        int i = 0;
        //System.out.println(veh.size() + "" + veh.get(1));
        int d = veh.size();
        d = d / 5;
        while (i < d) {
            datoColumna[i][0] = (String) veh.get((i * 5) + 0);
            datoColumna[i][1] = (String) veh.get((i * 5) + 1);
            datoColumna[i][2] = (String) veh.get((i * 5) + 2);
            datoColumna[i][3] = (String) veh.get((i * 5) + 3);
            datoColumna[i][4] = (String) veh.get((i * 5) + 4);
            i++;
        }

    }
}
