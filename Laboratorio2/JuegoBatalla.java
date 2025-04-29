package Laboratorio2;
public class JuegoBatalla {
    public static void main (String[] args){
    import java.util.Scanner;

// Atributos de la clase
    private Robot[] robots;

// Constructor de la clase
    public JuegoBatalla(int cantidadRobots) {
        robots = new Robot[cantidadRobots];
    }

// Método para llenar el array de robots pidiendo datos al usuario
    public void crearRobots() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < robots.length; i++) {
            System.out.println("Ingrese el nombre del Robot " + (i + 1));
            String nombre = scanner.nextLine();

            System.out.println("Ingrese los puntos de vida (50-100) del Robot " + (i + 1));
            int puntosVida = scanner.nextInt();

            System.out.println("Ingrese el ataque (10-20) del Robot" + (i + 1));
            int ataque = scanner.nextInt();
            scanner.nextLine();

            
    //Nuevo Robot y guardarlo en el array
            robots[i] = new Robot(nombre, puntosVida, ataque);
        }
    }


//Método iniciar Batalla
    public void iniciarBatalla() {
        java.util.Random random = new java.util.Random();

        while (contarRobotsVivos() > 1) {
            for (int i = 0; i < robots.length; i++) {
                if (robots[i] != null && robots[i].estaVivo()) {
                    int objetivo;

                    // Elegir un robot aleatorio que sea diferente al actual
                    do {
                        objetivo = random.nextInt(robots.length);
                    } while ((objetivo == i) || (robots[objetivo] == null) || (!robots[objetivo].estaVivo()));

                    // El robot ataca al robot objetivo
                    robots[i].atacar(robots[objetivo]);
                    System.out.println(robots[i].getNombre() + " ataca a " + robots[objetivo].getNombre());

                    // Este if es para ver si el robot objetivo murió
                    if (!robots[objetivo].estaVivo()) {
                        System.out.println(robots[objetivo].getNombre() + " ha sido eliminado");
                    }
                }
            }
        }
    }

//Este método muestra el ganador

    public void mostrarGanador() {
                for (int i = 0; i < robots.length; i++) {
                    if (robots[i] != null && robots[i].estaVivo()) {
                        System.out.println("El ganador es: " + robots[i].getNombre());
                        return;
                    }
                }

            } 
}
