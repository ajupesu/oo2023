import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String fileName = "tekstifail.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Sõnade lõputähed:");
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.trim().isEmpty()) {  // vaatab et sõna ei oleks tühik või tab jne
                        char lastLetter = word.charAt(word.length() - 1);
                        System.out.print(lastLetter + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}