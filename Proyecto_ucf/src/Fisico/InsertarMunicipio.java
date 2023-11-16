/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fisico;

import BD.IngresoBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Logica.*;

/**
 *
 * @author admin
 */
public class InsertarMunicipio {

    private String cual;
    private JPanel datos,  boton;
    private JButton guardar,  cancelar;
    private JLabel nombre,  codlinea,  codgru;
    private JTextField nombret,  codlineat,  codgrut;
    private IngresoBD conectar;
    Municipio emp = new Municipio();
    JFrame usua = new JFrame("   MUNICIPIO   ");

    public InsertarMunicipio(IngresoBD base) {

        usua.getContentPane().setLayout(new BorderLayout());
        conectar = base;
        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(2, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");

        nombre = new JLabel(" NOMBRE ");
        codgru = new JLabel(" CODIGO_MUNICIPIO  ");

        nombret = new JTextField(10);
        codlineat = new JTextField(10);
        codgrut = new JTextField(10);

        datos.add(nombre);
        datos.add(nombret);
        datos.add(codgru);
        datos.add(codgrut);
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
                sql = "INSERT INTO MUNICIPIO VALUES('" + codgrut.getText() + "','"
                        + nombret.getText() + "')";
                conectar.executeUpdateStatement(sql);
                usua.setVisible(false);
            } else if (cual.equals("LIMPIAR")) {
                Limpiar();
            }
        }
    }

    public void Limpiar() {
        nombret.setText("");
        codlineat.setText("");
        codgrut.setText("");
    }
}
