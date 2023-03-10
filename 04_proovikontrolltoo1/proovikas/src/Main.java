import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        System.out.println(keskmine(3,4,5));


        double[] sisend = {3,4,5,6,6};
        System.out.println(Arrays.toString(libisevKeskmine(sisend)));

        LibisevKeskmine libisev = new LibisevKeskmine(2,3,4);
        libisev.lisaArv(4);
        System.out.println(libisev.arvudKeskmisega);
    }
    private static int keskmine(int nr1, int nr2, int nr3) {
        return (nr1 + nr2 + nr3) / 3;
    }
    private static double[] libisevKeskmine(double[] arvud){
        double[] valjund = new double[arvud.length - 2]; // kui teen uue array, siis pean koheselt yltema kui pikk ta on
        for (int i = 0; i < arvud.length-2 ; i++) {
            valjund[i] = (arvud[i] + arvud[i+1] + arvud[i+2]) / 3;
        }
        return valjund;
    }

}