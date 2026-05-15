package servicio;

import modelo.Alumno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class ControlEstudiantes {

    private HashMap<String, Alumno> mapa;
    private TreeSet<Alumno> ranking;
    private ArrayList<String> historial;

    public ControlEstudiantes() {

        mapa = new HashMap<>();
        ranking = new TreeSet<>();
        historial = new ArrayList<>();
    }

    public boolean agregarAlumno(Alumno a) {

        if (mapa.containsKey(a.getCarnet())) {
            return false;
        }

        mapa.put(a.getCarnet(), a);
        ranking.add(a);

        historial.add("AGREGADO");

        return true;
    }

    public Alumno buscarAlumno(String carnet) {

        return mapa.get(carnet);
    }

    public boolean modificarPromedio(
            String carnet,
            double promedio) {

        Alumno a = mapa.get(carnet);

        if (a == null) {
            return false;
        }

        ranking.remove(a);

        a.setPromedio(promedio);

        ranking.add(a);

        return true;
    }

    public boolean eliminarAlumno(String carnet) {

        Alumno a = mapa.remove(carnet);

        if (a == null) {
            return false;
        }

        ranking.remove(a);

        return true;
    }

    public void verRanking() {

        for (Alumno a : ranking) {

            System.out.println(a);
        }
    }

    public void topCinco() {

        Alumno[] arr =
                ranking.toArray(new Alumno[0]);

        int c = 1;

        for (int i = arr.length - 1;
             i >= 0 && c <= 5;
             i--) {

            System.out.println(
                    c + ". " + arr[i]);

            c++;
        }
    }

    public void buscarCarrera(
            String carrera) {

        for (Alumno a : mapa.values()) {

            if (a.getCarrera()
                    .equalsIgnoreCase(carrera)) {

                System.out.println(a);
            }
        }
    }

    public void estadisticas() {

        System.out.println(
                "Total: " + ranking.size());
    }

    public void mostrarHistorial() {

        for (String h : historial) {

            System.out.println(h);
        }
    }
}
