package vetores.service;

/**
 * Classe responsável pela lógica de operações com vetores.
 */
public class VetorService {

    // Retorna o maior número par do vetor, ou Integer.MIN_VALUE se não houver
    public int maiorPar(int[] vetor) {
        int maiorPar = Integer.MIN_VALUE;
        boolean encontrou = false;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                if (!encontrou || vetor[i] > maiorPar) {
                    maiorPar = vetor[i];
                    encontrou = true;
                }
            }
        }

        if (!encontrou) {
            return Integer.MIN_VALUE; // sinal de que não existe
        }
        return maiorPar;
    }

    // Retorna o menor número ímpar do vetor, ou Integer.MAX_VALUE se não houver
    public int menorImpar(int[] vetor) {
        int menorImpar = Integer.MAX_VALUE;
        boolean encontrou = false;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 != 0) {
                if (!encontrou || vetor[i] < menorImpar) {
                    menorImpar = vetor[i];
                    encontrou = true;
                }
            }
        }

        if (!encontrou) {
            return Integer.MAX_VALUE; // sinal de que não existe
        }
        return menorImpar;
    }

    // Calcula a soma de todos os elementos do vetor
    public int calcularSoma(int[] vetor) {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }
        return soma;
    }

    // Calcula a média dos elementos do vetor
    public double calcularMedia(int[] vetor) {
        return (double) calcularSoma(vetor) / vetor.length;
    }
}
