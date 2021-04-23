package 이공사팔;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolutionTest {

    String prefix = "resources/이공사팔/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(16, Main.solve(prefix+"input1.txt",true));
    }

    @Test
    public void test2() throws IOException {
        Assert.assertEquals(8, Main.solve(prefix+"input2.txt",true));
    }

    @Test
    public void test3() throws IOException {
        Assert.assertEquals(64, Main.solve(prefix+"input3.txt",true));
    }

//    @Test
//    public void test4() throws IOException {
//        Assert.assertEquals(64, Main.solve(prefix+"input4.txt",true));
//    }
//
//    @Test
//    public void test5() throws IOException {
//        Assert.assertEquals(16, Main.solve(prefix+"input5.txt",true));
//    }
//
//    @Test
//    public void test6() throws IOException {
//        Assert.assertEquals(32, Main.solve(prefix+"input6.txt",true));
//    }
}
