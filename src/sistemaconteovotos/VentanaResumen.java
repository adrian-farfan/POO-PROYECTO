
package sistemaconteovotos;

import Paquete_Semana_15_ProyectoGrupal.SistemaElectoral;

import javax.swing.*;
import java.awt.*;

public class VentanaResumen extends JFrame {
    public VentanaResumen(SistemaElectoral sistema) {
        setTitle("Resumen de Datos Registrados");
        setSize(700, 500);
        setLocationRelativeTo(null);

        JTextArea areaResumen = new JTextArea();
        areaResumen.setEditable(false);

        StringBuilder sb = new StringBuilder();

        sb.append("=== ELECCIONES ===\n");
        sistema.listarEleccionesGUI(sb);
        sb.append("\n=== PARTIDOS POLÍTICOS ===\n");
        sistema.listarPartidosGUI(sb);
        sb.append("\n=== CANDIDATOS ===\n");
        sistema.listarCandidatosGUI(sb);
        sb.append("\n=== MESAS ELECTORALES ===\n");
        sistema.listarMesasGUI(sb);
        sb.append("\n=== ACTAS ELECTORALES ===\n");
        sistema.listarActasGUI(sb);
        sb.append("\n=== MIEMBROS DE MESA ===\n");
        sistema.listarMiembrosGUI(sb);

        areaResumen.setText(sb.toString());

        JScrollPane scroll = new JScrollPane(areaResumen);
        add(scroll, BorderLayout.CENTER);
    }
}
