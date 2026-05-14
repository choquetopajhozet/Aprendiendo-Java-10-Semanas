package exception;

public class ContactoExistenteException extends Exception {
    public ContactoExistenteException(String id) {
        super("Ya existe un contacto con ID: " + id);
    }
}