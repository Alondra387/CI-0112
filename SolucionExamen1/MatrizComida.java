package SolucionExamen1;
import java.util.Random;

public class MatrizComida {
    
    private int[][] matriz;
    private int filas;
    private int columnas;

    public MatrizComida(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
    }

    // Método para asignar comida a 200 celdas aleatorias
    public void asignarComida() {
        Random rand = new Random();
        int asignadas = 0;

        while (asignadas < 200) {
            int x = rand.nextInt(filas);
            int y = rand.nextInt(columnas);

            int sumaVecinos = 0;
            boolean todosCeros = true;

            // Recorrer las 8 celdas vecinas y la misma
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int nx = x + dx;
                    int ny = y + dy;

                    if (nx >= 0 && nx < filas && ny >= 0 && ny < columnas) {
                        sumaVecinos += matriz[nx][ny];
                        if (matriz[nx][ny] != 0) {
                            todosCeros = false;
                        }
                    }
                }
            }

            if (todosCeros) {
                matriz[x][y] += 1;
            } else {
                matriz[x][y] = sumaVecinos;
            }

            asignadas++;
        }
    }

    // Método auxiliar para obtener el valor en una celda (útil para depurar o pruebas)
    public int getComidaEn(int x, int y) {
        if (x >= 0 && x < filas && y >= 0 && y < columnas) {
            return matriz[x][y];
        }
        return -1;
    }
}


