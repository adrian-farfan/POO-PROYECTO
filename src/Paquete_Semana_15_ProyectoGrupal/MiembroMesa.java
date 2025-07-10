/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete_Semana_15_ProyectoGrupal;

/**
 *
 * @author Administrador
 */
public class MiembroMesa extends Persona
{
    private String tipo;

    public MiembroMesa(String nombres, String apellidos, String tipo) 
    {
        super(nombres, apellidos);
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String presentarInforme() {
        return super.toString() +
                "\nTipo: " + tipo;
    }

    
}