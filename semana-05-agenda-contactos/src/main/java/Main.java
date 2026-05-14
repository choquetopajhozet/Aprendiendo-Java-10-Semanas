import servicio.AgendaContactos;
import modelo.Contacto;
import exception.*;

import java.util.Scanner;

public class Main {

    static AgendaContactos agenda = new AgendaContactos();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int op;

        do {
            System.out.println("\n=== AGENDA ===");
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");

            try {
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1:
                        agregar();
                        break;
                    case 2:
                        listar();
                        break;
                    case 3:
                        buscar();
                        break;
                    case 4:
                        eliminar();
                        break;
                    case 5:
                        System.out.println("Adiós");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido");
                op = 0;
            }

        } while (op != 5);
    }

    static void agregar() {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Telefono: ");
            String tel = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            agenda.agregar(new Contacto(id, nombre, tel, email, ""));
            System.out.println("Guardado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void listar() {
        for (Contacto c : agenda.listar()) {
            System.out.println(c);
        }
    }

    static void buscar() {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.println(agenda.buscar(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void eliminar() {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine();
            agenda.eliminar(id);
            System.out.println("Eliminado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}