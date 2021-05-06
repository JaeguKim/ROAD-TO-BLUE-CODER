package 두용액;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolTest {

    String prefix = "resources/두용액/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals("-99 98", Main.solve(prefix+"input1.txt",true));
    }
}
