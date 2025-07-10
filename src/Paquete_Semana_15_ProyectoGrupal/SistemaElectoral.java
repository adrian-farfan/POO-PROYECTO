/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete_Semana_15_ProyectoGrupal;

/**
 *
 * @author mac
 */
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Scanner;

public class SistemaElectoral {
    private Scanner scanner = new Scanner(System.in);

    private Eleccion[] elecciones = new Eleccion[20];
    private int punteroElecciones = 0;

    private Candidato[] candidatos = new Candidato[40];
    private int punteroCandidatos = 0;

    private PartidoPolitico[] partidos = new PartidoPolitico[20];
    private int punteroPartidos = 0;

    private ActaElectoral[] actas = new ActaElectoral[50];
    private int punteroActas = 0;

    private MesaElectoral[] mesas = new MesaElectoral[20];
    private int punteroMesas = 0;

    private MiembroMesa[] miembros = new MiembroMesa[60];
    private int punteroMiembros = 0;
    
    
    public void crearEleccion(String tipo, String fecha) {
    if (punteroElecciones < elecciones.length) {
        elecciones[punteroElecciones++] = new Eleccion(fecha, tipo);
        System.out.println("Elección creada desde GUI correctamente.");
    } else {
        System.out.println("No se puede crear más elecciones, límite alcanzado.");
    }
}

    
    public void iniciar() {
        if (login()) {
            menuPrincipal();
        } else {
            System.out.println("Acceso denegado.");
        }
    }

    public boolean login() {
        System.out.println("=== INICIO DE SESIÓN ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String clave = scanner.nextLine();

        return usuario.equals("user") && clave.equals("pass");
    }

    public void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar elecciones");
            System.out.println("2. Gestionar candidatos");
            System.out.println("3. Gestionar partidos");
            System.out.println("4. Gestionar actas");
            System.out.println("5. Gestionar mesas");
            System.out.println("6. Gestionar miembros de mesa");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> gestionarElecciones();
                case 2 -> gestionarCandidatos();
                case 3 -> gestionarPartidos();
                case 4 -> gestionarActas();
                case 5 -> gestionarMesas();
                case 6 -> gestionarMiembros();
                case 7 -> System.out.println("Cerrando sesión...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }

    public void gestionarElecciones() {
        System.out.println("-- Crear Elección --");
        crearEleccion();
        listarElecciones();
    }

    public void crearEleccion() {
        if (punteroElecciones < elecciones.length) {
            System.out.print("Fecha: ");
            String fecha = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();
            elecciones[punteroElecciones++] = new Eleccion(fecha, tipo);
            System.out.println("Elección creada exitosamente.");
        }
    }

    public void listarElecciones() {
        for (int i = 0; i < punteroElecciones; i++) {
            System.out.println(i + ". " + elecciones[i].presentarInforme());
        }
    }

    public void gestionarCandidatos() {
        System.out.println("-- Crear Candidato --");
        crearCandidato();
        listarCandidatos();
    }

    public void crearCandidato() {
        if (punteroCandidatos < candidatos.length) {
            System.out.print("Nombres: ");
            String nombres = scanner.nextLine();

            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();

            System.out.print("DNI: ");
            int dni = scanner.nextInt(); scanner.nextLine();

            System.out.print("Votos preferenciales: ");
            int votosPreferenciales = scanner.nextInt(); scanner.nextLine();

            listarPartidos();
            System.out.print("Seleccione índice del partido: ");
            int indice = scanner.nextInt(); scanner.nextLine();
            PartidoPolitico partido = partidos[indice];

            candidatos[punteroCandidatos++] = new Candidato(
                dni, votosPreferenciales, partido, nombres, apellidos
            );

            System.out.println("✅ Candidato registrado exitosamente.");
        }
    }

    public void listarCandidatos() {
        for (int i = 0; i < punteroCandidatos; i++) {
            System.out.println(i + ". " + candidatos[i].presentarInforme());
        }
    }

    public void gestionarPartidos() {
        System.out.println("-- Crear Partido --");
        crearPartido();
        listarPartidos();
    }

    public void crearPartido() {
        if (punteroPartidos < partidos.length) {
            System.out.print("Nombre del partido: ");
            String nombre = scanner.nextLine();

            System.out.print("Siglas: ");
            String siglas = scanner.nextLine();

            System.out.print("Logo (URL o nombre del archivo): ");
            String logo = scanner.nextLine();

            System.out.print("Nombre del representante: ");
            String representante = scanner.nextLine();

            partidos[punteroPartidos++] = new PartidoPolitico(nombre, siglas, logo, representante);
            System.out.println("✅ Partido registrado exitosamente.");
        } else {
            System.out.println("❌ No se pueden registrar más partidos.");
        }
    }
public void crearPartido(String nombre, String siglas, String logo, String representante) {
    if (punteroPartidos < partidos.length) {
        partidos[punteroPartidos++] = new PartidoPolitico(nombre, siglas, logo, representante);
        System.out.println("✅ Partido registrado desde GUI correctamente.");
    } else {
        System.out.println("❌ No se pueden registrar más partidos.");
    }
}

    public void listarPartidos() {
        for (int i = 0; i < punteroPartidos; i++) {
            System.out.println(i + ". " + partidos[i].verInfo());
        }
    }

    public void gestionarActas() {
        System.out.println("-- Crear Acta --");
        crearActa();
        listarActas();
    }

    public void crearActa() {
        if (punteroActas < actas.length) {
            System.out.print("Título del acta: ");
            String titulo = scanner.nextLine();

            System.out.print("Fecha: ");
            String fecha = scanner.nextLine();

            System.out.print("Hora: ");
            String hora = scanner.nextLine();

            System.out.print("Lugar: ");
            String lugar = scanner.nextLine();

            System.out.print("Observaciones: ");
            String observaciones = scanner.nextLine();

            System.out.print("Sello: ");
            String sello = scanner.nextLine();

            listarMesas();
            System.out.print("Seleccione índice de la mesa: ");
            int mesaIndex = scanner.nextInt(); scanner.nextLine();
            MesaElectoral mesa = mesas[mesaIndex];

            System.out.print("¿Cuántas firmas registrarás? ");
            int numFirmas = scanner.nextInt(); scanner.nextLine();
            String[] firmas = new String[numFirmas];
            for (int i = 0; i < numFirmas; i++) {
                System.out.print("Firma " + (i + 1) + ": ");
                firmas[i] = scanner.nextLine();
            }

            System.out.print("Votantes registrados: ");
            int votantesRegistrados = scanner.nextInt(); scanner.nextLine();

            System.out.print("Número de acta: ");
            int numeroActa = scanner.nextInt(); scanner.nextLine();

            listarElecciones();
            System.out.print("Seleccione índice de la elección: ");
            int eleccionIndex = scanner.nextInt(); scanner.nextLine();
            Eleccion eleccion = elecciones[eleccionIndex];

            ActaElectoral acta = new ActaElectoral(
                titulo, fecha, hora, lugar, observaciones, sello,
                mesa, firmas, votantesRegistrados, numeroActa, eleccion
            );

            actas[punteroActas++] = acta;
            System.out.println("✅ Acta registrada exitosamente.");
        }
    }

    public void listarActas() {
        for (int i = 0; i < punteroActas; i++) {
            System.out.println(i + ". " + actas[i].presentarInforme());
        }
    }

    public void gestionarMesas() {
        System.out.println("-- Crear Mesa --");
        crearMesa();
        listarMesas();
    }

    public void crearMesa() {
        if (punteroMesas < mesas.length) {
            MesaElectoral mesa = new MesaElectoral();
            mesas[punteroMesas++] = mesa;
            System.out.println("Mesa registrada exitosamente.");
        }
    }

    public void listarMesas() {
        for (int i = 0; i < punteroMesas; i++) {
            System.out.println(i + ". " + mesas[i].presentarInforme());
        }
    }
public void crearMiembro() {
    System.out.print("Nombres: ");
    String nombres = scanner.nextLine();
    System.out.print("Apellidos: ");
    String apellidos = scanner.nextLine();
    System.out.print("Tipo (Presidente, Secretario o Vocal): ");
    String tipo = scanner.nextLine();

    crearMiembro(nombres, apellidos, tipo); 
}

    public void gestionarMiembros() {
        System.out.println("-- Crear Miembro de Mesa --");
        crearMiembro();
        listarMiembros();
    }

        

    public void listarMiembros() {
        for (int i = 0; i < punteroMiembros; i++) {
            System.out.println(i + ". " + miembros[i].presentarInforme());
        }
    }
        public void crearCandidatoDesdeGUI(String nombres, String apellidos, int dni, String nombrePartido) {
        PartidoPolitico partidoEncontrado = null;
        for (int i = 0; i < punteroPartidos; i++) {
            if (partidos[i].getNombre().equalsIgnoreCase(nombrePartido)) {
                partidoEncontrado = partidos[i];
                break;
            }
        }

        if (partidoEncontrado == null) {
            throw new IllegalArgumentException("Partido no encontrado: " + nombrePartido);
        }

        if (punteroCandidatos < candidatos.length) {
            candidatos[punteroCandidatos++] = new Candidato(dni, 0, partidoEncontrado, nombres, apellidos);
            System.out.println("Candidato registrado desde la GUI correctamente.");
        } else {
            throw new IllegalStateException("No se pueden registrar más candidatos.");
        }
    }
public void crearActaDesdeGUI(
    String titulo, String fecha, String hora, String lugar,
    String observaciones, String sello, int mesaIndex,
    String[] firmas, int votantes, int numeroActa
) {
    if (punteroActas >= actas.length) {
        throw new IllegalArgumentException("Límite de actas alcanzado.");
    }

    if (mesaIndex < 0 || mesaIndex >= punteroMesas) {
        throw new IllegalArgumentException("Índice de mesa inválido.");
    }

    if (punteroElecciones == 0) {
        throw new IllegalArgumentException("Debe haber al menos una elección registrada.");
    }

    MesaElectoral mesa = mesas[mesaIndex];
    Eleccion eleccion = elecciones[punteroElecciones - 1]; // Usa la última elección registrada

    ActaElectoral acta = new ActaElectoral(
        titulo, fecha, hora, lugar, observaciones, sello,
        mesa, firmas, votantes, numeroActa, eleccion
    );

    actas[punteroActas++] = acta;
    System.out.println("✅ Acta registrada desde GUI correctamente.");
}
public void crearMiembro(String nombres, String apellidos, String tipo) {
    if (punteroMiembros < miembros.length) {
        MiembroMesa miembro = new MiembroMesa(nombres, apellidos, tipo);
        miembros[punteroMiembros++] = miembro;
        System.out.println("Miembro registrado desde GUI: " + nombres + " (" + tipo + ")");
    } else {
        System.out.println("❌ No se pueden registrar más miembros.");
    }
}
public void listarEleccionesGUI(StringBuilder sb) {
    for (int i = 0; i < punteroElecciones; i++) {
        sb.append((i + 1)).append(". ").append(elecciones[i].presentarInforme()).append("\n");
    }
}

public void listarPartidosGUI(StringBuilder sb) {
    for (int i = 0; i < punteroPartidos; i++) {
        sb.append((i + 1)).append(". ").append(partidos[i].verInfo()).append("\n");
    }
}

public void listarCandidatosGUI(StringBuilder sb) {
    for (int i = 0; i < punteroCandidatos; i++) {
        sb.append((i + 1)).append(". ").append(candidatos[i].presentarInforme()).append("\n");
    }
}

public void listarMesasGUI(StringBuilder sb) {
    for (int i = 0; i < punteroMesas; i++) {
        sb.append((i + 1)).append(". ").append(mesas[i].presentarInforme()).append("\n");
    }
}

public void listarActasGUI(StringBuilder sb) {
    for (int i = 0; i < punteroActas; i++) {
        sb.append((i + 1)).append(". ").append(actas[i].presentarInforme()).append("\n");
    }
}

public void listarMiembrosGUI(StringBuilder sb) {
    for (int i = 0; i < punteroMiembros; i++) {
        sb.append((i + 1)).append(". ").append(miembros[i].presentarInforme()).append("\n");
    }
}
public ActaElectoral getUltimaActa() {
    if (punteroActas > 0) {
        return actas[punteroActas - 1];
    } else {
        throw new IllegalStateException("No hay actas registradas.");
    }
}
public Candidato[] getCandidatos() {
    return candidatos;
}
public MesaElectoral[] getMesas() {
    return mesas;
}

public int getPunteroMesas() {
    return punteroMesas;
}

}
