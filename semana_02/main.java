 import modelo.Tarea;
import servicio.GestorTareas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas(100); // capacidad máxima 100
        int idProximo = 1;

        while(true) {
            System.out.println("\n--- Gestor de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar todas");
            System.out.println("3. Listar pendientes");
            System.out.println("4. Listar completadas");
            System.out.println("5. Completar tarea");
            System.out.println("6. Eliminar tarea");
            System.out.println("7. Estadísticas");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch(opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();
                    gestor.agregarTarea(new Tarea(idProximo, titulo, desc));
                    idProximo++;
                    break;
                case 2: gestor.mostrarTareas(); break;
                case 3: gestor.mostrarTareasPendientes(); break;
                case 4: gestor.mostrarTareasCompletadas(); break;
                case 5:
                    System.out.print("ID a completar: ");
                    int idC = sc.nextInt();
                    gestor.completarTarea(idC);
                    break;
                case 6:
                    System.out.print("ID a eliminar: ");
                    int idE = sc.nextInt();
                    gestor.eliminarTarea(idE);
                    break;
                case 7:
                    System.out.println("Total: " + gestor.totalTareas());
                    System.out.println("Pendientes: " + gestor.totalPendientes());
                    System.out.println("Completadas: " + gestor.totalCompletadas());
                    break;
                case 8:
                    System.out.println("¡Adiós!");
                    sc.close();
                    return;
                default: System.out.println("Opción no válida"); break;
            }
        }
    }
}

