package Laboratorio2;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class VentanaPrincipal extends JFrame {

    private JTextField campoNombre;
    private JTextField campoEmail;
    private JTextField campoTelefono;
    private JComboBox<String> comboTipoUsuario;
    private JCheckBox checkTerminos;

    public VentanaPrincipal() {
        setTitle("Formulario de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Esto ayuda a centrar la ventana

        //Este es el menú archivo
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");

        JMenuItem itemNuevo = new JMenuItem("Nuevo");
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemSalir = new JMenuItem("Salir");

        itemSalir.addActionListener(e -> System.exit(0));

        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemSalir);
        barraMenu.add(menuArchivo);
        setJMenuBar(barraMenu);

        //En este bloque está el formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(5, 2));

        JLabel labelNombre = new JLabel("Nombre:");
        JLabel labelEmail = new JLabel("Email:");
        JLabel labelTelefono = new JLabel("Teléfono:");
        JLabel labelTipoUsuario = new JLabel("Tipo de usuario:");

        campoNombre = new JTextField();
        campoEmail = new JTextField();
        campoTelefono = new JTextField();
        comboTipoUsuario = new JComboBox<>(new String[] {"Cliente", "Empleado", "Administrador"});
        checkTerminos = new JCheckBox("Acepto los términos y condiciones");

        panelFormulario.add(labelNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(labelEmail);
        panelFormulario.add(campoEmail);
        panelFormulario.add(labelTelefono);
        panelFormulario.add(campoTelefono);
        panelFormulario.add(labelTipoUsuario);
        panelFormulario.add(comboTipoUsuario);
        panelFormulario.add(new JLabel());
        panelFormulario.add(checkTerminos);

        //Aquí se encuentran los botones
        JButton botonGuardar = new JButton("Guardar");
        JButton botonLimpiar = new JButton("Limpiar");

        botonGuardar.addActionListener(e -> {
            if (!checkTerminos.isSelected()) {
                JOptionPane.showMessageDialog(this, "Debe aceptar los términos y condiciones antes de guardar.");
                return;
            }

            String nombre = campoNombre.getText();
            String email = campoEmail.getText();
            String telefono = campoTelefono.getText();
            String tipo = (String) comboTipoUsuario.getSelectedItem();

            try {
                FileWriter writer = new FileWriter("datos_usuario.txt");
                writer.write("Nombre: " + nombre + "\n");
                writer.write("Email: " + email + "\n");
                writer.write("Teléfono: " + telefono + "\n");
                writer.write("Tipo de usuario: " + tipo + "\n");
                writer.close();
                JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar los datos.");
            }
        });

        botonLimpiar.addActionListener(e -> {
            campoNombre.setText("");
            campoEmail.setText("");
            campoTelefono.setText("");
            comboTipoUsuario.setSelectedIndex(0);
            checkTerminos.setSelected(false);
        });

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(botonGuardar);
        panelBotones.add(botonLimpiar);

        //Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        add(panelPrincipal);

        //Aquí se cargan los datos del archivo
        cargarDatosDesdeArchivo();

        //Ajusta el tamaño y lo muestra
        pack(); 
        setVisible(true);
    }

    private void cargarDatosDesdeArchivo() {
        File archivo = new File("datos_usuario.txt");
        if (!archivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Nombre:")) {
                    campoNombre.setText(linea.substring(8).trim());
                } else if (linea.startsWith("Email:")) {
                    campoEmail.setText(linea.substring(7).trim());
                } else if (linea.startsWith("Teléfono:")) {
                    campoTelefono.setText(linea.substring(10).trim());
                } else if (linea.startsWith("Tipo de usuario:")) {
                    String tipo = linea.substring(17).trim();
                    comboTipoUsuario.setSelectedItem(tipo);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo.");
        }
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}


