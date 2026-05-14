package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelo.Contacto;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManejadorJSON {

    private static final Gson gson = new Gson();
    private static final String ARCHIVO = "data/contactos.json";

    public static void guardar(ArrayList<Contacto> lista) {
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar");
        }
    }

    public static ArrayList<Contacto> cargar() {
        File file = new File(ARCHIVO);
        if (!file.exists()) return new ArrayList<>();

        try (FileReader reader = new FileReader(file)) {
            Type tipo = new TypeToken<ArrayList<Contacto>>(){}.getType();
            ArrayList<Contacto> lista = gson.fromJson(reader, tipo);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}