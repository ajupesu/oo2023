import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static List<Character> loputahed_sageduse_jarjekorras(String fileName) throws IOException {
        List<Character> loputahed = new ArrayList<>();
        Map<Character, Integer> tahtede_luger = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : line.split("\\s+")) { // vaatab et ei loeks tühkuid ega tabe
                    if (!word.isEmpty()) {                     // sõnadena jne
                        char viimane_taht = word.charAt(word.length() - 1);
                        loputahed.add(viimane_taht);
                        tahtede_luger.put(viimane_taht, tahtede_luger.getOrDefault(viimane_taht, 0) + 1);
                    }
                }
            }
        }
        System.out.println("Kõik lõputähed: " + loputahed);
        loputahed.sort(Comparator.comparingInt(c -> -tahtede_luger.get(c)));
        return loputahed;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "tekstifail.txt";
        List<Character> sageduses_loputahed = loputahed_sageduse_jarjekorras(fileName);
        System.out.println("Lõputähed esinemissageduse järjekorras: " + sageduses_loputahed);
        Failikirjutamine.failide_kirjutamine_loputahtedele(fileName);
        System.out.println("Failid valmis kirjutatud!");

        }
    }


