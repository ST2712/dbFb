/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fisico;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BD.*;
import java.sql.SQLException;

public class Eliminar {

    private String cual;
    private JPanel datos,  boton;
    private JButton guardar,  cancelar;
    private JLabel codtipo,  table;
    private JTextField codtipot,  jtx1;
    String[] tipo = {"Empresa", "Grupo", "Persona", "Estudios", "Municipio", "Proyecto"};
    private JComboBox tipdousua;
    IngresoBD conector;
    EliminaBD em;
    JFrame tipart = new JFrame("ELIMINAR");

    public Eliminar(IngresoBD base) throws SQLException {

        conector = base;
        em =  new EliminaBD(conector);
        tipart.getContentPane().setLayout(new BorderLayout());

        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(2, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");

        codtipo = new JLabel("CODIGO");
        table = new JLabel("ELIMINAR A:");
        tipdousua = new JComboBox(tipo);
        tipdousua.setSelectedIndex(0);


        codtipot = new JTextField(20);
        jtx1 = new JTextField(10);

        datos.add(codtipo);
        datos.add(codtipot);
        datos.add(table);
        datos.add(tipdousua);

        tipart.add(datos, BorderLayout.CENTER);

        boton.add(guardar);
        boton.add(cancelar);
        tipart.add(boton, BorderLayout.SOUTH);


        tipart.pack();
        tipart.setVisible(true);

        ManejadorBoton manejador = new ManejadorBoton();
        guardar.addActionListener(manejador);
        cancelar.addActionListener(manejador);

    }

    private class ManejadorBoton implements ActionListener {
        // manejar evento de botón

        public void actionPerformed(ActionEvent evento) {
            // JOptionPane.showMessageDialog( Start.this,
            // "Usted oprimió: " + evento.getActionCommand() );

            cual = evento.getActionCommand();
            jtx1.setText(String.valueOf(tipdousua.getSelectedItem()));

            if (cual.equals("INGRESAR")) {
                try {
                    em.EliminarDato(codtipot.getText(), jtx1.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
                }

                tipart.setVisible(false);
            } else if (cual.equals("LIMPIAR")) {
                Limpiar();
            }
        }
    }

    public void Limpiar() {
        codtipot.setText("");

    }
}


