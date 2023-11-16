package Fisico;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import Logica.*;
import BD.*;

/**
 *
 * @author admin
 */
public class InsertarProyecto {

    private String cual;
    private JPanel datos,  boton;
    private JButton guardar,  cancelar;
    private JLabel espacio,  nombre,  codlinea,  codinv,  mision,  vision,  objetivos,  muni,  nomlinv;
    private JTextArea misiont,  visiont,  objetivost;
    private String Columna[];
    private JComboBox municipio;
    private JTextField nombret,  codlineat,  codinvt,  munit,  nomlinvt;
    private IngresoBD conectar;
    Mostrar ser = new Mostrar(conectar);
    Proyecto emp = new Proyecto();
    JFrame usua = new JFrame("   Proyecto   ");

    public InsertarProyecto(IngresoBD base) {

        usua.getContentPane().setLayout(new BorderLayout());
        conectar = base;
        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(8, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");

        nombre = new JLabel(" NOMBRE ");
        mision = new JLabel(" MISION ");
        vision = new JLabel(" VISION ");
        objetivos = new JLabel(" OBJETIVOS ");
        codlinea = new JLabel(" CODIGO_GRUPO  ");
        codinv = new JLabel(" CODIGO_PROYECTO  ");
        muni = new JLabel(" MUNICIPIO  ");
        nomlinv = new JLabel(" LINEA_INVESTIGACION  ");

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
        nombret = new JTextField(10);
        misiont = new JTextArea(40, 20);
        visiont = new JTextArea(40, 20);
        objetivost = new JTextArea(40, 20);
        codlineat = new JTextField(10);
        codinvt = new JTextField(10);
        nomlinvt = new JTextField(20);


        datos.add(nombre);
        datos.add(nombret);
        datos.add(mision);
        datos.add(misiont);
        datos.add(vision);
        datos.add(visiont);
        datos.add(objetivos);
        datos.add(objetivost);
        datos.add(codlinea);
        datos.add(codlineat);
        datos.add(codinv);
        datos.add(codinvt);
        datos.add(muni);
        datos.add(municipio);
        datos.add(nomlinv);
        datos.add(nomlinvt);
        usua.add(datos, BorderLayout.CENTER);



        boton.add(guardar);
        boton.add(cancelar);
        usua.add(boton, BorderLayout.SOUTH);


        usua.pack();
        usua.setVisible(true);
        usua.setSize(400, 300);



        ManejadorBoton manejador = new ManejadorBoton();
        guardar.addActionListener(manejador);
        cancelar.addActionListener(manejador);

    }

    private class ManejadorBoton implements ActionListener {
        // manejar evento de botón

        public void actionPerformed(ActionEvent evento) {
            cual = evento.getActionCommand();
            if (cual.equals("INGRESAR")) {
                int codL = Integer.parseInt(codlineat.getText());
                int codI = Integer.parseInt(codinvt.getText());
                munit.setText(String.valueOf(municipio.getSelectedItem()));

                String sql;

                sql = "INSERT INTO PROYECTO VALUES('" + codinv.getText()
                        + "','" + codlineat.getText()  + "','" + misiont.getText()
                        + "','" + visiont.getText() + "','" + objetivost.getText()
                        + "','" + nombret.getText() + "','" + munit.getText()
                        + "','" + nomlinvt.getText() + "')";
                conectar.executeUpdateStatement(sql);

            } else if (cual.equals("LIMPIAR")) {
                Limpiar();
            }
        }
    }

    public void Limpiar() {
        misiont.setText("");
        visiont.setText("");
        objetivost.setText("");
        nombret.setText("");
        codlineat.setText("");
        codinvt.setText("");
    }
}
