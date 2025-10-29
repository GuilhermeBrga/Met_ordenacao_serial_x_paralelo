package selection_sort;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Selection_sort_paralelo {

    private final int[] array;
    private final int numThreads;

    public Selection_sort_paralelo(int[] input_array, int numThreads) {
        this.array = input_array.clone();
        this.numThreads = numThreads;
    }

    public long order() throws InterruptedException {
        int length = array.length;

        LocalTime inicio = LocalTime.now();
        long tempoInicio = System.currentTimeMillis();

        int bloco = length / numThreads;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int t = 0; t < numThreads; t++) {
            int inicioBloco = t * bloco;
            int fimBloco = (t == numThreads - 1) ? length : inicioBloco + bloco;

            executor.submit(() -> selectionSortBloco(inicioBloco, fimBloco));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        mergePartes(bloco, numThreads, length);

        LocalTime fim = LocalTime.now();
        long tempoFim = System.currentTimeMillis();
        long duracao = tempoFim - tempoInicio;

        System.out.println("Início da ordenação: " + inicio);
        System.out.println("Fim da ordenação: " + fim);
        System.out.println("Tempo total: " + duracao + " ms");

        return duracao;
    }

    private void selectionSortBloco(int inicio, int fim) {
        for (int i = inicio; i < fim - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < fim; j++) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }
            if (menor != i) {
                int aux = array[i];
                array[i] = array[menor];
                array[menor] = aux;
            }
        }
    }

    private void mergePartes(int bloco, int numThreads, int length) {
        int[] resultado = new int[length];
        int[] indices = new int[numThreads];
        int[][] partes = new int[numThreads][];

        for (int t = 0; t < numThreads; t++) {
            int inicio = t * bloco;
            int fim = (t == numThreads - 1) ? length : inicio + bloco;
            partes[t] = Arrays.copyOfRange(array, inicio, fim);
        }

        for (int k = 0; k < length; k++) {
            int menorValor = Integer.MAX_VALUE;
            int menorParte = -1;

            for (int t = 0; t < numThreads; t++) {
                if (indices[t] < partes[t].length && partes[t][indices[t]] < menorValor) {
                    menorValor = partes[t][indices[t]];
                    menorParte = t;
                }
            }

            resultado[k] = menorValor;
            indices[menorParte]++;
        }

        System.arraycopy(resultado, 0, array, 0, length);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
