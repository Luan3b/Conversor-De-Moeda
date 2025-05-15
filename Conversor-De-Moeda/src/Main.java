import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner leitura = new Scanner(System.in);
        String[] moedas = {"USD", "ARS", "BRL", "COP"};

        while (true) {


            System.out.println("\n------------------------------");
            System.out.println("Seja bem-vindo ao conversor de Moeda ");
            System.out.println("1 - Dólar");
            System.out.println("2 - Peso argentino");
            System.out.println("3 - Real brasileiro");
            System.out.println("4 - Peso colombiano");
            System.out.println("5 - Sair");
            System.out.println("Escolha a moeda de origem: ");
            int origem = leitura.nextInt();

            if (origem == 5) break;
            if (origem < 1 || origem > 4) {
                System.out.println("Opção inválida!");
                continue;
            }
            System.out.print("Escolha a moeda de destino: ");
            int destino = leitura.nextInt();

            if (destino == 5) break;
            if (destino < 1 || destino > 4) {
                System.out.println("Opção inválida!");
                continue;
            }
            System.out.print("Digite o valor a ser convertido: ");
            double valor = leitura.nextDouble();

            String moedaOrigem = moedas[origem - 1];
            String moedaDestino = moedas[destino - 1];

            if (moedaOrigem.equals(moedaDestino)) {
                System.out.println(" Mesma moeda selecionada. Resultado: " + valor);
            } else {
                ConversorMoeda.converter(moedaOrigem, moedaDestino, valor);


            }
        }
        System.out.println("Obrigado por usar o conversor!");
        leitura.close();
    }
}