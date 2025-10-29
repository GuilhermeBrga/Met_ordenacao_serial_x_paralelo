package selection_sort;
import java.time.LocalTime;
import java.util.Arrays;

public class Selection_sort_serial {

    private int[] array;

    public Selection_sort_serial(int[] input_array){
        this.array = input_array.clone();
    }

    public long order(){
        int lenght_array = this.array.length;
        int i;
        int j;

        LocalTime inicio = LocalTime.now();
        long tempoInicio = System.currentTimeMillis();

        for(i = 0; i < lenght_array; i++){

            int menor = i;

            for(j = menor + 1; j < lenght_array; j++){
                if(array[j] < array[menor]) {
                    menor = j;
                }
            }

            if(menor != i) {
                int aux = array[i];
                array[i] = array[menor];
                array[menor] = aux;
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
    public String toString(){
        return Arrays.toString(this.array);
    }
}
