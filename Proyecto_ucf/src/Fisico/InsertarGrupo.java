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
public class InsertarGrupo {

    private String cual;
    private JPanel datos,  boton;
    private JButton guardar,  cancelar;
    private JLabel nombre,  codg,  nit;
    private JTextField nombret,  codgt,  nitt;
    private IngresoBD conectar;
    Grupo emp = new Grupo();
    JFrame usua = new JFrame("   Grupo   ");

    public InsertarGrupo(IngresoBD base) {

        usua.getContentPane().setLayout(new BorderLayout());
        conectar = base;
        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(3, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");

        nit = new JLabel(" NIT_DE_LA_EMPRESA ");
        nombre = new JLabel(" NOMBRE ");
        codg = new JLabel(" CODIGO DEL GRUPO ");

        nitt = new JTextField(10);
        nombret = new JTextField(10);
        codgt = new JTextField(10);

        datos.add(nit);
        datos.add(nitt);
        datos.add(nombre);
        datos.add(nombret);
        datos.add(codg);
        datos.add(codgt);
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

                sql = "INSERT INTO GRUPO VALUES('" + codgt.getText() + "','" +
                        nitt.getText() + "','" + nombret.getText() + "')";
                conectar.executeUpdateStatement(sql);
                usua.setVisible(false);
            } else if (cual.equals("LIMPIAR")) {
                Limpiar();
            }
        }
    }

    public void Limpiar() {
        nombret.setText("");
        codgt.setText("");
        nitt.setText("");
    }
}
