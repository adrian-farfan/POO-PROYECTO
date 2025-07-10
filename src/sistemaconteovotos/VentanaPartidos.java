package sistemaconteovotos;
import Paquete_Semana_15_ProyectoGrupal.SistemaElectoral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaPartidos extends JFrame {
private SistemaElectoral sistema;

    public VentanaPartidos(SistemaElectoral sistema) {
        this.sistema = sistema;
        setTitle("Registro de Partidos Políticos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 5, 5));

        
        JLabel lblNombre = new JLabel("Nombre del Partido:");
        JTextField txtNombre = new JTextField();

        JLabel lblSigla = new JLabel("Sigla:");
        JTextField txtSigla = new JTextField();

        JLabel lblSimbolo = new JLabel("Símbolo / Logo:");
        JTextField txtSimbolo = new JTextField();

        JLabel lblRepresentante = new JLabel("Representante Legal:");
        JTextField txtRepresentante = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        
        add(lblNombre); add(txtNombre);
        add(lblSigla); add(txtSigla);
        add(lblSimbolo); add(txtSimbolo);
        add(lblRepresentante); add(txtRepresentante);
        add(btnGuardar); add(btnCancelar);

        
      btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
String siglas = txtSigla.getText().trim(); 
String logo = txtSimbolo.getText().trim(); 
String representante = txtRepresentante.getText().trim();


            try {
                sistema.crearPartido(nombre, siglas, logo, representante);
                JOptionPane.showMessageDialog(this, "✅ Partido registrado correctamente.");
                dispose();
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(this, "❌ " + ex.getMessage());
            }
        });



        
        btnCancelar.addActionListener(e -> dispose());
    }
}
