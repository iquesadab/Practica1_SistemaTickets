package sistemaTickets;

public class ListaEnlazadaResueltos {

    // Atributos
    private NodoTicket primero;

    // Constructor
    public ListaEnlazadaResueltos() {
        this.primero = null;
    }

    // Verificar si está vacía
    public boolean estaVacia() {
        return primero == null;
    }

    // Insertar al final
    public void insertarAlFinal(Ticket ticket) {

        NodoTicket nuevoNodo = new NodoTicket(ticket);

        if (estaVacia()) {
            primero = nuevoNodo;
            return;
        }
        NodoTicket actual = primero;

        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevoNodo);
    }

    // Buscar ticket por ID
    public Ticket buscarPorId(int id) {

        NodoTicket actual = primero;

        while (actual != null) {
            if (actual.getTicket().getId() == id) {
                return actual.getTicket();
            }
            actual = actual.getSiguiente();
        }
        return null; // no encontrado
    }
}
