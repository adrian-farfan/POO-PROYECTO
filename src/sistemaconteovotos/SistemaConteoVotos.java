package sistemaconteovotos;
import Paquete_Semana_15_ProyectoGrupal.SistemaElectoral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SistemaConteoVotos extends JFrame {
private SistemaElectoral sistemaElectoral = new SistemaElectoral();

    public SistemaConteoVotos() {
        setTitle("Sistema de Conteo de Votos");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        
        JMenuBar menuBar = new JMenuBar();

        JMenu menuElecciones = new JMenu("Elecciones");
        
        
        JMenuItem itemRegistrarEleccion = new JMenuItem("Registrar elección");

        
        itemRegistrarEleccion.addActionListener(e -> {
        new VentanaElecciones(sistemaElectoral).setVisible(true); 
        });

        
        menuElecciones.add(itemRegistrarEleccion);

        
        JMenu menuCandidatos = new JMenu("Candidatos");
        
        JMenuItem itemRegistrarCandidato = new JMenuItem("Registrar candidato");
        itemRegistrarCandidato.addActionListener(e -> {
        new VentanaCandidatos(sistemaElectoral).setVisible(true);
        });
        menuCandidatos.add(itemRegistrarCandidato);

        JMenu menuActas = new JMenu("Actas");
        
        JMenuItem itemRegistrarActa = new JMenuItem("Registrar acta");
        itemRegistrarActa.addActionListener(e -> {
        new VentanaActas(sistemaElectoral).setVisible(true);
        });
        menuActas.add(itemRegistrarActa);

        
        JMenu menuMesas = new JMenu("Mesas");
        
        JMenuItem itemRegistrarMesa = new JMenuItem("Registrar mesa");
        itemRegistrarMesa.addActionListener(e -> {
        new VentanaMesas(sistemaElectoral).setVisible(true);
        });
        menuMesas.add(itemRegistrarMesa);

        
        JMenu menuResultados = new JMenu("Resultados");
        JMenuItem itemVerResumen = new JMenuItem("Ver resumen");
itemVerResumen.addActionListener(e -> {
    new VentanaResumen(sistemaElectoral).setVisible(true);
});
menuResultados.add(itemVerResumen);

JMenuItem itemVotar = new JMenuItem("Registrar voto");
itemVotar.addActionListener(e -> {
    new VentanaVotacion(sistemaElectoral).setVisible(true);
});
menuResultados.add(itemVotar);

        JMenu menuPartidos = new JMenu("Partidos");
        
        JMenuItem itemRegistrarPartido = new JMenuItem("Registrar partido");
        itemRegistrarPartido.addActionListener(e -> {
        new VentanaPartidos(sistemaElectoral).setVisible(true);
        });
        menuPartidos.add(itemRegistrarPartido);


        menuBar.add(menuElecciones);
        menuBar.add(menuCandidatos);
        menuBar.add(menuActas);
        menuBar.add(menuMesas);
        menuBar.add(menuResultados);
        menuBar.add(menuPartidos);

        setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Bienvenido al sistema de conteo de votos"));
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SistemaConteoVotos().setVisible(true);
        });
    }
}
    
