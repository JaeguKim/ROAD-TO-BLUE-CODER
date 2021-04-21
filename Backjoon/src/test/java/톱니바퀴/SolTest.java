package 톱니바퀴;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SolTest {

    String prefix = "resources/톱니바퀴/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(7, Main.solve(prefix+"input1.txt",true));
    }

    @Test
    public void test2() throws IOException {
        Assert.assertEquals(15, Main.solve(prefix+"input2.txt",true));
    }

    @Test
    public void test3() throws IOException {
        Assert.assertEquals(6, Main.solve(prefix+"input3.txt",true));
    }

    @Test
    public void test4() throws IOException {
        Assert.assertEquals(5, Main.solve(prefix+"input4.txt",true));
    }
}
