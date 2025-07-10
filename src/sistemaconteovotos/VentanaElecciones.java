package sistemaconteovotos;

import Paquete_Semana_15_ProyectoGrupal.SistemaElectoral;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaElecciones extends JFrame {
private SistemaElectoral sistema;


    public VentanaElecciones(SistemaElectoral sistema) {
    this.sistema = sistema;

        setTitle("Gestión de Elecciones");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        
        JLabel lblFecha = new JLabel("Fecha:");
        JTextField txtFecha = new JTextField();

        JLabel lblTipo = new JLabel("Tipo de elección:");
        String[] tipos = {"Municipal", "Nacional", "Referéndum"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);

        JLabel lblDescripcion = new JLabel("Descripción:");
        JTextField txtDescripcion = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        
        btnGuardar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String fecha = txtFecha.getText();
        String tipo = comboTipo.getSelectedItem().toString();
        String descripcion = txtDescripcion.getText();

        
        sistema.crearEleccion(tipo, fecha);

        JOptionPane.showMessageDialog(null, "Elección guardada correctamente.");
        dispose(); 
    }
});

        
        JButton btnCancelar = new JButton("Cancelar");

        
        add(lblFecha); add(txtFecha);
        add(lblTipo); add(comboTipo);
        add(lblDescripcion); add(txtDescripcion);
        add(new JLabel()); add(new JLabel()); 
        add(btnGuardar); add(btnCancelar);

        
        btnGuardar.addActionListener(e -> {
            String fecha = txtFecha.getText();
            String tipo = (String) comboTipo.getSelectedItem();
            String descripcion = txtDescripcion.getText();

            JOptionPane.showMessageDialog(this, "Elección guardada:\n" +
                "Fecha: " + fecha + "\nTipo: " + tipo + "\nDescripción: " + descripcion);
        });

        
        btnCancelar.addActionListener(e -> dispose());
    }
}

