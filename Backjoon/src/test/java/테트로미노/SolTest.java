package 테트로미노;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolTest {
    String prefix = "resources/테트로미노/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(19, Main.solve(prefix+"input1.txt",true));
    }

    @Test
    public void test2() throws IOException {
        Assert.assertEquals(20, Main.solve(prefix+"input2.txt",true));
    }

    @Test
    public void test3() throws IOException {
        Assert.assertEquals(7, Main.solve(prefix+"input3.txt",true));
    }

}
