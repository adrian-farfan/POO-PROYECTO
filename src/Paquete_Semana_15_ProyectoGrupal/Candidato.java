/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete_Semana_15_ProyectoGrupal;

/**
 *
 * @author Administrador
 */
public class Candidato extends Persona
{
    private int dni, votosPreferenciales;
    private PartidoPolitico partido;

    public Candidato(int dni, int votosPreferenciales, PartidoPolitico partido, String nombres, String apellidos) {
        super(nombres, apellidos);
        this.dni = dni;
        this.votosPreferenciales = votosPreferenciales;
        this.partido = partido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getVotosPreferenciales() {
        return votosPreferenciales;
    }

    public void setVotosPreferenciales(int votosPreferenciales) {
        this.votosPreferenciales = votosPreferenciales;
    }

    public PartidoPolitico getPartido() {
        return partido;
    }

    public void setPartido(PartidoPolitico partido) {
        this.partido = partido;
    }

    public String presentarInforme() {
        return super.toString() + 
                "\nDni: " + dni +
                "\nVotos preferenciales: " + votosPreferenciales +
                "\nPartido: " + partido.getNombre();
    }


}