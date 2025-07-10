package Paquete_Semana_15_ProyectoGrupal;

public class ActaElectoral implements Interfaz {
    private String titulo, fecha, hora, lugar, observaciones, sello;
    private MesaElectoral identificacion;
    private String[] nombres, firmas;
    private int votantesRegistrados, votantesEfectivos, votosBlanco, votosNulos, numeroActa;
    private int[] resultados;
    private Eleccion eleccion;

    public ActaElectoral(String titulo, String fecha, String hora, String lugar, String observaciones, String sello, MesaElectoral identificacion, String[] firmas, int votantesRegistrados, int numeroActa, Eleccion eleccion) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.observaciones = observaciones;
        this.sello = sello;
        this.identificacion = identificacion;
        this.firmas = firmas;
        this.votantesRegistrados = votantesRegistrados;
        this.numeroActa = numeroActa;
        this.nombres = new String[identificacion.getPuntero()];
        for (int i = 0; i < identificacion.getPuntero(); i++) {
            this.nombres[i] = identificacion.getMiembros()[i].getNombres();
        }
        this.resultados = new int[eleccion.getPuntero()];
        this.eleccion = eleccion;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public String getSello() { return sello; }
    public void setSello(String sello) { this.sello = sello; }
    public MesaElectoral getIdentificacion() { return identificacion; }
    public void setIdentificacion(MesaElectoral identificacion) { this.identificacion = identificacion; }
    public String[] getNombres() { return nombres; }
    public void setNombres(String[] nombres) { this.nombres = nombres; }
    public String[] getFirmas() { return firmas; }
    public void setFirmas(String[] firmas) { this.firmas = firmas; }
    public int getVotantesRegistrados() { return votantesRegistrados; }
    public void setVotantesRegistrados(int votantesRegistrados) { this.votantesRegistrados = votantesRegistrados; }
    public int getVotantesEfectivos() { return votantesEfectivos; }
    public void setVotantesEfectivos(int votantesEfectivos) { this.votantesEfectivos = votantesEfectivos; }
    public int getVotosBlanco() { return votosBlanco; }
    public void setVotosBlanco(int votosBlanco) { this.votosBlanco = votosBlanco; }
    public int getVotosNulos() { return votosNulos; }
    public void setVotosNulos(int votosNulo) { this.votosNulos = votosNulo; }
    public int getNumeroActa() { return numeroActa; }
    public void setNumeroActa(int numeroActa) { this.numeroActa = numeroActa; }
    public int[] getResultados() { return resultados; }
    public void setResultados(int[] resultados) { this.resultados = resultados; }
    public Eleccion getEleccion() { return eleccion; }

    public void darVoto(Candidato candidato) {
        if (candidato == null) {
            System.out.println("❌ Error: candidato nulo.");
            return;
        }

        candidato.setVotosPreferenciales(candidato.getVotosPreferenciales() + 1);
        candidato.getPartido().setVotosTotales(candidato.getPartido().getVotosTotales() + 1);

        boolean encontrado = false;
        for (int i = 0; i < eleccion.getPuntero(); i++) {
            if (eleccion.getCandidatos()[i] == candidato) {
                resultados[i]++;
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("⚠️ Candidato no pertenece a esta elección.");
        }
    }

    public void darVotoBlanco() {
        votosBlanco++;
    }

    public void darVotoNulo() {
        votosNulos++;
    }

    public void modificarVotos(Candidato candidato, int nuevosVotos) {
        if (candidato == null || nuevosVotos < 0) {
            System.out.println("❌ Error: datos inválidos.");
            return;
        }

        for (int i = 0; i < eleccion.getPuntero(); i++) {
            if (eleccion.getCandidatos()[i] == candidato) {
                int votosAnteriores = resultados[i];
                resultados[i] = nuevosVotos;
                int diferencia = nuevosVotos - votosAnteriores;
                candidato.setVotosPreferenciales(candidato.getVotosPreferenciales() + diferencia);
                candidato.getPartido().setVotosTotales(candidato.getPartido().getVotosTotales() + diferencia);
                return;
            }
        }

        System.out.println("⚠️ Candidato no encontrado en la elección.");
    }

    public void calcularVotantesEfectivos() {
        int sumaVotos = votosBlanco + votosNulos;
        for (int r : resultados) sumaVotos += r;

        if (sumaVotos > votantesRegistrados) {
            System.out.println("❌ Error: total de votos supera a los registrados.");
            votantesEfectivos = -1;
        } else {
            votantesEfectivos = votantesRegistrados - votosBlanco - votosNulos;
        }
    }

    @Override
    public String presentarInforme() {
        String cad = "Titulo: " + titulo +
                "\nFecha: " + fecha +
                "\nHora: " + hora +
                "\nLugar: " + lugar +
                "\nObservaciones: " + observaciones +
                "\nSello: " + sello +
                "\nVotantes registrados: " + votantesRegistrados +
                "\nVotantes efectivos: " + votantesEfectivos +
                "\nVotos en blanco: " + votosBlanco +
                "\nVotos nulos: " + votosNulos +
                "\nNumero de acta: " + numeroActa +
                "\nResultados:";
        for (int i = 0; i < resultados.length; i++) {
            Candidato n = eleccion.getCandidatos()[i];
            cad += "\n" + n.getNombres() + " " + n.getApellidos() + " (" + n.getPartido().getSiglas() + "): " + resultados[i] + " votos";
        }
        return cad;
    }
}