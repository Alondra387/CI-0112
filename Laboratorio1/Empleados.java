//Caso 1: Sistema de Gestión de Empleados

public class Empleados{

//atributos

    private String nombre;
    private int edad;
    private double salario;
    private String puesto;
    private int experiencia;
    private boolean estado;

//constructor

    public Empleados (String nombre, int edad, double salario, String puesto, int experiencia, boolean estado){
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.puesto = puesto;
        this.experiencia = experiencia;
        this.estado = estado;
    }

//Setters

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }
    public void setPuesto(String puesto){
        this.puesto = puesto;
    }
    public void setExperiencia(int experiencia){
        this.experiencia = experiencia;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }

//Getters

    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public double getSalario(){
        return salario;
    }
    public String getPuesto(){
        return puesto;
    }
    public int getExperiencia(){
        return experiencia;
    }
    public boolean getEstado(){
        return estado;
    }

//Métodos

    public void aumentarSalario(double porcentaje){
        double aumento = this.salario * (porcentaje / 100);
        this.salario = this.salario + aumento;
        System.out.println("El aumento de salario con un porcentaje de: " + porcentaje + " es equivalente a: " + aumento +
        " su nuuevo salario es de: " + salario);
    }


    public void cambiarPuesto(String nuevoPuesto){
       this.puesto= nuevoPuesto;
       System.out.println("La empleada cambió de puesto a: " + nuevoPuesto);
    }


    public void calcularSalarioAnual(){
            System.out.println("El salario anual es equivalente a: " + (salario*12));
    }
    public void activarEmpleado(){
        if (!estado){
            estado = true;
            System.out.println("El empleado está activo" ); 
        }else{ System.out.println("El empleado ya se encuentra activo");

        }

    }
    public void desactivarEmpleado(){
        if (estado){
            estado = false;
            System.out.println("El empleado está inactivo" );
        }else{
            System.out.println("El empleado ya se encuentra desactivado");
        }
    }

    public void mostrarExpediente(){
        System.out.println("---- Mostrando el expediente de " + nombre + " ---" );   
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Puesto: " + puesto);
        System.out.println("Años de experiencia: " + experiencia);
        System.out.println("Salario mensual: " + salario);
        System.out.println("------------------------");
    }
}



