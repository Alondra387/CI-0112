package SolucionExamen1;

public class Mensaje {

    private int idFuente;
    private int idEmisor;
    private int idDestinatario;
    private String contenido;

    public Mensaje(int idFuente, int idEmisor, int idDestinatario, String contenido) {
        this.idFuente = idFuente;
        this.idEmisor = idEmisor;
        this.idDestinatario = idDestinatario;
        this.contenido = contenido;
    }

// Getters
    public int getIdFuente() {
        return idFuente;
    }

    public int getIdEmisor() {
        return idEmisor;
    }

    public int getIdDestinatario() {
        return idDestinatario;
    }

    public String getContenido() {
        return contenido;
    }

// Método para mostrar el mensaje
    public void mostrarMensaje() {
        System.out.println("Mensaje:");
        System.out.println("  Fuente: " + idFuente);
        System.out.println("  Emisor: " + idEmisor);
        System.out.println("  Destinatario: " + idDestinatario);
        System.out.println("  Contenido: " + contenido);
    }
}
    

