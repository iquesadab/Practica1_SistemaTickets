package sistemaTickets;

import java.time.LocalDateTime;

public class Ticket {

    // Atributo Estático
    private static int contador = 1;

    // Atributos
    private int id;
    private String descripcion;
    private String nombreCompleto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaResolucion;
    private int prioridad;

    // Constructor
    public Ticket(String descripcion, String nombreCompleto, int prioridad) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.prioridad = prioridad;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaResolucion = null;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }
    public int getPrioridad() {
        return prioridad;
    }

    // Setter
    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    // toString
    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Usuario: " + nombreCompleto + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Prioridad: " + prioridad + "\n" +
                "Fecha de creación: " + fechaCreacion + "\n" +
                "Fecha de resolución: " + fechaResolucion + "\n";
    }
}
