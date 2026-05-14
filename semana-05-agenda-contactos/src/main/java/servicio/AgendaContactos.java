package servicio;

import modelo.Contacto;
import exception.*;
import util.ManejadorJSON;

import java.util.ArrayList;

public class AgendaContactos {

    private ArrayList<Contacto> lista;

    public AgendaContactos() {
        lista = ManejadorJSON.cargar();
    }

    private void guardar() {
        ManejadorJSON.guardar(lista);
    }

    public void agregar(Contacto c) throws ContactoExistenteException {
        for (Contacto x : lista) {
            if (x.getId().equals(c.getId())) {
                throw new ContactoExistenteException(c.getId());
            }
        }
        lista.add(c);
        guardar();
    }

    public Contacto buscar(String id) throws ContactoNoEncontradoException {
        for (Contacto c : lista) {
            if (c.getId().equals(id)) return c;
        }
        throw new ContactoNoEncontradoException("No existe contacto");
    }

    public void eliminar(String id) throws ContactoNoEncontradoException {
        Contacto c = buscar(id);
        lista.remove(c);
        guardar();
    }

    public ArrayList<Contacto> listar() {
        return lista;
    }
}