package sistemaconteovotos;
import Paquete_Semana_15_ProyectoGrupal.SistemaElectoral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaCandidatos extends JFrame {

private SistemaElectoral sistema;
    
    public VentanaCandidatos(SistemaElectoral sistema) {
        this.sistema = sistema;
        setTitle("Registro de Candidatos");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        
        JLabel lblNombre = new JLabel("Nombres:");
        JTextField txtNombre = new JTextField();

        JLabel lblApellido = new JLabel("Apellidos:");
        JTextField txtApellido = new JTextField();

        JLabel lblDNI = new JLabel("DNI:");
        JTextField txtDNI = new JTextField();

        JLabel lblPartido = new JLabel("Partido Político:");
        JTextField txtPartido = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        
        add(lblNombre); add(txtNombre);
        add(lblApellido); add(txtApellido);
        add(lblDNI); add(txtDNI);
        add(lblPartido); add(txtPartido);
        add(new JLabel()); add(new JLabel()); 
        add(btnGuardar); add(btnCancelar);

        
       btnGuardar.addActionListener(e -> {
    String nombres = txtNombre.getText();
    String apellidos = txtApellido.getText();
    String dniStr = txtDNI.getText();
    String partido = txtPartido.getText();

    try {
        int dni = Integer.parseInt(dniStr);
        sistema.crearCandidatoDesdeGUI(nombres, apellidos, dni, partido);
        JOptionPane.showMessageDialog(this, "✅ Candidato registrado correctamente.");
        dispose(); // Cierra la ventana
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "❌ DNI inválido. Debe ser un número.");
    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, "❌ " + ex.getMessage());
    }
});

        
        btnCancelar.addActionListener(e -> dispose());
    }
}



