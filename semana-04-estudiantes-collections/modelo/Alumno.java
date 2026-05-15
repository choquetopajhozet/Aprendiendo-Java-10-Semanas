package modelo;

public class Alumno implements Comparable<Alumno> {

    private String carnet;
    private String nombre;
    private String carrera;
    private double promedio;

    public Alumno(String carnet,
                   String nombre,
                   String carrera,
                   double promedio) {

        this.carnet = carnet;
        this.nombre = nombre;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    @Override
    public int compareTo(Alumno otro) {

        int cmp =
                Double.compare(
                        this.promedio,
                        otro.promedio);

        if (cmp == 0) {

            return this.carnet.compareTo(
                    otro.carnet);
        }

        return cmp;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {

        return "[" + carnet + "] "
                + nombre + " "
                + carrera + " "
                + promedio;
    }
}
