package ee.aksel.apiotspunkt;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RectangleListController {
    static List<Rectangle> rectangles = new ArrayList<>(Arrays.asList(
            new Rectangle(1, "esimene", 2.1,4.4,false,"red",true),
            new Rectangle(2,"teine",3.3,6.6,true,"red",true),
            new Rectangle(3,"kolmas",3.7,9.1,true,"red",true),
            new Rectangle(4,"neljas",2.2,1.7,false,"red",true),
            new Rectangle(5,"viies",0.5,2,false,"red",true)
    ));
    @GetMapping("rectangles")
    public List<Rectangle> getrectangles() {
        return rectangles;
    }
    @GetMapping("delete-Rectangle/{id}")
    public String deleteRectangle(@PathVariable int id) {
        rectangles.remove(id);
        return "Rectangle deleted!";
    }
    @GetMapping("add-Rectangle/{id}/{name}/{length}/{width}")
    public List<Rectangle> addRectangle(
            @PathVariable int id,
            @PathVariable String name,
            @PathVariable double length,
            @PathVariable double width) {
        rectangles.add(new Rectangle(id, name, length, width));
        return rectangles;
    }
    @GetMapping("add-Rectangle")
    public List<Rectangle> addRectangleURL(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam double length,
            @RequestParam double width,
            @RequestParam boolean big,
            @RequestParam String color,
            @RequestParam boolean priceHidden) {
        rectangles.add(new Rectangle(id, name, length, width, big, color,priceHidden));
        return rectangles;
    } // localhost:8080/add-Rectangle?id=7&name=seitsmes&length=8.5&width=1.2&big=true

    @GetMapping("rectangle-areas")
    public List<Double> getRectangleAreas() {
        List<Double> areas = new ArrayList<>();
        for (Rectangle rectangle : rectangles) {
            double area = rectangle.getArea();
            areas.add(area);
        }
        return areas;
    }

    @GetMapping("rectangle-perimeters")
    public List<Double> getRectanglePerimeters() {
        List<Double> perimeters = new ArrayList<>();
        for (Rectangle rectangle : rectangles) {
            double perimeter = rectangle.getPerimeter();
            perimeters.add(perimeter);
        }
        return perimeters;
    }
    @GetMapping("rectangles/{id}")
    public static @Nullable Rectangle getRectangleById(@PathVariable int id) {
        for (Rectangle rectangle : rectangles) {
            if (rectangle.getId() == id) {
                return rectangle;
            }
        }
        return null;
    }

}
