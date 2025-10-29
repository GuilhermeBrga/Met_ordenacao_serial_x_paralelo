package reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Reader {

    public static int[] readFile(String path) throws IOException {

        List<String> linhas = Files.readAllLines(Paths.get(path));

        int[] numeros = new int[linhas.size()];

        for (int i = 0; i < linhas.size(); i++) {
            numeros[i] = Integer.parseInt(linhas.get(i).trim());
        }

        return numeros;
    }
}
