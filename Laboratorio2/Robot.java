package Laboratorio2;

public class Robot{
    
//Atributos de la clase 

    private String nombre;
    private int puntosVida;
    private int ataque;

//Constructor de la clase

    public Robot(String nombre, int puntosVida, int ataque){
        this.nombre = nombre;

//Validación de vida del robot 50-100
        if (puntosVida < 50) {
            this.puntosVida = 50;
        } else if (puntosVida > 100) {
            this.puntosVida = 100;
        } else {
            this.puntosVida = puntosVida;
        }

//Validación para el rango de ataque 10-20
        if (ataque < 10) {
            this.ataque = 10;
        } else if (ataque > 20) {
            this.ataque = 20;
        } else {
            this.ataque = ataque;
        }
    }

//Setters

    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public void setPuntosVida (int puntosVida){
        this.puntosVida = puntosVida;
    }
    public void setAtaque (int ataque){
        this.ataque = ataque;
    }

//Getters

    public String getNombre(){
        return nombre;
    }

    public int getPuntosVida(){
        return puntosVida;
    }
    public int getAtaque(){
        return ataque;
    }

//Métodos 
    public void atacar (Robot otroRobot){
            int nuevaVida = otroRobot.getPuntosVida() - this.ataque;
            
            if (nuevaVida < 0) {
                nuevaVida = 0;
            }
            
            otroRobot.setPuntosVida(nuevaVida);
        }
    public boolean estaVivo() {
        return this.puntosVida > 0;
}

}

    

