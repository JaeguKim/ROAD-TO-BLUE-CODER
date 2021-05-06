package 가장긴증가하는부분수열2;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolTest {
    String prefix = "resources/가장긴증가하는부분수열2/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(4, Main.solve(prefix+"input1.txt",true));
    }
}
