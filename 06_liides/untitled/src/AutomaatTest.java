import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutomaatTest {
    @Test
    public void test_auto_mercedes() {
        Auto auto = new Auto(500000, 2010, 3,"Mercedes");
        assertEquals((10000+1500)-(50*100), 1, auto.getPriceForCar());
    }
    @Test
    public void test_traktor() {
        Traktor traktor = new Traktor(70000, 1990, 8,"john deer");
        assertEquals((5000+700)-(50*100), 1, traktor.getPriceForTractor());
    }
}