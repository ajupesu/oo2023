import static java.lang.Math.round;

public class Traktor extends Masinad implements Arvutused {

    public Traktor(int mileage, int year, double engineSize, String mark) {
        super(mileage, year, engineSize, mark);
    }

    @Override
    public double getPriceForTractor() {
        double priceForTractor = 5000;
        if (year >= 2015) {
            priceForTractor += 5000;
        }
        if (year <= 1999) {
            priceForTractor -= 3000;
        }

        for (int i = 10000; i <= mileage; i += 10000) {
            priceForTractor -= 100.0;
        }
        if (engineSize > 2.0) {
            priceForTractor += 1000.0;
        }

        // round price to 2 decimal places
        priceForTractor = round(priceForTractor * 100) / 100.0;

        return priceForTractor;
    }

    @Override
    public double getPriceForCar() {
        return 0;
    }

    public double getKWfromEngineSize() {
        return engineSize *50;

    }
}

