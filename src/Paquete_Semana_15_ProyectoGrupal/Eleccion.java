/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete_Semana_15_ProyectoGrupal;

/**
 *
 * @author Administrador
 */
public class Eleccion implements Interfaz
{
    private String fecha, tipo;
    private Candidato[] candidatos;
    private int puntero;

    public Eleccion(String fecha, String tipo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.candidatos = new Candidato[40];
        this.puntero = 0;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Candidato[] getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(Candidato[] candidatos) {
        this.candidatos = candidatos;
    }

    public int getPuntero() {
        return puntero;
    }

    public void setPuntero(int puntero) {
        this.puntero = puntero;
    }
    
    public void agregarCandidato(Candidato candidato) {
        if (puntero < candidatos.length) {
            candidatos[puntero] = candidato;
            puntero++;
        }
        else {
            System.out.println("No hay más espacio en estas elecciones.");
        }
    }
    
    public void eliminarCandidato(Candidato candidato) {
        boolean noEncontrado = true;
        for (int i = 0; i < puntero; i++) {
            if (candidatos[i] == candidato) {
                for (int j = i; j < puntero - 1; j++) {
                    candidatos[j] = candidatos[j+1];
                }
                candidatos[puntero-1] = null;
                puntero--;
                noEncontrado = false;
            }
        }
        if (noEncontrado) {
            System.out.println("Candidato no encontrado.");
        }
    }

    @Override
    public String presentarInforme() {
        String cad = "Fecha: " + fecha +
                "\nTipo: " + tipo +
                "\nResultados:";
        for (int i = 0; i < puntero; i++) {
            cad += "\n----------------------------------------\n" +
                    candidatos[i].presentarInforme();
        }
        return cad;
    }
}