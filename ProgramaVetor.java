package vetores.app;

import javax.swing.JOptionPane;
import vetores.service.VetorService;

/**
 * Classe principal do programa Vetor de Números.
 * Lê 5 números inteiros e exibe: maior par, menor ímpar, soma e média.
 */
public class ProgramaVetor {

    public static void main(String[] args) {

        VetorService servico = new VetorService();
        int[] numeros = new int[5];

        // Leitura dos 5 números com validação de entrada
        for (int i = 0; i < numeros.length; i++) {
            boolean entradaValida = false;

            while (!entradaValida) {
                String entrada = JOptionPane.showInputDialog(
                    null,
                    "Digite o " + (i + 1) + "º número inteiro:",
                    "Vetor de Números",
                    JOptionPane.QUESTION_MESSAGE
                );

                // Verifica se o usuário cancelou
                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    System.exit(0);
                }

                // Tenta converter para inteiro
                try {
                    numeros[i] = Integer.parseInt(entrada.trim());
                    entradaValida = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Entrada inválida! Digite apenas números inteiros.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }

        // Realiza os cálculos usando o serviço
        int maiorPar   = servico.maiorPar(numeros);
        int menorImpar = servico.menorImpar(numeros);
        int soma       = servico.calcularSoma(numeros);
        double media   = servico.calcularMedia(numeros);

        // Monta o texto de resultado
        StringBuilder resultado = new StringBuilder();
        resultado.append("=== Resultado ===\n\n");

        if (maiorPar == Integer.MIN_VALUE) {
            resultado.append("Maior par: Nenhum número par encontrado\n");
        } else {
            resultado.append("Maior par: ").append(maiorPar).append("\n");
        }

        if (menorImpar == Integer.MAX_VALUE) {
            resultado.append("Menor ímpar: Nenhum número ímpar encontrado\n");
        } else {
            resultado.append("Menor ímpar: ").append(menorImpar).append("\n");
        }

        resultado.append("Soma: ").append(soma).append("\n");
        resultado.append("Média: ").append(String.format("%.2f", media));

        // Exibe o resultado
        JOptionPane.showMessageDialog(
            null,
            resultado.toString(),
            "Vetor de Números - Resultado",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
