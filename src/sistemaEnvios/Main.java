package sistemaEnvios;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double peso;
        int distancia;
        int tarifaBase;
        int recargoDistancia;
        int recargoTipo;
        boolean esValidoPeso;
        String tipoEnvio;
        String resumenPagoEnvio;

        System.out.println("\n--- SISTEMA DE REGISTROS DE ENVÍOS MENSAJERÍA ---");
        do {
            System.out.println("Ingrese el peso del paquete: ");
            peso = scanner.nextInt();
            esValidoPeso = Envios.verificarPeso(peso);
        } while(!esValidoPeso);

        tarifaBase = Envios.calcularTarifaBase(peso);
        System.out.println("La tarifa base del envío es de USD$" + tarifaBase);

        System.out.println("\nIngrese la distancia de entrega: ");
        distancia = scanner.nextInt();
        scanner.nextLine();
        recargoDistancia = Envios.calcularRecargoDistancia(distancia);
        System.out.println("El recargo por distancia es de USD$" + recargoDistancia);

        do {
            System.out.println("\nIngrese el tipo de envio (Normal / Express / Prioritario): ");
            tipoEnvio = scanner.nextLine().toLowerCase();
            recargoTipo = Envios.calcularRecargoTipo(tipoEnvio);
        } while(recargoTipo == -1);

        resumenPagoEnvio = Envios.generarResumen(tarifaBase, recargoDistancia, recargoTipo);
        System.out.println(resumenPagoEnvio);

        scanner.close();
    }
}
