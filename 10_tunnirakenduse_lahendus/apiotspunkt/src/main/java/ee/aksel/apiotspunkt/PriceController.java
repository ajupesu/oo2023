package ee.aksel.apiotspunkt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    @GetMapping("price-by-id/{id}")
    public String getPrice(@PathVariable int id) {
        Rectangle rectangle = RectangleListController.getRectangleById(id);
        if (rectangle != null) {
            double price = PriceCalculator.calculatePrice(rectangle);
            if (rectangle.isPriceHidden()) {
                return "The price of " + rectangle.getName() + " is hidden.";
            } else {
                return "The price of " + rectangle.getName() + " is " + price + " euros.";
            }
        } else {
            return "Rectangle not found.";
        }
    }

    @GetMapping("hide-price-by-id/{id}")
    public String hidePrice(@PathVariable int id) {
        Rectangle rectangle = RectangleListController.getRectangleById(id);
        if (rectangle != null) {
            rectangle.setPriceHidden(true);
            return "Price for " + rectangle.getName() + " is now hidden.";
        } else {
            return "Rectangle not found.";
        }
    }

    @GetMapping("show-price-by-id/{id}")
    public String showPrice(@PathVariable int id) {
        Rectangle rectangle = RectangleListController.getRectangleById(id);
        if (rectangle != null) {
            rectangle.setPriceHidden(false);
            return "Price for " + rectangle.getName() + " is now visible.";
        } else {
            return "Rectangle not found.";
        }
    }
}
