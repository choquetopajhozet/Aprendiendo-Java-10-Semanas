package modelo;

public class Auto extends Vehiculo {

    private int puertas;

    public Auto(
            String marca,
            String modelo,
            int anio,
            int puertas) {

        super(marca, modelo, anio);

        this.puertas = puertas;
    }

    @Override
    public void acelerar() {

        System.out.println(
                marca + " acelera rapido");
    }

    public int getPuertas() {

        return puertas;
    }
}