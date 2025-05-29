package Tarea1;

import java.util.Scanner;
import java.util.Random;

public class JuegoBatalla {
//Atributo array
    private Robot[] robots;

// Constructor que inicializa el array de robots
    public JuegoBatalla(int cantidadRobots) {
        robots = new Robot[cantidadRobots];
    }

// Método para crear los robots y llenar el array
    public void crearRobots(Scanner scanner) {
        for (int i = 0; i < robots.length; i++) {
            System.out.println("Ingrese el nombre del Robot " + (i + 1) );
            String nombre = scanner.nextLine();
            int puntosVida;
            do {
                System.out.println("Ingrese los puntos de vida (50-100) del Robot " + (i + 1) );
                puntosVida = scanner.nextInt();
            } while (puntosVida < 50 || puntosVida > 100);

            int ataque;
            do {
                System.out.println("Ingrese el ataque (10-20) del Robot " + (i + 1) );
                ataque = scanner.nextInt();
            } while (ataque < 10 || ataque > 20);
            scanner.nextLine(); 
            robots[i] = new Robot(nombre, puntosVida, ataque);
        }
    }

// Método para iniciar la batalla entre robots
    public void iniciarBatalla() {
        Random random = new Random();

        while (contarRobotsVivos() > 1) {
            for (int i = 0; i < robots.length; i++) {
                if (robots[i] != null && robots[i].estaVivo()) {
                    int objetivo;
                    do {
                        objetivo = random.nextInt(robots.length);
                    } while ((objetivo == i) || (robots[objetivo] == null) || (!robots[objetivo].estaVivo()));

                    robots[i].atacar(robots[objetivo]);
                    System.out.println(robots[i].getNombre() + " ataca a " + robots[objetivo].getNombre());

                    if (!robots[objetivo].estaVivo()) {
                        System.out.println(robots[objetivo].getNombre() + " ha sido eliminado.");
                    }
                }
            }
        }
    }

// Método para contar cuántos robots siguen vivos
    private int contarRobotsVivos() {
        int vivos = 0;
        for (Robot robot : robots) {
            if (robot != null && robot.estaVivo()) {
                vivos++;
            }
        }
        return vivos;
    }
// Método para mostrar el robot ganador
    public void mostrarGanador() {
        for (Robot robot : robots) {
            if (robot != null && robot.estaVivo()) {
                System.out.println("El ganador es: " + robot.getNombre());
                return;
            }
        }
    }

// Método main
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese la cantidad de robots (mínimo 2, máximo 10): ");
    int cantidad = scanner.nextInt();
    scanner.nextLine(); 

    while (cantidad < 2 || cantidad > 10) {
        System.out.println("Número inválido. Intente nuevamente:");
        cantidad = scanner.nextInt();
        scanner.nextLine(); 
    }
        JuegoBatalla juego = new JuegoBatalla(cantidad);
        juego.crearRobots(scanner);
        juego.iniciarBatalla();
        juego.mostrarGanador();
        scanner.close();
    }
}

