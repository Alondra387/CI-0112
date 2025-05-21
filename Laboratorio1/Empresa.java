public class Empresa{
    public static void main (String[] args){

        System.out.println("----Inicio de la simulación del programa---");

//Aquí se encuentran las 3 instancias creadas
        Empleados empleada1 = new Empleados("Elena", 45, 4000, "Ingeniera", 15, true);
        Empleados empleada2 = new Empleados("Carla", 30, 3000, "Maestra de obra", 8, false);
        Empleados empleada3 = new Empleados("Ana", 29, 2000, "Operaria", 4, false);

//Empleada 1 con sus respectivos métodos
        empleada1.mostrarExpediente();

        empleada1.activarEmpleado();
        empleada1.aumentarSalario(10);
        empleada1.cambiarPuesto("CEO");
        empleada1.calcularSalarioAnual();
      

        System.out.println("----Estado final:----");
        empleada1.mostrarExpediente();

//Empleada 2 con sus respectivos métodos
        empleada2.mostrarExpediente();

        empleada2.desactivarEmpleado();
        empleada2.aumentarSalario(20);
        empleada2.cambiarPuesto("Jefa operaria");
        empleada2.calcularSalarioAnual();
    
        System.out.println("----Estado final:----");
        empleada2.mostrarExpediente();

//Empleada 3 con sus respectivos métodos
        empleada3.mostrarExpediente();

        empleada3.activarEmpleado();
        empleada3.aumentarSalario(30);
        empleada3.cambiarPuesto("Ingeniera");
        empleada1.calcularSalarioAnual();
    
        System.out.println("----Estado final:----");
        empleada3.mostrarExpediente();
    }  

}