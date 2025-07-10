/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete_Semana_15_ProyectoGrupal;

/**
 *
 * @author Administrador
 */
public class MesaElectoral implements Interfaz
{
    private MiembroMesa[] miembros;
    private int puntero;

    public MesaElectoral() {
        this.miembros = new MiembroMesa[3];
        this.puntero = 0;
    }

    public MiembroMesa[] getMiembros() {
        return miembros;
    }

    public void setMiembros(MiembroMesa[] miembros) {
        this.miembros = miembros;
    }

    public int getPuntero() {
        return puntero;
    }

    public void setPuntero(int puntero) {
        this.puntero = puntero;
    }
    
    public void agregarMiembro(MiembroMesa miembro) {
        if (puntero < miembros.length) {
            miembros[puntero] = miembro;
            puntero++;
        }
        else {
            System.out.println("No hay más espacio en esta mesa electoral.");
        }
    }
    
    public void eliminarMiembro(MiembroMesa miembro) {
        boolean noEncontrado = true;
        for (int i = 0; i < puntero; i++) {
            if (miembros[i] == miembro) {
                for (int j = i; j < puntero - 1; j++) {
                    miembros[j] = miembros[j+1];
                }
                miembros[puntero-1] = null;
                puntero--;
                noEncontrado = false;
            }
        }
        if (noEncontrado) {
            System.out.println("Miembro de mesa no encontrado.");
        }
    }

    @Override
    public String presentarInforme() {
        String cad = "";
        for (int i = 0; i < puntero; i++) {
            cad += miembros[i].presentarInforme() + "\n\n";
        }
        return cad;
    }
}