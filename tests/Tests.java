import net.werdei.web3.Point;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void areaTest()
    {
        Assert.assertTrue ("Center", getPointResult(0, 0, 3.5));

        Assert.assertTrue ("Inside the zone, quadrant I", getPointResult(1, 1, 5));
        Assert.assertFalse("Outside the zone, quadrant I", getPointResult(3, 3, 2));
        Assert.assertTrue ("On the edge, quadrant I", getPointResult(1, 1, 3));
        Assert.assertTrue ("Between quadrant I and II", getPointResult(0, 3, 3));

        Assert.assertFalse("Outside the zone, quadrant II", getPointResult(-1, 0.5, 2));
        Assert.assertTrue ("Between quadrant II and III", getPointResult(-1, 0, 3));

        Assert.assertTrue ("Inside the zone, quadrant III", getPointResult(-1, -1, 5));
        Assert.assertFalse("Outside the zone, quadrant III", getPointResult(-2, -3, 2.5));
        Assert.assertTrue ("On the edge, quadrant III", getPointResult(-2, -3, 4));
        Assert.assertTrue ("Between quadrant III and IV", getPointResult(0, -3, 3));

        Assert.assertTrue ("Inside the zone, quadrant IV", getPointResult(1.5, -0.5, 4));
        Assert.assertFalse("Outside the zone, quadrant IV", getPointResult(2, -2, 5));
        Assert.assertTrue ("On the edge, quadrant IV", getPointResult(0.7071, -0.7071, 2));
        Assert.assertTrue ("Between quadrant IV and I", getPointResult(2, 0, 4));
    }


    private boolean getPointResult(double x, double y, double r)
    {
        return new Point(x, y, r, 0, "Test Environment").getResult();
    }
}
