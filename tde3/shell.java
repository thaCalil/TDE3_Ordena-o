package tde4;

import java.util.Random;

// TDE3 - Ordenação - BubbleSort - Thaíssa V. Calil

class shellsort {
    private static int trocas = 0;
    private static int iteracoes = 0;

    // método principal do shell sort
    public static void shell(int[] vetor, int[] incrementos) {
        int incr, j, k, span, y;
        // loop pelos incrementos
        for (incr = 0; incr < incrementos.length; incr++) {
            span = incrementos[incr];
            // loop pelos números do array
            for (j = span; j < vetor.length; j++) {
                y = vetor[j]; 
                // loop pelos números de antes para os de agora
                for (k = j - span; k >= 0; k -= span) { 
                    iteracoes++;
                    if (y < vetor[k]){
                      trocas++; 
                    }      
                }
                vetor[k + span] = y;
            }
        }
    }

    public static int getTrocas() {
        return trocas;
    }

    public static int getIteracoes() {
        return iteracoes;
    }
}

public class shell {
    public static void main(String[] args) {
        // cria 50 números aleatórios e os coloca no vetor
        int[] vetor = new int[50];
        Random rand = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(100000);
        }

        int[] incrementos = {5, 3, 1}; // definição dos incrementos

        long shell1 = System.nanoTime(); // começa a medir o tempo
        shellsort.shell(vetor, incrementos);
        long shell2 = System.nanoTime(); // para de medir o tempo
        long duracao = (shell2 - shell1); // calcula o tempo finaç

        System.out.println("Tempo de execução: " + duracao + " ns");
        System.out.println("Quantidade de trocas: " + shellsort.getTrocas());
        System.out.println("Quantidade iterações: " + shellsort.getIteracoes());
        
        /*for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " \n");
        }*/
    }
}