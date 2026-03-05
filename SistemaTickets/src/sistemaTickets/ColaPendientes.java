package sistemaTickets;

public class ColaPendientes {

    // Atributos
    private NodoTicket frente;

    // Constructor
    public ColaPendientes(){
        this.frente = null;
    }

    // Metodo para verificar si está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Ver el ticket al frente
    public Ticket verFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.getTicket();
    }

    // Remover el ticket al frente
    public Ticket remover() {
        if (estaVacia()) {
            return null;
        }

        Ticket ticket = frente.getTicket();
        frente = frente.getSiguiente();
        return ticket;
    }

    // Insertar segun prioridad
    public void insertar(Ticket nuevoTicket){

        NodoTicket nuevoNodo = new NodoTicket(nuevoTicket);

        // Primer caso, si la cola esta vacia
        if (estaVacia()){
            frente = nuevoNodo;
            return;
        }

        // Segundo caso, si el nuevo ticket tiene mayor prioridad que el frente
        if(nuevoTicket.getPrioridad() < frente.getTicket().getPrioridad()){
            nuevoNodo.setSiguiente(frente);
            frente = nuevoNodo;
            return;
        }

        // Tercer caso, buscar posición correcta
        NodoTicket actual = frente; // Variable auxiliar para no modificar frente

        while(actual.getSiguiente() != null &&
                actual.getSiguiente().getTicket().getPrioridad() <= nuevoTicket.getPrioridad()){
            actual = actual.getSiguiente();
        }
        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);
    }
}
