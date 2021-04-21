package 청소년상어;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolutionTest {

    @Test
    public void test() throws IOException {
        String prefix = "resources/청소년상어/";
        Assert.assertEquals(33,Main.solve(prefix+"input1.txt",true));
        Assert.assertEquals(43,Main.solve(prefix+"input2.txt",true));
        Assert.assertEquals(76,Main.solve(prefix+"input3.txt",true));
        Assert.assertEquals(39,Main.solve(prefix+"input4.txt",true));
    }
}
