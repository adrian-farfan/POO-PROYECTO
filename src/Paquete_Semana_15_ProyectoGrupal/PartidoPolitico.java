/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete_Semana_15_ProyectoGrupal;

/**
 *
 * @author Administrador
 */
public class PartidoPolitico {
    private String nombre, siglas, logo, representante;
    private int votosTotales;

    public PartidoPolitico(String nombre, String siglas, String logo, String representante) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.logo = logo;
        this.representante = representante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public int getVotosTotales() {
        return votosTotales;
    }

    public void setVotosTotales(int votosTotales) {
        this.votosTotales = votosTotales;
    }

    public String verInfo() {
        return "Nombre:" + nombre +
                "\nSiglas: " + siglas +
                "\nLogo: " + logo +
                "\nRepresentante: " + representante +
                "\nVotos totales: " + votosTotales;
    }
}