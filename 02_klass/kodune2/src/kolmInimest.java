public class kolmInimest {
    private String inimene1nimi;
    private int inimene1vanus;
    private double inimene1raha;
    private String inimene2nimi;
    private int inimene2vanus;
    private double inimene2raha;
    private String inimene3nimi;
    private int inimene3vanus;
    private double inimene3raha;

    public kolmInimest(String inimene1nimi, int inimene1vanus, double inimene1raha,
                        String inimene2nimi, int inimene2vanus, double inimene2raha,
                        String inimene3nimi, int inimene3vanus, double inimene3raha) {
        this.inimene1nimi = inimene1nimi;
        this.inimene1vanus = inimene1vanus;
        this.inimene1raha = inimene1raha;
        this.inimene2nimi = inimene2nimi;
        this.inimene2vanus = inimene2vanus;
        this.inimene2raha = inimene2raha;
        this.inimene3nimi = inimene3nimi;
        this.inimene3vanus = inimene3vanus;
        this.inimene3raha = inimene3raha;
    }



    public int vanusKokku() {
        return inimene1vanus + inimene2vanus + inimene3vanus;
    }

    public double rahaKokku() {
        return inimene1raha + inimene2raha + inimene3raha;
    }

    public void infoKokku() {
        System.out.println("Vanus kokku: " + vanusKokku() );
        System.out.println("Raha kokku: " + rahaKokku() );
    }
}

