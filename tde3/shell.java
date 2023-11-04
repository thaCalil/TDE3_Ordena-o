package tde4;

import java.util.Random;

// TDE3 - Ordena��o - BubbleSort - Tha�ssa V. Calil

class shellsort {
    private static int trocas = 0;
    private static int iteracoes = 0;

    // m�todo principal do shell sort
    public static void shell(int[] vetor, int[] incrementos) {
        int incr, j, k, span, y;
        // loop pelos incrementos
        for (incr = 0; incr < incrementos.length; incr++) {
            span = incrementos[incr];
            // loop pelos n�meros do array
            for (j = span; j < vetor.length; j++) {
                y = vetor[j]; 
                // loop pelos n�meros de antes para os de agora
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
        // cria 50 n�meros aleat�rios e os coloca no vetor
        int[] vetor = new int[50];
        Random rand = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(100000);
        }

        int[] incrementos = {5, 3, 1}; // defini��o dos incrementos

        long shell1 = System.nanoTime(); // come�a a medir o tempo
        shellsort.shell(vetor, incrementos);
        long shell2 = System.nanoTime(); // para de medir o tempo
        long duracao = (shell2 - shell1); // calcula o tempo fina�

        System.out.println("Tempo de execu��o: " + duracao + " ns");
        System.out.println("Quantidade de trocas: " + shellsort.getTrocas());
        System.out.println("Quantidade itera��es: " + shellsort.getIteracoes());
        
        /*for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " \n");
        }*/
    }
}