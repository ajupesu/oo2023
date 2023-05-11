package ee.aksel.apiotspunkt;

import java.awt.Color;
import java.util.Random;

public class ColorUtils {

    public static String getRandomColor() {
        Random random = new Random();
        float hue = random.nextFloat();
        float saturation = 0.9f; // 90% saturation
        float brightness = 1.0f; // 100% brightness
        Color color = Color.getHSBColor(hue, saturation, brightness);
        return "#" + Integer.toHexString(color.getRGB()).substring(2);
    }

}