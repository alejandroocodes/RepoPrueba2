/*El programa simula un plan de ahorro mes a mes,
calculando el tiempo necesario para alcanzar una meta financiera.

Entradas: Salario anual del usuario, el porcentaje de su salario que desea ahorrar y el costo de la casa de sus sueños
Salidas: meses

Ejemplo:
- Entradas:
 Salario anual: 120000
 Proporción de ahorro: 0.10
 Costo de la casa: 1000000
- Salida:
Número de meses: 217*/

import java.util.Scanner;

public class AhorroVivienda {

    public static void main(String[] args) {
        // Lector de entradas del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese su salario anual: ");
        double salarioAnual = scanner.nextDouble();

        System.out.print("Ingrese el porcentaje de su salario que desea ahorrar (ej 0,1 para 10%): ");
        double proporcionAhorrada = scanner.nextDouble();

        System.out.print("Ingrese el costo de la casa de sus sueños: ");
        double costoTotal = scanner.nextDouble();

        scanner.close();

        int mesesNecesarios = calcularMesesAhorro(salarioAnual, proporcionAhorrada, costoTotal);
        // Salida
        System.out.println("Tomará " + mesesNecesarios + " meses ahorrar para la cuota inicial de la casa.");
    }
    public static int calcularMesesAhorro(double salarioAnual, double proporcionAhorrada, double costoTotal) {

        // Definen las variables
        final double proporcionCuotaInicial = 0.35;
        final double tasaRetorno = 0.05;
        double ahorrosActuales = 0.0;
        int meses = -1;

        // Cálculo de la cuota inicial y el ahorro mensual
        double cuotaInicial = costoTotal * proporcionCuotaInicial;
        double ahorroMensual = (salarioAnual / 12) * proporcionAhorrada;

        // Calcular los meses necesarios
        while (ahorrosActuales < cuotaInicial) {
            double rendimientoInversion = ahorrosActuales * tasaRetorno / 12;
            ahorrosActuales += rendimientoInversion + ahorroMensual;
            meses++;
        }
        return meses;
    }
}
