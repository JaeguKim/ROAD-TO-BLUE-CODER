package baduk2;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolutionTest {

    String prefix = "resources/baduk2/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(1, Main.solve(prefix+"input1.txt",true));
    }

    @Test
    public void test2() throws IOException {
        Assert.assertEquals(0, Main.solve(prefix+"input2.txt",true));
    }

    @Test
    public void test3() throws IOException {
        Assert.assertEquals(3, Main.solve(prefix+"input3.txt",true));
    }

    @Test
    public void test4() throws IOException {
        Assert.assertEquals(7, Main.solve(prefix+"input4.txt",true));
    }

    @Test
    public void test5() throws IOException {
        Assert.assertEquals(13, Main.solve(prefix+"input5.txt",true));
    }

    @Test
    public void test6() throws IOException {
        Assert.assertEquals(8, Main.solve(prefix+"input6.txt",true));
    }

    @Test
    public void test7() throws IOException {
        Assert.assertEquals(10, Main.solve(prefix+"input7.txt",true));
    }

}
