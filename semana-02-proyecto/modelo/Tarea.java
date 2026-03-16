 package modelo; 

 public class Tarea {

    private int id;
    private String titulo;
    private String descripcion;
    private String estado;

    public Tarea(int id, String titulo, String descripcion){
        this. id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = "PENDIENTE";
    }
    public int getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String getEstado(){
        return estado;
    }
    public void completar(){
        this.estado = "COMPLETADA";
    }
    public boolean estaCOMPLETADA(){
        return this.estado.equals("COMPLETADA");
    }
    public void mostrarinfo(){
        System.out.println(" ID: " + id + " | " + estado);
        System.out.println(" Titulo: " + titulo);
        System.out.println(" Descripción: " + descripcion);
    }

}
