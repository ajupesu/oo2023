package ee.aksel.apiotspunkt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle {
    private int id;
    private String name;
    private double length;
    private double width;
    private boolean big;
    private String color;

    private boolean priceHidden;
    public boolean isPriceHidden() {
        return priceHidden;
    }
    public void setPriceHidden(boolean priceHidden) {
        this.priceHidden = priceHidden;
    }

    public Rectangle(int id, String name, double length, double width) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.width = width;
        this.big = (getArea() >= 10);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
        this.big = (getArea() >= 10);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        this.big = (getArea() >= 10);
    }

    public boolean isBig() {
        return big;
    }

    public void setBig(boolean big) {
        this.big = big;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }
    public String getColor() {
        return color;
    }

    public void setColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        color = String.format("#%02x%02x%02x", r, g, b);
    }
}