
import BD.IngresoBD;
import Fisico.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ingreso {

    private String cual;
    private JPanel datos,  boton;
    private JButton guardar,  cancelar;
    private JLabel user,  contra;
    private JPasswordField contrat;
    private JTextField usert;
    private IngresoBD base;
    JFrame ing = new JFrame("INGRESO DE USUARIO");

    public Ingreso() {
        base = new IngresoBD();

        ing.getContentPane().setLayout(new BorderLayout());

        boton = new JPanel();
        datos = new JPanel();
        datos.setLayout(new GridLayout(2, 2));//filas, columnas
        boton.setLayout(new FlowLayout());

        guardar = new JButton("INGRESAR");
        cancelar = new JButton("LIMPIAR");

        user = new JLabel("LOGIN");
        contra = new JLabel("PASSWORD");


        usert = new JTextField(10);
        contrat = new JPasswordField(10);



        datos.add(user);
        datos.add(usert);
        datos.add(contra);
        datos.add(contrat);
        ing.add(datos, BorderLayout.CENTER);



        boton.add(guardar);
        boton.add(cancelar);
        ing.add(boton, BorderLayout.SOUTH);


        ing.pack();
        ing.setVisible(true);

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
            if (cual.equals("INGRESAR")) {
                String cadena = new String(contrat.getPassword());
                String cadena3 = new String(usert.getText());
                if (cadena.equals("poo") && cadena3.equals("proyecto")) {
                    ing.setVisible(false);
                    ProgramaPrincipal me = new ProgramaPrincipal(base);

                } else if (cadena.equals("userpoo") && cadena3.equals("proyecto")) {
                    ing.setVisible(false);
                    ProgramaUsuario me = new ProgramaUsuario(base);

                } else {
                    Limpiar();
                }

            }
        }
    }

    public void Limpiar() {
        usert.setText("");
        contrat.setText("");
    }
}
