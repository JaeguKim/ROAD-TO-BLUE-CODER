package 연구소;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolTest {

    String prefix = "resources/연구소/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(27, Main.solve(prefix+"input1.txt",true));
    }

    @Test
    public void test2() throws IOException {
        Assert.assertEquals(9, Main.solve(prefix+"input2.txt",true));
    }

    @Test
    public void test3() throws IOException {
        Assert.assertEquals(3, Main.solve(prefix+"input3.txt",true));
    }

}
