/* MNTE
 * ProgramaUsuario.java
 *
 * @author vGus
 * @version 1.00 2009/06/27
 */

import BD.IngresoBD;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Fisico.*;

public class ProgramaUsuario extends JFrame {

    private JMenuItem MostrarProyec,  InsertarProyec,  ModificarProyec,  MostrarEmple,  InsertarEmple,  ModificarEmple,  MostrarGrupo,  InsertarGrupo,  ModificarGrupo,  MostrarEmpre,  InsertarEmpre,  ModificarEmpre,  Eliminar,  Salir,  MostrarMuni,  InsertarMuni,  ModificarMuni,  MostrarEst,  InsertarEst,  ModificarEst,  Busqueda;
    private JPanel iconos,  iconos2,  imagenes,  presentacion;
    private JLabel tipaut,  dir,  fotho;
    private IngresoBD conectar;
    Image imagen;

    public ProgramaUsuario(IngresoBD base) {
        JFrame aut = new JFrame(" PROYECTO POO ");
        aut.getContentPane().setLayout(new BorderLayout());
        iconos2 = new JPanel();
        imagenes = new JPanel();
        presentacion = new JPanel();
        conectar =  base;

        iconos2.setLayout(new FlowLayout());
        imagenes.setLayout(new GridLayout(1, 1));
//adicionando


        dir = new JLabel("PROYECTO ");
        presentacion.add(dir);

// establecer el menú General
        JMenuBar barraMenus = new JMenuBar();
        JMenuBar barraMenus1 = new JMenuBar();


//MENU MUNICIPIO
        JMenu menuMuni = new JMenu("Municipio");
        menuMuni.setMnemonic('M');
        barraMenus.add(menuMuni);
        InsertarMuni = new JMenuItem("Insertar Municipio");
        InsertarMuni.setEnabled(true);
        InsertarMuni.setMnemonic('I');
        ModificarMuni = new JMenuItem("Modificar Municipio");
        ModificarMuni.setMnemonic('M');
        MostrarMuni = new JMenuItem("Mostrar Municipio");
        MostrarMuni.setMnemonic('M');
        menuMuni.add(InsertarMuni);
        menuMuni.add(ModificarMuni);
        menuMuni.add(MostrarMuni);
        iconos2.add(barraMenus);

//MENU Empresa
        JMenu menuEmpre = new JMenu("Empresa");
        menuEmpre.setMnemonic('E');
        barraMenus.add(menuEmpre);
        InsertarEmpre = new JMenuItem("Insertar Empresa");
        InsertarEmpre.setEnabled(true);
        InsertarEmpre.setMnemonic('I');
        ModificarEmpre = new JMenuItem("Modificar Empresa");
        ModificarEmpre.setMnemonic('M');
        MostrarEmpre = new JMenuItem("Mostrar Empresa");
        MostrarEmpre.setMnemonic('M');
        menuEmpre.add(InsertarEmpre);
        menuEmpre.add(ModificarEmpre);
        menuEmpre.add(MostrarEmpre);
        iconos2.add(barraMenus);

//MENU grupo
        JMenu menuGrupo = new JMenu("Grupo");
        menuGrupo.setMnemonic('G');
        barraMenus.add(menuGrupo);
        InsertarGrupo = new JMenuItem("Insertar Grupo");
        InsertarGrupo.setEnabled(true);
        InsertarGrupo.setMnemonic('I');
        ModificarGrupo = new JMenuItem("Modificar Grupo");
        ModificarGrupo.setMnemonic('M');
        MostrarGrupo = new JMenuItem("Mostrar Grupo");
        MostrarGrupo.setMnemonic('M');
        menuGrupo.add(InsertarGrupo);
        menuGrupo.add(ModificarGrupo);
        menuGrupo.add(MostrarGrupo);
        iconos2.add(barraMenus);

//MENU Investigacion
        JMenu menuProyec = new JMenu("Proyecto");
        menuProyec.setMnemonic('P');
        barraMenus.add(menuProyec);
        InsertarProyec = new JMenuItem("Insertar Proyecto");
        InsertarProyec.setEnabled(true);
        InsertarProyec.setMnemonic('I');
        ModificarProyec = new JMenuItem("Modificar Proyecto");
        ModificarProyec.setMnemonic('M');
        MostrarProyec = new JMenuItem("Mostrar Proyecto");
        MostrarProyec.setMnemonic('M');
        menuProyec.add(InsertarProyec);
        menuProyec.add(ModificarProyec);
        menuProyec.add(MostrarProyec);
        iconos2.add(barraMenus);

//MENU Empleado
        JMenu menuEmple = new JMenu("Empleado");
        menuEmple.setMnemonic('E');
        barraMenus.add(menuEmple);
        InsertarEmple = new JMenuItem("Insertar Empleado");
        InsertarEmple.setEnabled(true);
        InsertarEmple.setMnemonic('I');
        ModificarEmple = new JMenuItem("Modificar Empleado");
        ModificarEmple.setMnemonic('M');
        MostrarEmple = new JMenuItem("Mostrar Empleado");
        MostrarEmple.setMnemonic('M');
        menuEmple.add(InsertarEmple);
        menuEmple.add(ModificarEmple);
        menuEmple.add(MostrarEmple);
        iconos2.add(barraMenus);


//MENU Estudios
        JMenu menuEst = new JMenu("Estudios");
        menuEst.setMnemonic('E');
        barraMenus.add(menuEst);
        InsertarEst = new JMenuItem("Insertar Estudios");
        InsertarEst.setEnabled(true);
        InsertarEst.setMnemonic('I');
        ModificarEst = new JMenuItem("Modificar Estudios");
        ModificarEst.setMnemonic('M');
        MostrarEst = new JMenuItem("Mostrar Estudios");
        MostrarEst.setMnemonic('M');
        menuEst.add(InsertarEst);
        menuEst.add(ModificarEst);
        menuEst.add(MostrarEst);
        iconos2.add(barraMenus);

//MENU SALIR
        JMenu menuOpciones = new JMenu("OPCIONES");
        barraMenus.add(menuOpciones);
        menuOpciones.setMnemonic('O');
        Salir = new JMenuItem("Salir");
        Salir.setMnemonic('S');
        Eliminar = new JMenuItem("Eliminar");
        Eliminar.setMnemonic('E');
        Busqueda = new JMenuItem("Busqueda");
        Busqueda.setMnemonic('B');

        JMenuItem elementoAcerca = new JMenuItem("REALIZADO POR");
        elementoAcerca.setMnemonic('A');
        menuOpciones.add(elementoAcerca);
        menuOpciones.add(Eliminar);
        menuOpciones.add(Busqueda);
        menuOpciones.add(Salir);
        iconos2.add(barraMenus);





//ACTIONLISTENER Empleado
        InsertarEmple.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        ModificarEmple.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        MostrarEmple.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        MostrarEmpleado us = new MostrarEmpleado(conectar);
                    }
                });


//ACTIONLISTENER Grupo
        InsertarGrupo.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        ModificarEmpre.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        MostrarEmpre.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        MostraEmpresa us = new MostraEmpresa(conectar);
                    }
                });

//ACTIONLISTENER Proyecto
        InsertarProyec.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        ModificarProyec.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        MostrarProyec.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        MostrarProyecto us = new MostrarProyecto(conectar);
                    }
                });

//ACTIONLISTENER Estudios
        InsertarEst.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        ModificarEst.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        MostrarEst.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        MostrarEstudios us = new MostrarEstudios(conectar);
                    }
                });

//ACTIONLISTENER Grupo
        InsertarGrupo.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        ModificarGrupo.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        MostrarGrupo.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        MostrarGrup as = new MostrarGrup(conectar);
                    }
                });

//ACTIONLISTENER Municio
        InsertarMuni.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        ModificarMuni.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });


        MostrarMuni.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        MostrarMunicipio us = new MostrarMunicipio(conectar);
                    }
                });

        Salir.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR ESTE PROGRAMA");
                        System.exit(0);
                    }
                });

        elementoAcerca.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        JOptionPane.showMessageDialog(null, "Desarrollado por:\nViejo Gus 2009A\nUNIVERSIDAD DE IBAGUE");

                    }
                });

        Eliminar.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                    }
                });

        Busqueda.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        Buscar bus = new Buscar(conectar);
                    }
                });

        ImageIcon img = new ImageIcon("C:\\imagen.jpg");
        fotho = new JLabel(img);
        imagenes.add(fotho);
        aut.add(presentacion, BorderLayout.SOUTH);
        aut.add(imagenes, BorderLayout.CENTER);
        aut.add(iconos2, BorderLayout.NORTH);
        aut.pack();
        aut.setVisible(true);
//aut.setSize(900,500);


    }
}
