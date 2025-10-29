package csv;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class CsvGen {

    public static void gerarCSV(Map<String, Long> bubble,
                                Map<String, Long> insertion,
                                Map<String, Long> quick,
                                Map<String, Long> selection) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nDigite o nome do arquivo: ");
        String fileName = sc.nextLine() + ".csv";

        try (FileWriter writer = new FileWriter(fileName)) {

            writer.append("Algoritmo,Versão,Tempo(ms)\n");

            for (Map.Entry<String, Long> entry : bubble.entrySet()) {
                writer.append("Bubble Sort,")
                        .append(entry.getKey())
                        .append(",")
                        .append(String.valueOf(entry.getValue()))
                        .append("\n");
            }

            for (Map.Entry<String, Long> entry : insertion.entrySet()) {
                writer.append("Insertion Sort,")
                        .append(entry.getKey())
                        .append(",")
                        .append(String.valueOf(entry.getValue()))
                        .append("\n");
            }

            for (Map.Entry<String, Long> entry : quick.entrySet()) {
                writer.append("Quick Sort,")
                        .append(entry.getKey())
                        .append(",")
                        .append(String.valueOf(entry.getValue()))
                        .append("\n");
            }

            for (Map.Entry<String, Long> entry : selection.entrySet()) {
                writer.append("Selection Sort,")
                        .append(entry.getKey())
                        .append(",")
                        .append(String.valueOf(entry.getValue()))
                        .append("\n");
            }

            System.out.println("\nCSV gerado com sucesso: " + fileName);

        } catch (IOException e) {
            System.err.println("Erro ao gerar o arquivo CSV: " + e.getMessage());
            throw e;
        }
    }
}
