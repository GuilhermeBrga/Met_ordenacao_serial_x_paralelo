package quick_sort;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Quick_sort_paralelo {

    private final int[] array;
    private final int numThreads;

    public Quick_sort_paralelo(int[] input_array, int numThreads) {
        this.array = input_array.clone();
        this.numThreads = numThreads;
    }

    public long order() {
        LocalTime inicio = LocalTime.now();
        long tempoInicio = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool(numThreads);
        pool.invoke(new QuickSortTask(array, 0, array.length - 1));
        pool.shutdown();

        LocalTime fim = LocalTime.now();
        long tempoFim = System.currentTimeMillis();
        long duracao = tempoFim - tempoInicio;

        System.out.println("Início da ordenação: " + inicio);
        System.out.println("Fim da ordenação: " + fim);
        System.out.println("Tempo total: " + duracao + " ms");

        return duracao;
    }

    private static class QuickSortTask extends RecursiveAction {
        private final int[] array;
        private final int inicio;
        private final int fim;
        private static final int LIMITE_SEQUENCIAL = 10_000;

        public QuickSortTask(int[] array, int inicio, int fim) {
            this.array = array;
            this.inicio = inicio;
            this.fim = fim;
        }

        @Override
        protected void compute() {
            if (inicio < fim) {
                if (fim - inicio < LIMITE_SEQUENCIAL) {
                    quickSortSequencial(inicio, fim);
                } else {
                    int pivo = particionar(inicio, fim);
                    QuickSortTask left = new QuickSortTask(array, inicio, pivo - 1);
                    QuickSortTask right = new QuickSortTask(array, pivo + 1, fim);
                    invokeAll(left, right);
                }
            }
        }

        private void quickSortSequencial(int start, int end) {
            if (start < end) {
                int indicePivo = particionar(start, end);
                quickSortSequencial(start, indicePivo - 1);
                quickSortSequencial(indicePivo + 1, end);
            }
        }

        private int particionar(int start, int end) {
            int pivo = array[end];
            int i = start - 1;

            for (int j = start; j < end; j++) {
                if (array[j] <= pivo) {
                    i++;
                    trocar(i, j);
                }
            }

            trocar(i + 1, end);
            return i + 1;
        }

        private void trocar(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
