package sistemaconteovotos;
import Paquete_Semana_15_ProyectoGrupal.SistemaElectoral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaMesas extends JFrame {
private SistemaElectoral sistema;
    public VentanaMesas(SistemaElectoral sistema) {
        this.sistema = sistema;
        setTitle("Registro de Mesas y Miembros");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 5, 5));

        
        JLabel lblNumeroMesa = new JLabel("Número de Mesa:");
        JTextField txtNumeroMesa = new JTextField();

        JLabel lblPresidente = new JLabel("Presidente de Mesa:");
        JTextField txtPresidente = new JTextField();

        JLabel lblSecretario = new JLabel("Secretario de Mesa:");
        JTextField txtSecretario = new JTextField();

        JLabel lblVocal = new JLabel("Vocal de Mesa:");
        JTextField txtVocal = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        
        add(lblNumeroMesa); add(txtNumeroMesa);
        add(lblPresidente); add(txtPresidente);
        add(lblSecretario); add(txtSecretario);
        add(lblVocal); add(txtVocal);
        add(new JLabel()); add(new JLabel()); 
        add(btnGuardar); add(btnCancelar);

        
        btnGuardar.addActionListener(e -> {
    String presidente = txtPresidente.getText().trim();
    String secretario = txtSecretario.getText().trim();
    String vocal = txtVocal.getText().trim();

    if (presidente.isEmpty() || secretario.isEmpty() || vocal.isEmpty()) {
        JOptionPane.showMessageDialog(this, "❌ Todos los campos deben estar completos.");
        return;
    }

    sistema.crearMesa(); 
    sistema.crearMiembro(presidente, "", "Presidente");
    sistema.crearMiembro(secretario, "", "Secretario");
    sistema.crearMiembro(vocal, "", "Vocal");

    JOptionPane.showMessageDialog(this, "✅ Mesa y miembros registrados correctamente.");
    dispose();
});


        btnCancelar.addActionListener(e -> dispose());
    }
}
