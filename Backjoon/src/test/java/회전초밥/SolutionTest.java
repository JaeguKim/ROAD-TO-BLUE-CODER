package 회전초밥;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolutionTest {

    String prefix = "resources/회전초밥/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(5, Main.solve(prefix+"input1.txt",true));
    }

    @Test
    public void test2() throws IOException {
        Assert.assertEquals(4, Main.solve(prefix+"input2.txt",true));
    }

}
