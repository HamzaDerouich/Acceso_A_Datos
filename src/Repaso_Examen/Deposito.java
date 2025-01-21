package Repaso_Examen;

public class Deposito {
	
    private Tipo tipo_combustible;
    private double capacidad_maxima;
    private double capacidad_minima;

    public Deposito(Tipo tipo_combustible, double capacidad_maxima, double capacidad_minima) {
        this.tipo_combustible = tipo_combustible;
        this.capacidad_maxima = capacidad_maxima;
        this.capacidad_minima = capacidad_minima;
    }

    public Deposito() {
        this.tipo_combustible = Tipo.GASOLINA;
        this.capacidad_maxima = 1000;
        this.capacidad_minima = 50;
    }

    // Getters y Setters
    public Tipo getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(Tipo tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public double getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public void setCapacidad_maxima(double capacidad_suministrada) {
        if (capacidad_suministrada < 0) {
            System.out.println("Error: La cantidad suministrada no puede ser negativa.");
            return;
        }

        double nueva_cantidad = this.capacidad_maxima + capacidad_suministrada;

        if (nueva_cantidad > 1000) {
            System.out.println("Error: La capacidad no puede superar los 1000 litros.");
        } else {
            this.capacidad_maxima = nueva_cantidad;
            System.out.println("Capacidad máxima actualizada: " + this.capacidad_maxima + " litros.");
        }
    }

    public double getCapacidad_minima() {
        return capacidad_minima;
    }

    public void setCapacidad_minima(double capacidad_minima) {
        if (capacidad_minima < 0) {
            System.out.println("Error: La capacidad mínima no puede ser negativa.");
            return;
        }

        if (capacidad_minima > capacidad_maxima) {
            System.out.println("Error: La capacidad mínima no puede superar la capacidad máxima.");
            return;
        }

        if (capacidad_minima <= 50) {
            System.out.println("Advertencia: Depósito en números rojos. Estableciendo el mínimo permitido (50 litros).");
            this.capacidad_minima = 50;
        } else {
            this.capacidad_minima = capacidad_minima;
            System.out.println("Capacidad mínima actualizada: " + this.capacidad_minima + " litros.");
        }
    }
}
