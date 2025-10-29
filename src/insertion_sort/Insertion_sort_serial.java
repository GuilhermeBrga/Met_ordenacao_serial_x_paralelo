package insertion_sort;
import java.time.LocalTime;
import java.util.Arrays;

public class Insertion_sort_serial {

    private final int[] array;

    public Insertion_sort_serial(int[] input_array){
        this.array = input_array.clone();
    }

    public long order(){
        int lenght_array = this.array.length;
        int key;
        int i;
        int j;

        LocalTime inicio = LocalTime.now();
        long tempoInicio = System.currentTimeMillis();

        for(i = 1; i < lenght_array; i++){
            key = this.array[i];

            for(j = i - 1; (j >= 0) && (this.array[j] > key); j--){
                this.array[j + 1] = this.array[j];
            }
            this.array[j + 1] = key;
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
    public String toString(){
        return Arrays.toString(this.array);
    }
}
