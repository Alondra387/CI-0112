package SolucionExamen1;

public class ColaMensajes {

    private Mensaje[] cola;
    private int frente;
    private int fin;
    private int capacidad;

    public ColaMensajes(int capacidad) {
        this.capacidad = capacidad;
        cola = new Mensaje[capacidad];
        frente = 0;
        fin = 0;
    }

// Verifica si la cola está vacía
    public boolean estaVacia() {
        return frente == fin;
    }

// Verifica si la cola está llena
    public boolean estaLlena() {
        return fin == capacidad;
    }

// Agregar un mensaje a la cola
    public void agregarMensaje(Mensaje m) {
        if (!estaLlena()) {
            cola[fin] = m;
            fin++;
        } else {
            System.out.println("La cola está llena, no se puede agregar el mensaje.");
        }
    }
// Ver el id del destinatario del primer mensaje
    public int verSiguienteDestinatario() {
        if (!estaVacia()) {
            return cola[frente].getIdDestinatario();
        } else {
            System.out.println("La cola está vacía.");
            return -1;
        }
    }

// Extraer mensaje solo si el agente es el destinatario
    public Mensaje sacarMensaje(int idAgente) {
        if (!estaVacia()) {
            Mensaje m = cola[frente];
            if (m.getIdDestinatario() == idAgente) {
                // Avanzamos el frente de la cola
                frente++;
                return m;
            } else {
                System.out.println("Este mensaje no es para el agente " + idAgente);
                return null;
            }
        } else {
            System.out.println("La cola está vacía.");
            return null;
        }
    }
}

