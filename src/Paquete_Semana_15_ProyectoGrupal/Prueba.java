/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
package Paquete_Semana_15_ProyectoGrupal;

/**
 *
 * @author Administrador
 /*
public class Prueba {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DEL SISTEMA ELECTORAL ===\n");
        
        // 1. PARTIDOS POLÍTICOS
        PartidoPolitico partido1 = new PartidoPolitico("Partido Democratico", "PD", "logo_pd.png", "Juan Perez");
        PartidoPolitico partido2 = new PartidoPolitico("Partido Nacional", "PN", "logo_pn.png", "Maria Garcia");

        // 2. CANDIDATOS
        Candidato candidato1 = new Candidato("Ana", "Rodriguez", 12345678, partido1);
        Candidato candidato2 = new Candidato("Pedro", "Martinez", 87654321, partido2);
        Candidato candidato3 = new Candidato("Lucia", "Fernandez", 11223344, partido1);

        // 3. ELECCIÓN
        Eleccion eleccion = new Eleccion("2024-11-15", "municipal");
        eleccion.agregarCandidato(candidato1);
        eleccion.agregarCandidato(candidato2);
        eleccion.agregarCandidato(candidato3);

        // ==== PRIMERA MESA ====
        MesaElectoral mesa1 = new MesaElectoral();
        mesa1.agregarMiembro(new MiembroMesa("Roberto", "Silva", "presidente"));
        mesa1.agregarMiembro(new MiembroMesa("Carmen", "Vega", "secretario"));
        mesa1.agregarMiembro(new MiembroMesa("Diego", "Morales", "vocal"));

        String[] firmas1 = {"Firma_Roberto", "Firma_Carmen", "Firma_Diego"};
        ActaElectoral acta1 = new ActaElectoral(
            "Acta Mesa 001",
            "2024-11-15",
            "18:00",
            "Escuela Nacional Lima",
            "Sin incidentes",
            "SELLO_001",
            mesa1,
            firmas1,
            150,
            1001,
            eleccion
        );

        // Simular votos en acta 1
        acta1.darVoto(candidato1);
        acta1.darVoto(candidato1);
        acta1.darVoto(candidato2);
        acta1.darVoto(candidato3);
        acta1.darVotoBlanco();
        acta1.darVotoNulo();
        acta1.calcularVotantesEfectivos();

        // ==== SEGUNDA MESA ====
        MesaElectoral mesa2 = new MesaElectoral();
        mesa2.agregarMiembro(new MiembroMesa("Sofia", "Castro", "presidente"));
        mesa2.agregarMiembro(new MiembroMesa("Luis", "Ramirez", "secretario"));
        mesa2.agregarMiembro(new MiembroMesa("Valeria", "Gutierrez", "vocal"));

        String[] firmas2 = {"Firma_Sofia", "Firma_Luis", "Firma_Valeria"};
        ActaElectoral acta2 = new ActaElectoral(
            "Acta Mesa 002",
            "2024-11-15",
            "19:00",
            "Colegio San Martin",
            "Luz se fue por 10 minutos",
            "SELLO_002",
            mesa2,
            firmas2,
            180,
            1002,
            eleccion
        );

        // Simular votos en acta 2
        acta2.darVoto(candidato1);
        acta2.darVoto(candidato2);
        acta2.darVoto(candidato2);
        acta2.darVoto(candidato3);
        acta2.darVoto(candidato3);
        acta2.darVotoBlanco();
        acta2.darVotoNulo();
        acta2.calcularVotantesEfectivos();

        // ==== MOSTRAR RESULTADOS DE CADA ACTA ====
        System.out.println("=== RESULTADOS ACTA 1 ===");
        System.out.println(acta1.verInfo());
        System.out.println();

        System.out.println("=== RESULTADOS ACTA 2 ===");
        System.out.println(acta2.verInfo());
        System.out.println();

        // ==== MOSTRAR RESULTADOS CONSOLIDADOS ====
        System.out.println("=== RESULTADOS CONSOLIDADOS ===");
        System.out.println(eleccion.verInfo());
    }
}
*/