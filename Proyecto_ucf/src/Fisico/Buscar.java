
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fisico;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

import BD.*;

/**
 *
 * @author admin
 */
public class Buscar {

    private String cual;
    private JPanel datos,  boton;
    private String Columna[];
    private JButton guardar,  cancelar;
    private JLabel muni;
    private JTextField munit;
    private JComboBox municipio;
    private IngresoBD conectar;
    Mostrar ser = new Mostrar(conectar);
    JFrame usua = new JFrame("  BUSQUEDA   ");

    public Buscar(IngresoBD base) {

        usua.getContentPane().setLayout(new BorderLayout());
        conectar = base;
        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(5, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");

        muni = new JLabel(" MUNICIPIO ");

        ArrayList veh = ser.municipio();
        Columna = new String[100];
        int i = 0;
        int d = veh.size();
        System.out.println(d);
        while (i < d) {
            Columna[i] = (String) veh.get((i));
            System.out.println(Columna[i]);
            i++;
        }


        municipio = new JComboBox(Columna);
        municipio.setSelectedIndex(0);
        munit = new JTextField(20);
        datos.add(muni);
        datos.add(municipio);
        usua.add(datos, BorderLayout.CENTER);
// Creamos una instancia del componente Swing

        boton.add(guardar);
        usua.add(boton, BorderLayout.SOUTH);


        usua.pack();
        usua.setVisible(true);
        usua.setSize(400, 200);



        ManejadorBoton manejador = new ManejadorBoton();
        guardar.addActionListener(manejador);
        cancelar.addActionListener(manejador);

    }

    private class ManejadorBoton implements ActionListener {
        // manejar evento de botón

        public void actionPerformed(ActionEvent evento) {
            cual = evento.getActionCommand();
            if (cual.equals("INGRESAR")) {
                munit.setText(String.valueOf(municipio.getSelectedItem()));

                ArrayList veh = ser.busqueda(munit.getText());
                usua.setVisible(false);

                MostrarConsulta cons = new MostrarConsulta(veh,conectar);

            }

        }
    }
}
