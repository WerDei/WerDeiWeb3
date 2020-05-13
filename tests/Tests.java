import net.werdei.web3.Point;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Tests {

    @Parameter(0)
    public double x;
    @Parameter(1)
    public double y;
    @Parameter(2)
    public double r;
    @Parameter(3)
    public boolean hit;
    @Parameter(4)
    public String message;


    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { 0, 0, 3.5, true, "Center" },

                { 1, 1, 5, true, "Inside the zone, quadrant I" },
                { 3, 3, 2, false, "Outside the zone, quadrant I" },
                { 1, 1, 3, true, "On the edge, quadrant I" },
                { 1, 1.01, 3, false, "Near the edge, quadrant I" },
                { 0, 3, 3, true, "Between quadrant I and II" },

                {-1, 0.5, 2, false, "Outside the zone, quadrant II" },
                {-0.01, 0.01, 4, false, "Near the edge, quadrant II" },
                {-1, 0, 3, true, "Between quadrant II and III" },

                {-1, -1, 5, true, "Inside the zone, quadrant III" },
                {-2, -3, 2.5, false, "Outside the zone, quadrant III" },
                {-2, -3, 4, true, "On the edge, quadrant III" },
                {-2.01, -3, 4, false, "Near the edge, quadrant III" },
                {0, -3, 3, true, "Between quadrant III and IV" },

                {1.5, -0.5, 4, true, "Inside the zone, quadrant IV" },
                {2, -2, 5, false, "Outside the zone, quadrant IV" },
                {0.7071, -0.7071, 2, true, "On the edge, quadrant IV" },
                {0.71, -0.71, 2, false, "Near the edge, quadrant IV" },
                {2, 0, 4, true, "Between quadrant IV and I" },
        };
        return Arrays.asList(data);
    }

    @Test
    public void areaTest()
    {
        Assert.assertEquals(message, getPointResult(x, y, r), hit);
    }


    private boolean getPointResult(double x, double y, double r)
    {
        return new Point(x, y, r, 0, "Test Environment").getResult();
    }
}
