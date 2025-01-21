package Repaso_Examen;

public class Gasolinera {
    private static double total_ingresos_generados = 0;
    private static double total_litros_diesel = 0;
    private static double total_litros_gasolina = 0;
    private static double total_litros_gasolina_excelent = 0;
    private static double total_litros_gasolina_98 = 0;
    private Deposito[] depositos_gasolinera;

    public Gasolinera(Deposito[] depositos_gasolinera) {
        this.depositos_gasolinera = depositos_gasolinera;
    }

    public void restablerDeposito(Tipo tipo, double nueva_cantidad) {
        boolean encontrado = false;
        for (Deposito deposito : depositos_gasolinera) {
            if (tipo.equals(deposito.getTipo_combustible())) {
                deposito.setCapacidad_maxima(nueva_cantidad);
                encontrado = true;
                System.out.println("Depósito de tipo " + tipo + " actualizado a " + nueva_cantidad + " litros.");
                break;
            }
        }
    }

    public void totalDeLitrosVendidos() {
        System.out.println("___Total De Litros Vendidos___");
        System.out.println("Gasolina: " + total_litros_gasolina);
        System.out.println("Diesel: " + total_litros_diesel);
        System.out.println("Gasolina Excelent: " + total_litros_gasolina_excelent);
        System.out.println("Gasolina 98: " + total_litros_gasolina_98);
    }

    public void calcularLitrosSuministrados(Tipo tipo, double litros_suministrados) {
        if (litros_suministrados < 0) {
            System.out.println("Error: Los litros suministrados no pueden ser negativos.");
            return;
        }

        if (tipo == Tipo.DIESEL) {
            total_litros_diesel += litros_suministrados;
        } else if (tipo == Tipo.GASOLINA) {
            total_litros_gasolina += litros_suministrados;
        } else if (tipo == Tipo.GASOLINA_98) {
            total_litros_gasolina_98 += litros_suministrados;
        } else if (tipo == Tipo.DIESEL_EXECELENT) {
            total_litros_gasolina_excelent += litros_suministrados;
        } else {
            System.out.println("Error: Tipo de combustible no reconocido.");
            return;
        }

        System.out.println("Suministrados " + litros_suministrados + " litros de " + tipo);
        suminstrarLitros(tipo, litros_suministrados);
    }

    private void suminstrarLitros(Tipo tipo, double litros_suministrados) {
        for (Deposito deposito : depositos_gasolinera) {
            if (tipo.equals(deposito.getTipo_combustible())) {
                double nueva_capacidad = deposito.getCapacidad_maxima() - litros_suministrados;
                if (nueva_capacidad < 0) {
                    System.out.println("Error: No hay suficiente combustible en el depósito de " + tipo);
                } else {
                    deposito.setCapacidad_maxima(nueva_capacidad);
                    System.out.println("Se suministraron " + litros_suministrados + " litros de " + tipo +
                                       ". Nueva capacidad: " + nueva_capacidad + " litros.");
                }
                break;
            }
        }
    }

    public void mostrarEstadoDepositos() {
        System.out.println("Estado actual de los depósitos:");
        for (Deposito deposito : depositos_gasolinera) {
            System.out.println("Tipo: " + deposito.getTipo_combustible() +
                               ", Capacidad máxima: " + deposito.getCapacidad_maxima());
        }
    }
}
