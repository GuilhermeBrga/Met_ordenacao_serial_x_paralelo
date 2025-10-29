package bubble_sort;

import java.util.Arrays;
import java.time.LocalTime;

public class Bubble_sort_serial {

    private final int[] array;

    public Bubble_sort_serial(int[] input_array) {
        this.array = input_array.clone();
    }

    public long order() {
        int length_array = this.array.length;
        int aux;

        LocalTime inicio = LocalTime.now();
        long tempoInicio = System.currentTimeMillis();

        for (int i = 0; i < length_array; i++) {
            for (int j = 0; j < length_array - 1; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    aux = this.array[j];
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = aux;
                }
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
