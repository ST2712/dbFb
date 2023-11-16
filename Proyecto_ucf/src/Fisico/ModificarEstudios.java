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
public class ModificarEstudios {

    private String cual;
    private JPanel datos,  boton;
    private JButton guardar,  cancelar;
    private JLabel codiusua,  nombusua,  direusua,  teleusua,  nudousua,  tipodo,  tipos;
    private JTextField codiusuat,  nombusuat,  direusuat,  teleusuat,  nudousuat,  jt1,  jt2,  codiespot;
    private JComboBox tipdousua;
    private IngresoBD conectar;
    JFrame usua = new JFrame("   ESTUDIOS   ");

    public ModificarEstudios(IngresoBD base) {

        usua.getContentPane().setLayout(new BorderLayout());
        conectar = base;

        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(3, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");

        tipodo = new JLabel(" CODIGO ");
        nombusua = new JLabel(" TITULO ");
        codiusua = new JLabel(" INSTITUTO ");


        codiespot = new JTextField(10);
        nombusuat = new JTextField(50);
        teleusuat = new JTextField(20);

        datos.add(tipodo);
        datos.add(codiespot);
        datos.add(nombusua);
        datos.add(nombusuat);
        datos.add(codiusua);
        datos.add(teleusuat);

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
                int uno = Integer.parseInt(codiespot.getText());
                String sql;
                sql = "UPDATE ESTUDIOS  SET TITULO= '"+nombusuat.getText()+"',INSTITUCION= '"+
                        teleusuat.getText()+"'where CODEST= '"+codiespot.getText()+"'";
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
        codiespot.setText("");
    }
}
