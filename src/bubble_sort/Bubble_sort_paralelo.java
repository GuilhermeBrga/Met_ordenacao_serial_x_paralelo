package bubble_sort;

import java.time.LocalTime;
import java.util.Arrays;

public class Bubble_sort_paralelo {

    private final int[] array;
    private final int numThreads;

    public Bubble_sort_paralelo(int[] input_array, int numThreads) {
        this.array = input_array.clone(); // Clona o array original
        this.numThreads = numThreads;
    }

    public long order() throws InterruptedException {
        int length_array = this.array.length;

        LocalTime inicio = LocalTime.now();
        long tempoInicio = System.currentTimeMillis();

        Thread[] threads = new Thread[numThreads];

        for (int passo = 0; passo < length_array; passo++) {

            int inicioIndice = passo % 2;

            for (int t = 0; t < numThreads; t++) {
                int threadIndex = t;
                threads[t] = new Thread(() -> {
                    for (int j = inicioIndice + threadIndex * 2; j < length_array - 1; j += numThreads * 2) {
                        if (array[j] > array[j + 1]) {
                            int aux = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = aux;
                        }
                    }
                });
                threads[t].start();
            }

            for (Thread thread : threads) {
                thread.join();
            }
        }

        LocalTime fim = LocalTime.now();
        long tempoFim = System.currentTimeMillis();
        long duracao = tempoFim - tempoInicio;

        System.out.println("Início da ordenação: " + inicio);
        System.out.println("Fim da ordenação: " + fim);
        System.out.println("Tempo total: " + duracao + " ms");

        return duracao;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
