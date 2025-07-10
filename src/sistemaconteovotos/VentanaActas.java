package sistemaconteovotos;
import Paquete_Semana_15_ProyectoGrupal.SistemaElectoral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VentanaActas extends JFrame {
    private SistemaElectoral sistema;

    public VentanaActas(SistemaElectoral sistema) {
        setTitle("Registro de Acta Electoral");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 5, 5));

        
        JTextField txtTitulo = new JTextField();
        JTextField txtFecha = new JTextField();
        JTextField txtHora = new JTextField();
        JTextField txtLugar = new JTextField();
        JComboBox<String> comboMesas = new JComboBox<>();
for (int i = 0; i < sistema.getPunteroMesas(); i++) {
    comboMesas.addItem(i + ": " + sistema.getMesas()[i].presentarInforme());
}

        JTextField txtMiembros = new JTextField();
        JTextField txtTotalVotantes = new JTextField();
        JTextField txtVotosValidos = new JTextField();
        JTextField txtBlancoNulos = new JTextField();
        JTextArea txtObservaciones = new JTextArea(3, 20);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        
        add(new JLabel("Título del Acta:")); add(txtTitulo);
        add(new JLabel("Fecha:")); add(txtFecha);
        add(new JLabel("Hora:")); add(txtHora);
        add(new JLabel("Lugar:")); add(txtLugar);
        add(new JLabel("Selecciona Mesa:")); add(comboMesas);

        add(new JLabel("Miembros de Mesa:")); add(txtMiembros);
        add(new JLabel("Votantes Registrados:")); add(txtTotalVotantes);
        add(new JLabel("Votos Válidos:")); add(txtVotosValidos);
        add(new JLabel("Votos en Blanco/Nulos:")); add(txtBlancoNulos);
        add(new JLabel("Observaciones:")); add(new JScrollPane(txtObservaciones));
        add(btnGuardar); add(btnCancelar);

        
        btnGuardar.addActionListener(e -> {
    String titulo = txtTitulo.getText();
    String fecha = txtFecha.getText();
    String hora = txtHora.getText();
    String lugar = txtLugar.getText();
    String observaciones = txtObservaciones.getText();
    String sello = "Sello digital"; 
    String[] firmas = {"Firma1", "Firma2"}; 
    int numeroActa = (int)(Math.random() * 1000); 

    try {
        int mesaIndex = comboMesas.getSelectedIndex();

        int votantes = Integer.parseInt(txtTotalVotantes.getText());

        sistema.crearActaDesdeGUI(
            titulo, fecha, hora, lugar, observaciones, sello,
            mesaIndex, firmas, votantes, numeroActa
        );

        JOptionPane.showMessageDialog(this, "✅ Acta registrada desde la GUI correctamente.");
        dispose(); // Cierra la ventana
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "❌ Campos numéricos inválidos.");
    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, "❌ " + ex.getMessage());
    }
});


        
        btnCancelar.addActionListener(e -> dispose());
    }
}
