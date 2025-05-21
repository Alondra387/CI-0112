package SolucionExamen1;

public class AgenteMain {

    public static void main(String[] args) {
        //Crear el mapa de comida
        MatrizComida mapa = new MatrizComida(1000, 1000);
        mapa.asignarComida();

        //Crear la cola de mensajes
        ColaMensajes cola = new ColaMensajes(500); // capacidad suficiente

        //Crear 5 agentes
        Agente[] agentes = new Agente[5];
        for (int i = 0; i < 5; i++) {
            agentes[i] = new Agente(i + 1, cola, mapa); // IDs del 1 al 5
        }

        //Simulación por turnos
        boolean seguir = true;
        int iteraciones = 0;

        while (seguir && iteraciones < 1000) { // límite para evitar ciclos infinitos
            seguir = false;

            for (int i = 0; i < 5; i++) {
                agentes[i].hacerTurno();
                if (agentes[i].getSeMovio()) {
                    seguir = true; // al menos un agente se movió
                }
            }

            // Verificar si la cola está vacía
            if (cola.estaVacia() && !seguir) {
                System.out.println("Simulación terminada. Nadie se movió y la cola está vacía.");
                break;
            }

            iteraciones++;
        }

        System.out.println("Simulación finalizada en " + iteraciones + " turnos.");
    }
}
    