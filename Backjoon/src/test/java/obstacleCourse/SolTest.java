package obstacleCourse;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolTest {

    String prefix = "resources/obstacleCourse/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals("Problem 1: 20\n" +
                "Problem 2: 19\n" +
                "Problem 3: 36\n", Main.solve(prefix+"input1.txt",true));
    }
}
