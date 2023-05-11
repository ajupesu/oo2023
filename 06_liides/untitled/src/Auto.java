import static java.lang.Math.round;

public class Auto extends Masinad implements Arvutused {

    public Auto(int mileage, int year, double engineSize, String mark) {
        super(mileage, year, engineSize, mark);
    }

    @Override
    public double getPriceForCar() {
        double priceForCar = 10000;
        if (year >= 2015) {
            priceForCar += 5000;
        }
        if (year <= 1999) {
            priceForCar -= 3000;
        }
        if (mark.equals("Mercedes")) {
            priceForCar += 1500;
        } else if (mark.equals("Dacia")) {
            priceForCar -= 1500;
        }

        for (int i = 10000; i <= mileage; i += 10000) {
            priceForCar -= 100.0;
        }
        if (engineSize > 2.0) {
            priceForCar += 1000.0;
        }

        // round price to 2 decimal places
        priceForCar = round(priceForCar * 100) / 100.0;

        return priceForCar;
    }
    public double getKWfromEngineSize() {
        return engineSize *50;

    }

    @Override
    public double getPriceForTractor() {
        return 0;
    }
}

