package 키순서;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolTest {

    String prefix = "resources/키순서/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(1, Main.solve(prefix+"input1.txt",true));
    }
}
