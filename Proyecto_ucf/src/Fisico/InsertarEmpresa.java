/* MNTE
 * InsertarEmpresa.java
 *
 * @author vGus
 * @version 1.00 2009/06/27
 */
package Fisico;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

import Logica.*;
import BD.*;

public class InsertarEmpresa {

    private String cual;
    private JPanel datos,  boton;
    private String Columna[];
    private JButton guardar,  cancelar;
    private JLabel nombre,  direccion,  telefono,  vinculacion,  nit,  muni;
    private JTextField nombret,  direcciont,  telefonot,  nitt,  munit;
    private JComboBox municipio;
    private IngresoBD conectar;
    Empresa emp = new Empresa();
    Mostrar ser;
    JFrame usua = new JFrame("   Empresa   ");

    public InsertarEmpresa(IngresoBD base) {

        usua.getContentPane().setLayout(new BorderLayout());

        conectar = base;
        ser = new Mostrar(conectar);
        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(5, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");

        nit = new JLabel(" NIT ");
        nombre = new JLabel(" NOMBRE ");
        telefono = new JLabel(" TELEFONO ");
        direccion = new JLabel(" DIRECCION ");
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
        nitt = new JTextField(10);
        nombret = new JTextField(50);
        telefonot = new JTextField(50);
        direcciont = new JTextField(15);
        munit = new JTextField(20);
        datos.add(nit);
        datos.add(nitt);
        datos.add(nombre);
        datos.add(nombret);
        datos.add(telefono);
        datos.add(telefonot);
        datos.add(direccion);
        datos.add(direcciont);
        datos.add(muni);
        datos.add(municipio);
        usua.add(datos, BorderLayout.CENTER);



        boton.add(guardar);
        boton.add(cancelar);
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

                String sql;
                sql = "INSERT INTO EMPRESA VALUES(" + "'" + nitt.getText() + "','" + nombret.getText() + "','" + direcciont.getText() + "','" +
                        telefonot.getText() + "','" + municipio.getSelectedItem() + "')";
                conectar.executeUpdateStatement(sql);
                usua.setVisible(false);
            } else if (cual.equals("LIMPIAR")) {
                Limpiar();
            }
        }
    }

    public void Limpiar() {
        nombret.setText("");
        direcciont.setText("");
        telefonot.setText("");
        nitt.setText("");
    }
}
