import net.werdei.web3.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    @DisplayName("Tests for correct area calculation")
    public void areaTest()
    {
        Assertions.assertAll(
                () -> Assertions.assertTrue (getPointResult(0, 0, 3.5), "Center"),

                () -> Assertions.assertTrue (getPointResult(1, 1, 5), "Inside the zone, quadrant I"),
                () -> Assertions.assertFalse(getPointResult(3, 3, 2), "Outside the zone, quadrant I"),
                () -> Assertions.assertTrue (getPointResult(1, 1, 3), "On the edge, quadrant I"),
                () -> Assertions.assertTrue (getPointResult(0, 3, 3), "Between quadrant I and II"),

                () -> Assertions.assertFalse(getPointResult(-1, 0.5, 2), "Outside the zone, quadrant II"),
                () -> Assertions.assertTrue (getPointResult(0, 0, 3), "Between quadrant II and III"),

                () -> Assertions.assertTrue (getPointResult(-1, -1, 5), "Inside the zone, quadrant III"),
                () -> Assertions.assertFalse(getPointResult(-2, -3, 2.5), "Outside the zone, quadrant III"),
                () -> Assertions.assertTrue (getPointResult(-2, -3, 4), "On the edge, quadrant III"),
                () -> Assertions.assertTrue (getPointResult(0, -3, 3), "Between quadrant III and IV"),

                () -> Assertions.assertTrue (getPointResult(1.5, -0.5, 4), "Inside the zone, quadrant IV"),
                () -> Assertions.assertFalse(getPointResult(2, -2, 5), "Outside the zone, quadrant IV"),
                () -> Assertions.assertTrue (getPointResult(2, 0, 4), "Between quadrant IV and I")
        );
    }

    private boolean getPointResult(double x, double y, double r)
    {
        return new Point(x, y, r, 0, "Test Environment").getResult();
    }
}
