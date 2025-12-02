package sistemaEnvios;

public class Envios {
    public static boolean verificarPeso(double peso) {
        boolean pesoValido = false;

        System.out.println("Verificando validez del peso del paquete...");

        if(peso >= 0 && peso <=50){
           System.out.println("Peso del paquete válido");
           pesoValido = true;
        } else {
                System.out.println("Peso del paquete no válido");
        }

        return pesoValido;
    }

    public static int calcularTarifaBase(double peso) {
        int tarifaBase;

        System.out.println("Calculando recargo por distancia...");

        if(peso <= 1) {
            tarifaBase = 5;
        } else if(peso > 1 && peso <= 5) {
            tarifaBase = 10;
        } else if(peso > 5 && peso <= 20) {
            tarifaBase = 20;
        } else {
            tarifaBase = 50;
        }
        return tarifaBase;
    }

    public static int calcularRecargoDistancia(int distancia) {
        int recargoDistancia;

        System.out.println("Calculando recargo por tipo de envío...");

        if(distancia <= 10) {
            recargoDistancia = 0;
        } else if(distancia >10 && distancia <= 50){
            recargoDistancia = 5;
        } else if(distancia > 50 && distancia <=200) {
            recargoDistancia = 15;
        } else {
            recargoDistancia = 30;
        }

        return recargoDistancia;
    }

    public static int calcularRecargoTipo(String tipoEnvio) {
        int recargoTipoEnvio = 0;

        switch (tipoEnvio) {
            case "normal":
                recargoTipoEnvio = 0;
                System.out.println("El recargo por tipo es de USD$" + recargoTipoEnvio);
                break;
            case "express":
                recargoTipoEnvio = 15;
                System.out.println("El recargo por tipo es de USD$" + recargoTipoEnvio);
                break;
            case "prioritario":
                recargoTipoEnvio = 30;
                System.out.println("El recargo por tipo es de USD$" + recargoTipoEnvio);
                break;
            default:
                System.out.println("Opción inválida para tipo de envío.");
                recargoTipoEnvio = -1;
        }

        return recargoTipoEnvio;
    }

    public static String generarResumen(int tarifaBase, int recargoDistancia, int recargoTipo) {
        String resumenEnvio = "";
        String separadorEnvio = "";
        int totalFinal = tarifaBase + recargoDistancia + recargoTipo;

        for(int i = 1; i <= 30; i++) {
            separadorEnvio = separadorEnvio + '-';
        }
        resumenEnvio = separadorEnvio + "\nTarifa base: USD$" + tarifaBase;
        resumenEnvio = resumenEnvio + "\nRecargo por distancia: USD$" + recargoDistancia;
        resumenEnvio = resumenEnvio + "\nRecargo por tipo de envío: USD$" + recargoTipo;
        resumenEnvio = resumenEnvio + "\nTotal a pagar por el envío: USD$" + totalFinal + "\n";
        resumenEnvio = resumenEnvio + separadorEnvio;

        return resumenEnvio;
    }
}
