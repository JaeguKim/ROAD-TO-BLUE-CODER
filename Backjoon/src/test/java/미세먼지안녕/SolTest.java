package 미세먼지안녕;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolTest {

    String prefix = "resources/미세먼지안녕/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(188, Main.solve(prefix+"input1.txt",true));
    }

    @Test
    public void test2() throws IOException {
        Assert.assertEquals(188, Main.solve(prefix+"input2.txt",true));
    }

    @Test
    public void test3() throws IOException {
        Assert.assertEquals(186, Main.solve(prefix+"input3.txt",true));
    }

    @Test
    public void test4() throws IOException {
        Assert.assertEquals(178, Main.solve(prefix+"input4.txt",true));
    }

    @Test
    public void test5() throws IOException {
        Assert.assertEquals(172, Main.solve(prefix+"input5.txt",true));
    }

    @Test
    public void test6() throws IOException {
        Assert.assertEquals(71, Main.solve(prefix+"input6.txt",true));
    }

    @Test
    public void test7() throws IOException {
        Assert.assertEquals(52, Main.solve(prefix+"input7.txt",true));
    }

    @Test
    public void test8() throws IOException {
        Assert.assertEquals(46, Main.solve(prefix+"input8.txt",true));
    }
}
