package 마법사상어와토네이도;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolutionTest {

    @Test
    public void test() throws IOException {
        String prefix = "resources/마법사/";
        Assert.assertEquals(10,Main.solve(prefix+"input.txt",true));
        Assert.assertEquals(85,Main.solve(prefix+"input2.txt",true));
        Assert.assertEquals(139,Main.solve(prefix+"input3.txt",true));
        Assert.assertEquals(7501,Main.solve(prefix+"input4.txt",true));
        Assert.assertEquals(283,Main.solve(prefix+"input5.txt",true));
        Assert.assertEquals(22961,Main.solve(prefix+"input6.txt",true));
    }
}
