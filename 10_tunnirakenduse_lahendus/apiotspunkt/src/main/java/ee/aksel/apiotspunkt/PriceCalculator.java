package ee.aksel.apiotspunkt;

public class PriceCalculator {
    private static final double PRICE_PER_SQUARE_METER = 10.0;
    private static final double EXTRA_WHEN_BIG = 5.0;

    public static double calculatePrice(Rectangle rectangle) {
        double area = rectangle.getArea();
        double basePrice = PRICE_PER_SQUARE_METER * area;
        double extraPrice = rectangle.isBig() ? EXTRA_WHEN_BIG * area : 0;
        return basePrice + extraPrice;
    }
}
