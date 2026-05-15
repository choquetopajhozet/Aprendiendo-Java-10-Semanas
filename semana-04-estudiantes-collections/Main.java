import modelo.Alumno;
import servicio.ControlEstudiantes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ControlEstudiantes sistema =
                new ControlEstudiantes();

        cargarDatos(sistema);

        int opcion;

        do {

            System.out.println("\n======= MENU =======");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Cambiar promedio");
            System.out.println("4. Eliminar alumno");
            System.out.println("5. Mostrar ranking");
            System.out.println("6. Mostrar mejores 5");
            System.out.println("7. Buscar por carrera");
            System.out.println("8. Ver estadisticas");
            System.out.println("9. Ver historial");
            System.out.println("0. Salir");

            System.out.print("Seleccione opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Carnet: ");
                    String carnet = entrada.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();

                    System.out.print("Carrera: ");
                    String carrera = entrada.nextLine();

                    System.out.print("Promedio: ");
                    double promedio = entrada.nextDouble();
                    entrada.nextLine();

                    Alumno nuevo =
                            new Alumno(
                                    carnet,
                                    nombre,
                                    carrera,
                                    promedio);

                    if (sistema.agregarAlumno(nuevo)) {

                        System.out.println(
                                "Alumno registrado");
                    } else {

                        System.out.println(
                                "Carnet repetido");
                    }

                    break;

                case 2:

                    System.out.print(
                            "Ingrese carnet: ");

                    Alumno buscado =
                            sistema.buscarAlumno(
                                    entrada.nextLine());

                    if (buscado != null) {

                        System.out.println(buscado);
                    } else {

                        System.out.println(
                                "Alumno no encontrado");
                    }

                    break;

                case 3:

                    System.out.print("Carnet: ");
                    String car = entrada.nextLine();

                    System.out.print(
                            "Nuevo promedio: ");

                    double nuevoProm =
                            entrada.nextDouble();

                    entrada.nextLine();

                    if (sistema.modificarPromedio(
                            car,
                            nuevoProm)) {

                        System.out.println(
                                "Promedio actualizado");
                    } else {

                        System.out.println(
                                "Carnet inexistente");
                    }

                    break;

                case 4:

                    System.out.print(
                            "Carnet a eliminar: ");

                    if (sistema.eliminarAlumno(
                            entrada.nextLine())) {

                        System.out.println(
                                "Alumno eliminado");
                    } else {

                        System.out.println(
                                "No existe");
                    }

                    break;

                case 5:

                    sistema.verRanking();
                    break;

                case 6:

                    sistema.topCinco();
                    break;

                case 7:

                    System.out.print("Carrera: ");

                    sistema.buscarCarrera(
                            entrada.nextLine());

                    break;

                case 8:

                    sistema.estadisticas();
                    break;

                case 9:

                    sistema.mostrarHistorial();
                    break;

                case 0:

                    System.out.println(
                            "Programa finalizado");
                    break;

                default:

                    System.out.println(
                            "Opcion incorrecta");
            }

        } while (opcion != 0);

        entrada.close();
    }

    public static void cargarDatos(
            ControlEstudiantes sistema) {

        sistema.agregarAlumno(
                new Alumno(
                        "2022001",
                        "Luis Perez",
                        "Sistemas",
                        77.5));

        sistema.agregarAlumno(
                new Alumno(
                        "2022002",
                        "Maria Rojas",
                        "Industrial",
                        91.0));

        sistema.agregarAlumno(
                new Alumno(
                        "2022003",
                        "Carlos Vega",
                        "Civil",
                        68.5));

        sistema.agregarAlumno(
                new Alumno(
                        "2022004",
                        "Ana Flores",
                        "Sistemas",
                        84.0));

        sistema.agregarAlumno(
                new Alumno(
                        "2022005",
                        "Pedro Lima",
                        "Industrial",
                        95.0));
    }
}
