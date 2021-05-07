package 견우와직녀;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolTest {
    String prefix = "resources/견우와직녀/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(8, Main.solve(prefix+"input1.txt",true));
    }
}
