import java.util.Scanner;

public class Calificaciones {


    public static void ingresarDatos(String[] nombres, int[][] notas) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();

            for (int j = 0; j < 3; j++) {
                while (true) {
                    try {
                        System.out.print("Ingrese la nota " + (j + 1) + ": ");
                        int nota = Integer.parseInt(sc.nextLine());

                        if (nota >= 0 && nota <= 100) {
                            notas[i][j] = nota;
                            break;
                        } else {
                            System.out.println("Error: La nota debe estar entre 0 y 100.");
                        }

                    } catch (Exception e) {
                        System.out.println("Error: Debe ingresar un número válido.");
                    }
                }
            }
        }
    }

    public static double calcularPromedio(int[] notas) {
        int suma = 0;

        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }

        return (double) suma / notas.length;
    }

    public static void mostrarResultados(String[] nombres, int[][] notas) {

        int aprobados = 0;
        int reprobados = 0;

        int notaAlta = -1;
        int notaBaja = 101;

        double sumaPromedios = 0;

        System.out.println("\nRESULTADOS");

        for (int i = 0; i < nombres.length; i++) {

            double promedio = calcularPromedio(notas[i]);
            sumaPromedios += promedio;

            System.out.println("\nEstudiante: " + nombres[i]);
            System.out.println("Promedio: " + promedio);

            if (promedio >= 51) {
                System.out.println("Estado: APROBADO");
                aprobados++;
            } else {
                System.out.println("Estado: REPROBADO");
                reprobados++;
            }

            for (int j = 0; j < 3; j++) {
                if (notas[i][j] > notaAlta) {
                    notaAlta = notas[i][j];
                }

                if (notas[i][j] < notaBaja) {
                    notaBaja = notas[i][j];
                }
            }
        }

        double promedioGeneral = sumaPromedios / nombres.length;

        System.out.println("\nPROMEDIO GENERAL DEL CURSO: " + promedioGeneral);
        System.out.println("NOTA MAS ALTA: " + notaAlta);
        System.out.println("NOTA MAS BAJA: " + notaBaja);
        System.out.println("APROBADOS: " + aprobados);
        System.out.println("REPROBADOS: " + reprobados);
    }

    public static void main(String[] args) {

        String[] nombres = new String[5];

        int[][] notas = new int[5][3];

        ingresarDatos(nombres, notas);

        mostrarResultados(nombres, notas);
    }
}