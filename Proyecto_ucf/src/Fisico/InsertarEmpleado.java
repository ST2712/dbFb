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
public class InsertarEmpleado {

    private String cual;
    private JPanel datos,  boton;
    private JButton guardar,  cancelar;
    private JLabel codiusua,  nombusua,  direusua,  teleusua,  nudousua,  tipodo,  codgru;
    private JTextField codiusuat,  nombusuat,  direusuat,  teleusuat,  nudousuat,  jt1,  codgrut;
    private IngresoBD conectar;
    String[] tipo = {"CC", "CE"};
    private JComboBox tipdousua;
    Empleado us = new Empleado();
    JFrame usua = new JFrame("   EMPLEADO   ");

    public InsertarEmpleado(IngresoBD base) {

        usua.getContentPane().setLayout(new BorderLayout());
        conectar = base;
        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(7, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");

        tipodo = new JLabel(" TIPO DOCUMENTO ");
        codiusua = new JLabel(" CODIGO ");
        nombusua = new JLabel(" NOMBRE ");
        direusua = new JLabel(" DIRECCION ");
        teleusua = new JLabel(" TELEFONO ");
        nudousua = new JLabel("NUMERO DE CEDULA");
        codgru = new JLabel("CODIGO GRUPO");
        tipdousua = new JComboBox(tipo);


        tipdousua.setSelectedIndex(0);
        codiusuat = new JTextField(10);
        nombusuat = new JTextField(50);
        direusuat = new JTextField(50);
        teleusuat = new JTextField(15);
        nudousuat = new JTextField(10);
        jt1 = new JTextField(2);
        codgrut = new JTextField(10);

        datos.add(tipodo);
        datos.add(tipdousua);
        datos.add(nudousua);
        datos.add(nudousuat);
        datos.add(nombusua);
        datos.add(nombusuat);
        datos.add(teleusua);
        datos.add(teleusuat);
        datos.add(direusua);
        datos.add(direusuat);
        datos.add(codiusua);
        datos.add(codiusuat);
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
                sql = "INSERT INTO EMPLEADO VALUES('" + codiusuat.getText() + "','" +
                        codgrut.getText() + "','" + nombusuat.getText() + "','" +
                        direusuat.getText() + "','" + teleusuat.getText() + "','" +
                        nudousuat.getText() + "','" + tipdousua.getSelectedItem()+ "')";
                conectar.executeUpdateStatement(sql);
                usua.setVisible(false);
            } else if (cual.equals("LIMPIAR")) {
                Limpiar();
            }
        }
    }

    public void Limpiar() {

        codiusuat.setText("");
        nombusuat.setText("");
        direusuat.setText("");
        teleusuat.setText("");
        nudousuat.setText("");
        jt1.setText("");
        codgrut.setText("");

    }
}
