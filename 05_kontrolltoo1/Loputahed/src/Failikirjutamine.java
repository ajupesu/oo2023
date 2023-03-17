import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Failikirjutamine {
    public static void failide_kirjutamine_loputahtedele(String fileName) throws IOException {
        Map<Character, Integer> tahtede_luger = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            // teeb rea tähtedeks
            String[] words = line.split("\\s+");

            for (String word : words) {
                // leiab lõpu tähe(tühik, tab ja muu empty koht ei sobi)
                if (!word.isEmpty()) {
                    char loputaht = word.charAt(word.length() - 1);

                    // teeb faili lõputähe jaoks
                    String tahe_fail = Character.toString(loputaht) + ".txt";
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tahe_fail, true));

                    // kirjutab sõna faili
                    writer.write(word);
                    writer.newLine();

                    writer.close();

                    tahtede_luger.put(loputaht, tahtede_luger.getOrDefault(loputaht, 0) + 1);
                }
            }
        }
        reader.close();

        // teeb faili iga tähe arvu kohta
        BufferedWriter countWriter = new BufferedWriter(new FileWriter("lõputähtede_arvud.txt"));

        // kirjutab faili mitu sõna iga tähe lõpuga on
        for (Map.Entry<Character, Integer> entry : tahtede_luger.entrySet()) {
            countWriter.write(entry.getKey() + ": " + entry.getValue());
            countWriter.newLine();
        }
        countWriter.close();
    }
}
