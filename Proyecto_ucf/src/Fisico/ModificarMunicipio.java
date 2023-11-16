/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fisico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BD.*;

/**
 *
 * @author admin
 */
public class ModificarMunicipio {

    private String cual;
    private JPanel datos,  boton;
    private JButton guardar,  cancelar;
    private JLabel codiusua,  nombusua,  nudousua,  tipodo,  tipos;
    private JTextField codiusuat,  nombusuat,  nudousuat,  jt1,  jt2,  codiespot;
    private JComboBox tipdousua;
    private IngresoBD conectar;
    JFrame usua = new JFrame("   PROYECTO  ");

    public ModificarMunicipio(IngresoBD base) {

        usua.getContentPane().setLayout(new BorderLayout());
        conectar = base;
        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(4, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");

        tipodo = new JLabel(" CODIGO ");
        nombusua = new JLabel(" NOMBRE ");

        codiespot = new JTextField(10);
        nombusuat = new JTextField(50);

        datos.add(tipodo);
        datos.add(codiespot);
        datos.add(nombusua);
        datos.add(nombusuat);

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
                sql = "UPDATE MUNICIPIO SET NOMMUN= '"+nombusuat.getText()+
                        "' where CODMUN= '"+codiespot.getText()+"'";
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
        nudousuat.setText("");
        jt1.setText("");
        jt2.setText("");
        codiespot.setText("");
    }
}

