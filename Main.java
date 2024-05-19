// Clase abstracta Vehiculo
public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int añoFabricacion;
    protected double precioAlquilerPorDia;

    public Vehiculo(String marca, String modelo, int añoFabricacion, double precioAlquilerPorDia) {
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.precioAlquilerPorDia = precioAlquilerPorDia;
    }

    public abstract double calcularCostoAlquiler(int dias);
}

// Interfaz Pagable
public interface Pagable {
    double calcularCosto(int cantidad);
}

// Clase Cliente
public class Cliente {
    private String nombre;
    private String metodoPago;

    public Cliente(String nombre, String metodoPago) {
        this.nombre = nombre;
        this.metodoPago = metodoPago;
    }

    public void pagar(double cantidad) {
        // Método para realizar el pago
        System.out.println("Se ha realizado un pago de $" + cantidad + " mediante " + metodoPago);
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase Coche que hereda de Vehiculo e implementa Pagable
public class Coche extends Vehiculo implements Pagable {
    private int capacidadPasajeros;

    public Coche(String marca, String modelo, int añoFabricacion, double precioAlquilerPorDia, int capacidadPasajeros) {
        super(marca, modelo, añoFabricacion, precioAlquilerPorDia);
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        return precioAlquilerPorDia * dias;
    }

    @Override
    public double calcularCosto(int cantidad) {
        // Método implementado de la interfaz Pagable
        return cantidad * precioAlquilerPorDia;
    }
}

// Programa de ejemplo
public class Main {
    public static void main(String[] args) {
        Coche coche = new Coche("Toyota", "Corolla", 2022, 50.0, 5);
        double costoAlquiler = coche.calcularCostoAlquiler(3);
        System.out.println("El costo de alquiler del coche es: $" + costoAlquiler);

        Cliente cliente = new Cliente("Juan", "Tarjeta de crédito");
        double costo = coche.calcularCosto(2);
        cliente.pagar(costo);
        System.out.println("El cliente " + cliente.getNombre() + " ha pagado $" + costo + " por el alquiler del coche.");
    }
}
