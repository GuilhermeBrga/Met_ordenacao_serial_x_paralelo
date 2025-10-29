package insertion_sort;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.*;

public class Insertion_sort_paralelo {

    private final int[] array;
    private final int numThreads;

    public Insertion_sort_paralelo(int[] input_array, int numThreads) {
        this.array = input_array.clone();
        this.numThreads = numThreads;
    }

    public long order() throws InterruptedException, ExecutionException {
        int length = this.array.length;
        int chunkSize = (int) Math.ceil((double) length / numThreads);

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        LocalTime inicio = LocalTime.now();
        long tempoInicio = System.currentTimeMillis();

        Future<?>[] futures = new Future<?>[numThreads];
        for (int t = 0; t < numThreads; t++) {
            int start = t * chunkSize;
            int end = Math.min(start + chunkSize, length);

            if (start >= end) break;

            futures[t] = executor.submit(() -> insertionSort(array, start, end));
        }

        for (Future<?> f : futures) {
            if (f != null) f.get(); // Espera todas as threads terminarem
        }

        executor.shutdown();

        mergeSortedChunks(chunkSize);

        long tempoFim = System.currentTimeMillis();
        LocalTime fim = LocalTime.now();
        long duracao = tempoFim - tempoInicio;

        System.out.println("Início da ordenação: " + inicio);
        System.out.println("Fim da ordenação: " + fim);
        System.out.println("Tempo total: " + duracao + " ms");
        System.out.println("Threads utilizadas: " + numThreads);

        return duracao;
    }

    private static void insertionSort(int[] arr, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private void mergeSortedChunks(int chunkSize) {
        int length = array.length;
        int[] temp = Arrays.copyOf(array, length);

        for (int step = chunkSize; step < length; step *= 2) {
            for (int start = 0; start < length; start += 2 * step) {
                int mid = Math.min(start + step, length);
                int end = Math.min(start + 2 * step, length);
                merge(temp, array, start, mid, end);
            }
            System.arraycopy(array, 0, temp, 0, length);
        }
    }

    private static void merge(int[] src, int[] dest, int start, int mid, int end) {
        int i = start, j = mid, k = start;
        while (i < mid && j < end) {
            if (src[i] <= src[j]) {
                dest[k++] = src[i++];
            } else {
                dest[k++] = src[j++];
            }
        }
        while (i < mid) dest[k++] = src[i++];
        while (j < end) dest[k++] = src[j++];
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
