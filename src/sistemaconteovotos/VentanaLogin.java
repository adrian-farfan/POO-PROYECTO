 package sistemaconteovotos;
import Paquete_Semana_15_ProyectoGrupal.SistemaElectoral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaLogin extends JFrame {

    public VentanaLogin() {
        setTitle("Inicio de Sesión");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        
        JLabel lblUsuario = new JLabel("Usuario:");
        JTextField txtUsuario = new JTextField();

        JLabel lblContrasena = new JLabel("Contraseña:");
        JPasswordField txtContrasena = new JPasswordField();

        JButton btnLogin = new JButton("Iniciar sesión");
        JButton btnSalir = new JButton("Salir");

        add(lblUsuario); add(txtUsuario);
        add(lblContrasena); add(txtContrasena);
        add(btnLogin); add(btnSalir);

        
        btnLogin.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String contrasena = new String(txtContrasena.getPassword());

            
            if (usuario.equals("admin") && contrasena.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Bienvenido, " + usuario);
                new SistemaConteoVotos().setVisible(true);
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        
        btnSalir.addActionListener(e -> System.exit(0));
    }
}
