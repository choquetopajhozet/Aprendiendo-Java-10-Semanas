package servicio;

import modelo.Tarea;

public class GestorTareas {
    private Tarea[] tareas;
    private int contador = 0;

    public GestorTareas(int capacidad) {
        tareas = new Tarea[capacidad];
    }

    public void agregarTarea(Tarea tarea) {
        if (contador < tareas.length) {
            tareas[contador] = tarea;
            contador++;
        } else {
            System.out.println("CAPACIDAD MÁXIMA ALCANZADA");
        }
    }

    public void mostrarTareas() {
        for (int i = 0; i < contador; i++) {
            tareas[i].mostrarInfo();
            System.out.println("------------------");
        }
    }

    public void completarTarea(int id) {
        for (int i = 0; i < contador; i++) {
            if (tareas[i].getId() == id) {
                tareas[i].setCompletada(true);
                break;
            }
        }
    }

    public void mostrarTareasCompletadas() {
        for (int i = 0; i < contador; i++) {
            if (tareas[i].isCompletada()) {
                tareas[i].mostrarInfo();
                System.out.println("------------------");
            }
        }
    }

    public void mostrarTareasPendientes() {
        for (int i = 0; i < contador; i++) {
            if (!tareas[i].isCompletada()) {
                tareas[i].mostrarInfo();
                System.out.println("------------------");
            }
        }
    }

    public void eliminarTarea(int id) {
        for (int i = 0; i < contador; i++) {
            if (tareas[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    tareas[j] = tareas[j + 1];
                }
                contador--;
                break;
            }
        }
    }

    public void eliminarTareasCompletadas() {
        int i = 0;
        while (i < contador) {
            if (tareas[i].isCompletada()) {
                for (int j = i; j < contador - 1; j++) {
                    tareas[j] = tareas[j + 1];
                }
                contador--;
            } else {
                i++;
            }
        }
    }

    public void eliminarTareasPendientes() {
        int i = 0;
        while (i < contador) {
            if (!tareas[i].isCompletada()) {
                for (int j = i; j < contador - 1; j++) {
                    tareas[j] = tareas[j + 1];
                }
                contador--;
            } else {
                i++;
            }
        }
    }

    public void eliminarTodasLasTareas() {
        contador = 0;
    }
}



