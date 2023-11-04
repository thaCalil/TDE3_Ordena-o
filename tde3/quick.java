package tde4;

import java.util.Random;

// TDE3 - Ordenação - BubbleSort - Thaíssa V. Calil

class quicksort {
    private static int trocas = 0;
    private static int iteracoes = 0;

    // método principal do quick sort
    public static void quick(int[] array, int baixo, int alto) {
        if (baixo < alto) {
            int pi = particiona(array, baixo, alto);// encontra um ponto com o particiona
            // recursividade para chamar as duas metades
            quick(array, baixo, pi - 1);
            quick(array, pi + 1, alto);
        }
    }

    // método do particiona
    static int particiona(int[] x, int inferior, int superior) {
        int pivot = x[superior]; // escolhe o pivô(último número)
        int i = (inferior - 1); 

        // particio o array com o pivô
        for (int j = inferior; j <= superior - 1; j++) {
            if (x[j] < pivot) {
                i++; 
                // troca os números
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
                trocas++;
            }
            iteracoes++;
        }
        // troca o lugar do pivô
        int temp = x[i + 1];
        x[i + 1] = x[superior];
        x[superior] = temp;
        trocas++;

        return (i + 1);
    }

    public static int getTrocas() {
        return trocas;
    }

    public static int getIteracoes() {
        return iteracoes;
    }
}

public class quick {
    public static void main(String[] args) {
        // cria 50 números aleatórios e os coloca no vetor
        int[] vetor = new int[50];
        Random rand = new Random(); 

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(100000);
        }

        long quick1 = System.nanoTime(); // começa a medir o tempo
        quicksort.quick(vetor, 0, vetor.length - 1);
        long quick2 = System.nanoTime(); // para de medir o tempo
        long duracao = (quick2 - quick1); // calcula o tempo final

        System.out.println("Tempo de execução: " + duracao + " ns");
        System.out.println("Quantidade de trocas: " + quicksort.getTrocas());
        System.out.println("Quantidade de Iterações: " + quicksort.getIteracoes());
        
        /*for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " \n");
        }*/
    }
}