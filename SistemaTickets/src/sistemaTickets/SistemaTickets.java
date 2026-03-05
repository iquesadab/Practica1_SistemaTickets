package sistemaTickets;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SistemaTickets {

    // Atributos
    private ColaPendientes pendientes;
    private ListaEnlazadaResueltos resueltos;
    private Scanner scanner;

    // Constructor
    public SistemaTickets() {
        pendientes = new ColaPendientes();
        resueltos = new ListaEnlazadaResueltos();
        scanner = new Scanner(System.in);
    }

    public void iniciarSistema() {

        int opcion; // Variable para el switch del menú principal
        boolean continuar = true; // Variable para controlar el ciclo while principal

        // Bucle principal del menú
        while (continuar) {
            System.out.println("\n===== SISTEMA DE TICKETS =====\n" +
                    "1. Menú Usuario\n" +
                    "2. Menú Administrador\n" +
                    "3. Salir\n" +
                    "Seleccione una opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuAdministrador();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }

    public void menuUsuario() {
        int opcion;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENU USUARIO ---\n" +
                            "1. Crear Ticket\n" +
                            "2. Buscar Ticket Resuelto\n" +
                            "3. Volver al menú principal\n" +
                            "Seleccione una opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    crearTicket();
                    break;
                case 2:
                    buscarTicketResuelto();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }

    public void crearTicket() {

        System.out.println("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.println("Descripción del problema: ");
        String descripcion = scanner.nextLine();

        System.out.println("Prioridad (1 Alta, 2 Media, 3 Baja):");
        int prioridad = scanner.nextInt();
        scanner.nextLine();

        Ticket nuevo = new Ticket(descripcion, nombre, prioridad);

        pendientes.insertar(nuevo);

        System.out.println("Ticket creado con ID: " + nuevo.getId());
    }

    public void buscarTicketResuelto() {

        System.out.println("\nIngrese el ID del ticket: ");
        int id = scanner.nextInt();

        Ticket encontrado = resueltos.buscarPorId(id);

        if (encontrado == null) {
            System.out.println("El ticket aún está pendiente.");
        } else {
            System.out.println("\nTicket encontrado: \n");
            System.out.println(encontrado);
        }
    }

    public void menuAdministrador() {
        int opcion;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENU ADMINISTRADOR ---\n" +
                            "1. Ver ticket pendiente\n" +
                            "2. Resolver ticket\n" +
                            "3. Volver al menú principal\n" +
                            "Seleccione una opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){

                case 1:
                    verTicketPendiente();
                    break;
                case 2:
                    resolverTicket();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }

    public void verTicketPendiente() {

        Ticket ticket = pendientes.verFrente();

        if (ticket == null) {
            System.out.println("No hay tickets pendientes.");
        } else {
            System.out.println("\nTicket al frente:");
            System.out.println(ticket);
        }
    }

    public void resolverTicket() {

        Ticket ticket = pendientes.remover();

        if (ticket == null) {
            System.out.println("No hay tickets pendientes.");
            return;
        }

        ticket.setFechaResolucion(LocalDateTime.now());

        resueltos.insertarAlFinal(ticket);

        System.out.println("\nTicket resuelto:");
        System.out.println(ticket);
    }

}
