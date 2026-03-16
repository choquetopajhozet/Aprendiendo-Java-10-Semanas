package servicio;
 
import modelo.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private List<Tarea> tareas;
    private int contador = 0;

    public GestorTareas(int capacidad) {
        tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
            contador++;
        } else {
            System.out.println("CAPACIDAD MÁXIMA ALCANZADA");
        }
    }

    public void mostrarTareas() {
        for (int i = 0; i < contador; i++) {
            tareas.get(i).mostrarInfo();
        }
    }

    public void completarTarea(int id) {
        for (int i = 0; i < contador; i++) {
            if (tareas.get(i).getId() == id) {
                tareas.get(i).completar();
                System.out.println("TAREA COMPLETADA: " + tareas.get(i).getTitulo());
                return;
            }
        }
        System.out.println("ID NO ENCONTRADO");
    }

    public void mostrarTareasCompletadas() {
        for (int i = 0; i < contador; i++) {
            if (tareas.get(i).isCompletada()) {
                tareas.get(i).mostrarInfo();
            }
        }
    }

    public void mostrarTareasPendientes() {
        for (int i = 0; i < contador; i++) {
            if (!tareas.get(i).isCompletada()) {
                tareas.get(i).mostrarInfo();
            }
        }
    }

    public void eliminarTarea(int id) {
        for (int i = 0; i < contador; i++) {
            if (tareas.get(i).getId() == id) {
                tareas.remove(i);
                contador--;
                System.out.println("TAREA ELIMINADA");
                return;
            }
        }
        System.out.println("ID NO ENCONTRADO");
    }

    public void eliminarTodasLasTareas() {
        contador = 0;
        System.out.println("TODAS LAS TAREAS ELIMINADAS");
    }

    // Contadores
    public int totalTareas() { return contador; }
    public int totalPendientes() {
        int count = 0;
        for (int i = 0; i < contador; i++) if (!tareas.get(i).isCompletada()) count++;
        return count;
    }
    public int totalCompletadas() {
        int count = 0;
        for (int i = 0; i < contador; i++) if (tareas.get(i).isCompletada()) count++;
        return count;
    }
}

