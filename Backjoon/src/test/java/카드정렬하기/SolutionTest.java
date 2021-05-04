package 카드정렬하기;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolutionTest {

    String prefix = "resources/카드정렬하기/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(100, Main.solve(prefix+"input1.txt",true));
    }

    @Test
    public void test2() throws IOException {
        Assert.assertEquals(51,Main.solve(prefix+"input2.txt",true));
    }
}
