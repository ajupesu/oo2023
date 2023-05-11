package ee.aksel.apiotspunkt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RectangleController {
    Rectangle rectangle = new Rectangle(1, "esimene",5.2,2.1,true,"red",true);

    @GetMapping("Rectangle")
    public Rectangle getRectangle() {
        return rectangle;
    }
    @GetMapping("delete-Rectangle")
    public String deleteRectangle() {
        rectangle = null;
        return "Rectangle deleted!";
    }
    @GetMapping("increase-length")
    public Rectangle increaseLength() {
        rectangle.setLength( rectangle.getLength()+1 );
        return rectangle;
    }
    @GetMapping("increase-width")
    public Rectangle increaseWidth() {
        rectangle.setWidth( rectangle.getWidth()+1 );
        return rectangle;
    }
    @GetMapping("changeBig")
    public Rectangle changeSize(){
        rectangle.setBig(!rectangle.isBig());
        return rectangle;
    }
    @GetMapping("change-name/{name}")
    public Rectangle changeName(@PathVariable String name){
        rectangle.setName(name);
        return rectangle;
    }
    @GetMapping("area/{id}")
    public double getArea() {
        return rectangle.getArea();
    }
    @GetMapping("perimeter/{id}")
    public double getPerimeter() {
        return rectangle.getPerimeter();
    }
    @GetMapping("rectangle/{id}")
    public Rectangle getRectangleById(@PathVariable int id) {
        if (id == rectangle.getId()) {
            return rectangle;
        } else {
            return null;
        }
    }

    @GetMapping("price/{id}")
    public double getPrice(@PathVariable int id) {
        if (id == rectangle.getId()) {
            return PriceCalculator.calculatePrice(rectangle);
        } else {
            return -1;
        }
    }
}