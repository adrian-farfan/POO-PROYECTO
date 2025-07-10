package sistemaconteovotos;

import Paquete_Semana_15_ProyectoGrupal.SistemaElectoral;
import Paquete_Semana_15_ProyectoGrupal.Candidato;
import Paquete_Semana_15_ProyectoGrupal.ActaElectoral;

import javax.swing.*;
import java.awt.*;

public class VentanaVotacion extends JFrame {
    private SistemaElectoral sistema;

    public VentanaVotacion(SistemaElectoral sistema) {
        this.sistema = sistema;

        setTitle("Registrar Voto");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblInstruccion = new JLabel("Selecciona un candidato para registrar el voto:");
        JComboBox<String> comboCandidatos = new JComboBox<>();

        
        Candidato[] candidatos = sistema.getCandidatos();
        for (int i = 0; i < candidatos.length; i++) {
            if (candidatos[i] != null) {
                comboCandidatos.addItem(i + ": " + candidatos[i].getNombres() + " " + candidatos[i].getApellidos());
            }
        }

        JButton btnVotar = new JButton("Votar");
        JButton btnVotoBlanco = new JButton("Voto en Blanco");
        JButton btnVotoNulo = new JButton("Voto Nulo");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 5, 5));
        panelBotones.add(btnVotar);
        panelBotones.add(btnVotoBlanco);
        panelBotones.add(btnVotoNulo);
        panelBotones.add(btnCancelar);

        add(lblInstruccion, BorderLayout.NORTH);
        add(comboCandidatos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnVotar.addActionListener(e -> {
            try {
                int index = comboCandidatos.getSelectedIndex();
                if (index >= 0) {
                    ActaElectoral ultimaActa = sistema.getUltimaActa();
                    Candidato elegido = sistema.getCandidatos()[index];
                    ultimaActa.darVoto(elegido);
                    JOptionPane.showMessageDialog(this, "✅ Voto registrado para: " + elegido.getNombres());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "❌ Error al registrar voto: " + ex.getMessage());
            }
        });

        btnVotoBlanco.addActionListener(e -> {
            try {
                sistema.getUltimaActa().darVotoBlanco();
                JOptionPane.showMessageDialog(this, "✅ Voto en blanco registrado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "❌ Error: " + ex.getMessage());
            }
        });

        btnVotoNulo.addActionListener(e -> {
            try {
                sistema.getUltimaActa().darVotoNulo();
                JOptionPane.showMessageDialog(this, "✅ Voto nulo registrado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "❌ Error: " + ex.getMessage());
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }
}
