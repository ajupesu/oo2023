package ee.aksel.apiotspunkt;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static ee.aksel.apiotspunkt.ColorUtils.getRandomColor;

@RestController
public class RandomColorController {

    @Autowired
    private RectangleListController rectangleListController;

    @GetMapping("/random-color/{id}")
    public List<Rectangle> addRandomColor(@PathVariable int id) {
        List<Rectangle> rectangles = rectangleListController.getrectangles();
        for (Rectangle rectangle : rectangles) {
            if (rectangle.getId() == id) {
                rectangle.setColor(getRandomColor());
                break;
            }
        }
        return rectangles;
    }
    @GetMapping("show-color-code/{id}")
    public String showColorCode(@PathVariable int id) {
        List<Rectangle> rectangles = rectangleListController.getrectangles();
        for (Rectangle rectangle : rectangles) {
            if (rectangle.getId() == id) {
                Color color = Color.decode(rectangle.getColor());
                if (color != null) {
                    return "#" + Integer.toHexString(color.getRGB()).substring(2);
                } else {
                    return "Color not set for rectangle with ID " + id;
                }
            }
        }
        return "Rectangle with ID " + id + " not found";
    }

}
