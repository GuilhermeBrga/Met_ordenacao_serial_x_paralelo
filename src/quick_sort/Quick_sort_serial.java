package quick_sort;

import java.util.Arrays;
import java.time.LocalTime;

public class Quick_sort_serial {

    private int[] array;

    public Quick_sort_serial(int[] input_array) {
        this.array = input_array.clone();
    }

    public long order() {
        LocalTime inicio = LocalTime.now();
        long tempoInicio = System.currentTimeMillis();


        quickSort(0, array.length - 1);

        LocalTime fim = LocalTime.now();
        long tempoFim = System.currentTimeMillis();
        long duracao = tempoFim - tempoInicio;

        System.out.println("Início da ordenação: " + inicio);
        System.out.println("Fim da ordenação: " + fim);
        System.out.println("Tempo total: " + duracao + " ms");

        return duracao;
    }

    private void quickSort(int start, int end) {
        if (start < end) {
            int indicePivo = particionar(start, end);
            quickSort(start, indicePivo - 1);
            quickSort(indicePivo + 1, end);
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

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
