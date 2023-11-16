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
public class InsertarEstudios {

    private String cual;
    private JPanel datos,  boton;
    private JButton guardar,  cancelar;
    private JLabel codest,  codiusua,  institucion,  tipoestudio,  titulo;
    private JTextField codestt,  codiusuat,  instituciont,  titulot,  jt1;
    private IngresoBD conectar;
    String[] tipo = {"TECNICO", "TECNOLOGO", "UNIVERSITARIO", "POSGRADO"};
    private JComboBox tipoestu;
    Estudios us = new Estudios();
    JFrame usua = new JFrame("  ESTUDIOS DEL  EMPLEADO   ");

    public InsertarEstudios(IngresoBD base) {

        usua.getContentPane().setLayout(new BorderLayout());
        conectar = base;
        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(5, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");


        codest = new JLabel(" CODIGO");
        codiusua = new JLabel(" CODIGO EMPLEADO ");
        institucion = new JLabel(" INSTITUCION ");
        tipoestudio = new JLabel(" TIPO DE ESTUDIO ");
        titulo = new JLabel(" TITULO ");
        tipoestu = new JComboBox(tipo);


        tipoestu.setSelectedIndex(0);

        codiusuat = new JTextField(10);
        instituciont = new JTextField(50);
        titulot = new JTextField(50);
        jt1 = new JTextField(10);
        codestt = new JTextField(10);

        datos.add(codest);
        datos.add(codestt);
        datos.add(codiusua);
        datos.add(codiusuat);
        datos.add(institucion);
        datos.add(instituciont);
        datos.add(tipoestudio);
        datos.add(tipoestu);
        datos.add(titulo);
        datos.add(titulot);
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

                sql = "INSERT INTO ESTUDIOS VALUES('" + codestt.getText()
                        + "','" + codiusuat.getText() + "','" + titulot.getText()
                        + "','" + instituciont.getText() + "','" + tipoestu.getSelectedItem() + "')";
                conectar.executeUpdateStatement(sql);

                usua.setVisible(false);
            } else if (cual.equals("LIMPIAR")) {
                Limpiar();
            }
        }
    }

    public void Limpiar() {
        codestt.setText("");
        codiusuat.setText("");
        instituciont.setText("");
        titulot.setText("");
        jt1.setText("");
    }
}
