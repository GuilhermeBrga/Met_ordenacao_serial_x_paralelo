import reader.*;
import bubble_sort.*;
import insertion_sort.*;
import quick_sort.*;
import selection_sort.*;
import GUI.*;
import csv.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        String path_5000 = "C:\\Users\\guilh\\IdeaProjects\\met_ordenacao\\src\\data\\data_5000.txt";
        String path_500 = "C:\\Users\\guilh\\IdeaProjects\\met_ordenacao\\src\\data\\data_500.txt";
        String path_1m = "C:\\Users\\guilh\\IdeaProjects\\met_ordenacao\\src\\data\\data_1m.txt";

        int[] array = Reader.readFile(path_5000);
        //int[] array = Reader.readFile(path_500);
        //int[] array = Reader.readFile(path_1m);

        Map<String, Long> bubble_grafico = new LinkedHashMap<>();
        Map<String, Long> insert_grafico = new LinkedHashMap<>();
        Map<String, Long> quick_grafico = new LinkedHashMap<>();
        Map<String, Long> selection_grafico = new LinkedHashMap<>();

        // ======== Bubble Sort Serial ========
        Bubble_sort_serial bs = new Bubble_sort_serial(array);
        System.out.println("============= Bubble sort serial ==============");
        long duracao_bs = bs.order();
        bubble_grafico.put("Bubble Sort Serial", duracao_bs);

        // ======== Bubble Sort Paralelo (2 threads) ========
        Bubble_sort_paralelo bp2 = new Bubble_sort_paralelo(array, 2);
        System.out.println("============= Bubble sort paralelo (2 threads) ==============");
        long duracao_bp2 = bp2.order();
        bubble_grafico.put("Bubble (2 threads)", duracao_bp2);

        // ======== Bubble Sort Paralelo (4 threads) ========
        Bubble_sort_paralelo bp4 = new Bubble_sort_paralelo(array, 4);
        System.out.println("============= Bubble sort paralelo (4 threads) ==============");
        long duracao_bp4 = bp4.order();
        bubble_grafico.put("Bubble (4 threads)", duracao_bp4);

        // ======== Bubble Sort Paralelo (6 threads) ========
        Bubble_sort_paralelo bp6 = new Bubble_sort_paralelo(array, 6);
        System.out.println("============= Bubble sort paralelo (6 threads) ==============");
        long duracao_bp6 = bp6.order();
        bubble_grafico.put("Bubble (6 threads)", duracao_bp6);

        // ======== Bubble Sort Paralelo (8 threads) ========
        Bubble_sort_paralelo bp8 = new Bubble_sort_paralelo(array, 8);
        System.out.println("============= Bubble sort paralelo (8 threads) ==============");
        long duracao_bp8 = bp8.order();
        bubble_grafico.put("Bubble (8 threads)", duracao_bp8);

        // ======== Bubble Sort Paralelo (10 threads) ========
        Bubble_sort_paralelo bp10 = new Bubble_sort_paralelo(array, 10);
        System.out.println("============= Bubble sort paralelo (10 threads) ==============");
        long duracao_bp10 = bp10.order();
        bubble_grafico.put("Bubble (10 threads)", duracao_bp10);

        // ======== Insertion Sort Serial ========
        Insertion_sort_serial is = new Insertion_sort_serial(array);
        System.out.println("============= Insertion sort serial ==============");
        long duracao_is = is.order();
        insert_grafico.put("Insertion Sort Serial", duracao_is);

        // ======== Insertion Sort Paralelo (2 threads) ========
        Insertion_sort_paralelo ip2 = new Insertion_sort_paralelo(array, 2);
        System.out.println("============= Insertion sort paralelo (2 threads) ==============");
        long duracao_ip2 = ip2.order();
        insert_grafico.put("Insertion Sort (2 threads)", duracao_ip2);

        // ======== Insertion Sort Paralelo (4 threads) ========
        Insertion_sort_paralelo ip4 = new Insertion_sort_paralelo(array, 4);
        System.out.println("============= Insertion sort paralelo (4 threads) ==============");
        long duracao_ip4 = ip4.order();
        insert_grafico.put("Insertion Sort (4 threads)", duracao_ip4);

        // ======== Insertion Sort Paralelo (6 threads) ========
        Insertion_sort_paralelo ip6 = new Insertion_sort_paralelo(array, 6);
        System.out.println("============= Insertion sort paralelo (6 threads) ==============");
        long duracao_ip6 = ip6.order();
        insert_grafico.put("Insertion Sort (6 threads)", duracao_ip6);

        // ======== Insertion Sort Paralelo (8 threads) ========
        Insertion_sort_paralelo ip8 = new Insertion_sort_paralelo(array, 8);
        System.out.println("============= Insertion sort paralelo (8 threads) ==============");
        long duracao_ip8 = ip8.order();
        insert_grafico.put("Insertion Sort (8 threads)", duracao_ip8);

        // ======== Insertion Sort Paralelo (10 threads) ========
        Insertion_sort_paralelo ip10 = new Insertion_sort_paralelo(array, 10);
        System.out.println("============= Insertion sort paralelo (10 threads) ==============");
        long duracao_ip10 = ip10.order();
        insert_grafico.put("Insertion Sort (10 threads)", duracao_ip10);

        // ======== Quick Sort Serial ========
        Quick_sort_serial qs = new Quick_sort_serial(array);
        System.out.println("============= Quick sort serial ==============");
        long duracao_qs = qs.order();
        quick_grafico.put("Quick Sort Serial", duracao_qs);

        // ======== Quick Sort Paralelo (2 threads) ========
        Quick_sort_paralelo qp2 = new Quick_sort_paralelo(array, 2);
        System.out.println("============= Quick sort paralelo (2 threads) ==============");
        long duracao_qp2 = qp2.order();
        quick_grafico.put("Quick Sort (2 threads)", duracao_qp2);

        // ======== Quick Sort Paralelo (4 threads) ========
        Quick_sort_paralelo qp4 = new Quick_sort_paralelo(array, 4);
        System.out.println("============= Quick sort paralelo (4 threads) ==============");
        long duracao_qp4 = qp4.order();
        quick_grafico.put("Quick Sort (4 threads)", duracao_qp4);

        // ======== Quick Sort Paralelo (6 threads) ========
        Quick_sort_paralelo qp6 = new Quick_sort_paralelo(array, 6);
        System.out.println("============= Quick sort paralelo (6 threads) ==============");
        long duracao_qp6 = qp6.order();
        quick_grafico.put("Quick Sort (6 threads)", duracao_qp6);

        // ======== Quick Sort Paralelo (8 threads) ========
        Quick_sort_paralelo qp8 = new Quick_sort_paralelo(array, 8);
        System.out.println("============= Quick sort paralelo (8 threads) ==============");
        long duracao_qp8 = qp8.order();
        quick_grafico.put("Quick Sort (8 threads)", duracao_qp8);

        // ======== Quick Sort Paralelo (10 threads) ========
        Quick_sort_paralelo qp10 = new Quick_sort_paralelo(array, 10);
        System.out.println("============= Quick sort paralelo (10 threads) ==============");
        long duracao_qp10 = qp10.order();
        quick_grafico.put("Quick Sort (10 threads)", duracao_qp10);

        // ======== Selection Sort Serial ========
        Selection_sort_serial ss = new Selection_sort_serial(array);
        System.out.println("============= Selection sort serial ==============");
        long duracao_ss = ss.order();
        selection_grafico.put("Selection Sort Serial", duracao_ss);

        // ======== Insertion Sort Paralelo (2 threads) ========
        Selection_sort_paralelo sp2 = new Selection_sort_paralelo(array, 2);
        System.out.println("============= Selection sort paralelo (2 threads) ==============");
        long duracao_sp2 = sp2.order();
        selection_grafico.put("Selection Sort (2 threads)", duracao_sp2);

        // ======== Insertion Sort Paralelo (4 threads) ========
        Selection_sort_paralelo sp4 = new Selection_sort_paralelo(array, 4);
        System.out.println("============= Selection sort paralelo (4 threads) ==============");
        long duracao_sp4 = sp4.order();
        selection_grafico.put("Selection Sort (4 threads)", duracao_sp4);

        // ======== Insertion Sort Paralelo (6 threads) ========
        Selection_sort_paralelo sp6 = new Selection_sort_paralelo(array, 6);
        System.out.println("============= Selection sort paralelo (6 threads) ==============");
        long duracao_sp6 = sp6.order();
        selection_grafico.put("Selection Sort (6 threads)", duracao_sp6);

        // ======== Insertion Sort Paralelo (8 threads) ========
        Selection_sort_paralelo sp8 = new Selection_sort_paralelo(array, 8);
        System.out.println("============= Selection sort paralelo (8 threads) ==============");
        long duracao_sp8 = sp8.order();
        selection_grafico.put("Selection Sort (8 threads)", duracao_sp8);

        // ======== Insertion Sort Paralelo (10 threads) ========
        Selection_sort_paralelo sp10 = new Selection_sort_paralelo(array, 10);
        System.out.println("============= Selection sort paralelo (10 threads) ==============");
        long duracao_sp10 = sp10.order();
        selection_grafico.put("Selection Sort (10 threads)", duracao_sp10);

        // ======== Gera o gráfico ========
        Grafico.gerarGrafico(bubble_grafico, "Tempo de execução do Bubble Sorte");
        Grafico.gerarGrafico(insert_grafico, "Tempo de execução do Insertion Sort");
        Grafico.gerarGrafico(quick_grafico, "Tempo de execução do Quick Sort");
        Grafico.gerarGrafico(selection_grafico, "Tempo de execução do Selection Sort");

        CsvGen.gerarCSV(bubble_grafico, insert_grafico, quick_grafico, selection_grafico);
    }
}
