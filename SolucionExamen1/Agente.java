package SolucionExamen1;

public class Agente {
    private int id;
    private int x;
    private int y;
    private boolean seMovio;
    private ColaMensajes cola;
    private MatrizComida mapa;

    public Agente(int id, ColaMensajes cola, MatrizComida mapa) {
        this.id = id;
        this.cola = cola;
        this.mapa = mapa;

        // Coordenadas aleatorias entre 0 y 999
        this.x = (int) (Math.random() * 1000);
        this.y = (int) (Math.random() * 1000);
        this.seMovio = true; // al inicio se considera que sí se movió
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getSeMovio() {
        return seMovio;
    }

    public void setSeMovio(boolean seMovio) {
        this.seMovio = seMovio;
    }

    public void hacerTurno() {
//Calcular la comida máxima alrededor
    int comidaMaxima = 0;
    for (int dx = -1; dx <= 1; dx++) {
        for (int dy = -1; dy <= 1; dy++) {
            int nx = x + dx;
            int ny = y + dy;
            int valor = mapa.getComidaEn(nx, ny);
            if (valor > comidaMaxima) {
                comidaMaxima = valor;
            }
        }
    }

    //Leer hasta 3 mensajes
    int mejorComida = comidaMaxima;
    int mejorX = x;
    int mejorY = y;

    int mensajesLeidos = 0;
    while (mensajesLeidos < 3 && cola.verSiguienteDestinatario() == id) {
        Mensaje m = cola.sacarMensaje(id);
        if (m != null) {
            String contenido = m.getContenido();
            String[] partes = contenido.split(",");
            int xOtros = Integer.parseInt(partes[0].split(":")[1]);
            int yOtros = Integer.parseInt(partes[1].split(":")[1]);
            int comidaOtros = Integer.parseInt(partes[2].split(":")[1]);

            if (comidaOtros > mejorComida) {
                mejorComida = comidaOtros;
                mejorX = xOtros;
                mejorY = yOtros;
            }
            mensajesLeidos++;
        }
    }

    //Moverse si otro agente encontró más comida
    if (mejorX != x || mejorY != y) {
        int nuevaX = x;
        int nuevaY = y;

        if (mejorX > x) nuevaX++;
        else if (mejorX < x) nuevaX--;

        if (mejorY > y) nuevaY++;
        else if (mejorY < y) nuevaY--;

        setSeMovio(true);
        x = nuevaX;
        y = nuevaY;
    } else {
        setSeMovio(false);
    }

    //Enviar mensaje a los demás agentes con su comida detectada
    for (int i = 1; i <= 5; i++) {
        if (i != id) {
            String msg = "X:" + x + ",Y:" + y + ",COMIDA:" + comidaMaxima;
            Mensaje nuevo = new Mensaje(id, id, i, msg);
            cola.agregarMensaje(nuevo);
        }
    }
}

}

