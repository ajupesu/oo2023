public class Main {
    public static void main(String[] args) {
        int sum = liitmine(2, 3);
        System.out.println("Kahe arvu summa on " + sum);

        int faktoriaal_tulemus = faktoriaal(5);
        System.out.println("Faktoriaal arvust 5 on " + faktoriaal_tulemus);

        String palindroom = "aias sadas saia";
        boolean palindroom_tulemus = kas_on_palindroom(palindroom);
        System.out.println(palindroom + " on palindroom: " + palindroom_tulemus);
    }

    public static int liitmine(int a, int b) {
        return a + b;
    }

    public static int faktoriaal(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * faktoriaal(n - 1);
        }
    }

    public static boolean kas_on_palindroom(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }
}
