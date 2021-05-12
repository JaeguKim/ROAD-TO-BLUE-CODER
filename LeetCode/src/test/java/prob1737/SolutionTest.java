package prob1737;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution sol = new Solution();

    @Test
    public void test1() {
        Assert.assertEquals(2,sol.minCharacters("aba","caa"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3,sol.minCharacters("dabadd","cda"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1,sol.minCharacters("da","cced"));
    }
}
