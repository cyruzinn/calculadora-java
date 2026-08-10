import java.util.Scanner;

/**
 * Calculadora simples com operações básicas e algumas extras.
 * Autor: Jean Carlos dos Santos Tápparo
 */
public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== Calculadora ===");

        while (continuar) {
            exibirMenu();
            int opcao = lerInteiro(scanner, "Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    calcularSoma(scanner);
                    break;
                case 2:
                    calcularSubtracao(scanner);
                    break;
                case 3:
                    calcularMultiplicacao(scanner);
                    break;
                case 4:
                    calcularDivisao(scanner);
                    break;
                case 5:
                    calcularPorcentagem(scanner);
                    break;
                case 6:
                    calcularIMC(scanner);
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Encerrando a calculadora. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nEscolha uma operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("5 - Porcentagem");
        System.out.println("6 - Cálculo de IMC");
        System.out.println("0 - Sair");
    }

    private static void calcularSoma(Scanner scanner) {
        double a = lerDouble(scanner, "Digite o primeiro número: ");
        double b = lerDouble(scanner, "Digite o segundo número: ");
        System.out.printf("Resultado: %.2f%n", a + b);
    }

    private static void calcularSubtracao(Scanner scanner) {
        double a = lerDouble(scanner, "Digite o primeiro número: ");
        double b = lerDouble(scanner, "Digite o segundo número: ");
        System.out.printf("Resultado: %.2f%n", a - b);
    }

    private static void calcularMultiplicacao(Scanner scanner) {
        double a = lerDouble(scanner, "Digite o primeiro número: ");
        double b = lerDouble(scanner, "Digite o segundo número: ");
        System.out.printf("Resultado: %.2f%n", a * b);
    }

    private static void calcularDivisao(Scanner scanner) {
        double a = lerDouble(scanner, "Digite o primeiro número: ");
        double b = lerDouble(scanner, "Digite o segundo número (diferente de zero): ");

        if (b == 0) {
            System.out.println("Erro: não é possível dividir por zero.");
            return;
        }

        System.out.printf("Resultado: %.2f%n", a / b);
    }

    private static void calcularPorcentagem(Scanner scanner) {
        double valor = lerDouble(scanner, "Digite o valor: ");
        double percentual = lerDouble(scanner, "Digite a porcentagem (ex: 10 para 10%%): ");
        double resultado = valor * (percentual / 100);
        System.out.printf("%.2f%% de %.2f é %.2f%n", percentual, valor, resultado);
    }

    private static void calcularIMC(Scanner scanner) {
        double peso = lerDouble(scanner, "Digite seu peso em kg: ");
        double altura = lerDouble(scanner, "Digite sua altura em metros (ex: 1.75): ");

        if (altura <= 0) {
            System.out.println("Erro: altura inválida.");
            return;
        }

        double imc = peso / (altura * altura);
        System.out.printf("Seu IMC é: %.2f - %s%n", imc, classificarIMC(imc));
    }

    private static String classificarIMC(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 25) return "Peso normal";
        if (imc < 30) return "Sobrepeso";
        return "Obesidade";
    }

    private static double lerDouble(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Valor inválido. Digite um número: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido. Digite um número inteiro: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
