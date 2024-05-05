import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double valorMoeda;
        Integer opcao = 0;
        ConversorMoeda conversorMoeda = new ConversorMoeda();
        conversorMoeda.carregarTaxasDeCambio();

        System.out.println("""
                \n************************************
                
                Bem-vindo ao conversor de moedas.
                Digite uma das opções abaixo:
                
                [1] para ver a lista de moedas.
                [2] para converter de BRL para USD.
                [3] para converter de USD para BRL.
                [4] para converter de BRL para EUR.
                [5] para converter de EUR para BRL.
                [6] Sair. 
               
                \n*****************************************
                """);

        while (opcao != 7) {
            System.out.print("Digite o número da opção desejada: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Lista de moedas disponíveis:");
                    conversorMoeda.mostrarMoedasDisponiveis();
                    break;

                case 2:
                    System.out.print("Digite a moeda de origem: ");
                    String moedaOrigem = sc.next();
                    System.out.print("Digite a moeda de destino: ");
                    String moedaDestino = sc.next();
                    System.out.print("Digite o valor a ser convertido: ");
                    valorMoeda = sc.nextDouble();
                    double valorConvertido = conversorMoeda.converter(valorMoeda, moedaOrigem, moedaDestino);
                    if (valorConvertido != -1) {
                        System.out.printf("Valor convertido: %.2f %s%n", valorConvertido, moedaDestino);
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor em BRL a ser convertido para USD: ");
                    valorMoeda = sc.nextDouble();
                    double valorConvertidoUSD = conversorMoeda.converterDeBRLparaUSD(valorMoeda);
                    if (valorConvertidoUSD != -1) {
                        System.out.printf("Valor convertido: %.2f USD%n", valorConvertidoUSD);
                    }
                    break;

                case 4:
                    System.out.print("Digite o valor em USD a ser convertido para BRL: ");
                    valorMoeda = sc.nextDouble();
                    double valorConvertidoBRL = conversorMoeda.converterDeUSDparaBRL(valorMoeda);
                    if (valorConvertidoBRL != -1) {
                        System.out.printf("Valor convertido: %.2f BRL%n", valorConvertidoBRL);
                    }
                    break;

                case 5:
                    System.out.print("Digite o valor em BRL a ser convertido para EUR: ");
                    valorMoeda = sc.nextDouble();
                    double valorConvertidoEUR = conversorMoeda.converterDeBRLparaEUR(valorMoeda);
                    if (valorConvertidoEUR != -1) {
                        System.out.printf("Valor convertido: %.2f EUR%n", valorConvertidoEUR);
                    }
                    break;

                case 6:
                    System.out.print("Digite o valor em EUR a ser convertido para BRL: ");
                    valorMoeda = sc.nextDouble();
                    double valorConvertidoBRL2 = conversorMoeda.converterDeEURparaBRL(valorMoeda);
                    if (valorConvertidoBRL2 != -1) {
                        System.out.printf("Valor convertido: %.2f BRL%n", valorConvertidoBRL2);
                    }
                    break;

                case 7:
                    System.out.println("Operação finalizada!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        System.out.println("Obrigado por usar o conversor de moedas!");
    }
}

