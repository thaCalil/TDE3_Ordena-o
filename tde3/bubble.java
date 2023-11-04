package tde3;

import java.util.Random;

// TDE3 - Ordenação - BubbleSort - Thaíssa V. Calil

class bubblesort {
    private static int trocas = 0;
    private static int iteracoes = 0;

    // método principal do bubble sort
    public static void bubble(int[] vetor) {
        int n = vetor.length;
        int temp = 0;
        // loop passa pelos números do array
        for(int i=0; i < n; i++){
            // loop para os números restantes
            for(int j=1; j < (n-i); j++){
                iteracoes++;
                // se o número for maior que o próximo
                if(vetor[j-1] > vetor[j]){
                    //trocar os números
                    temp = vetor[j-1];
                    vetor[j-1] = vetor[j];
                    vetor[j] = temp;
                    trocas++;
                }
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

public class bubble {
    public static void main(String[] args) {
        // cria 50 números aleatórios e os coloca no vetor
        int[] vetor = new int[50];
        Random rand = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(100000);
        }

        long bubble1 = System.nanoTime(); // começa a medir o tempo
        bubblesort.bubble(vetor);
        long bubble2 = System.nanoTime(); // para de medir o tempo
        long duracao = (bubble2 - bubble1); // calcula o tempo final

        System.out.println("Tempo de execu��o: " + duracao + " ns");
        System.out.println("Quantidade de trocas: " + bubblesort.getTrocas());
        System.out.println("Quantidade de itera��es: " + bubblesort.getIteracoes());
        
        /*for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " \n");
        }*/
    }
}
