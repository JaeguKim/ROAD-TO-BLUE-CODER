package prob1769;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    Solution sol = new Solution();
    @Test
    public void test1() {
        int[] res = new int[]{1,1,3};
        int[] actual = sol.minOperations("110");
        for (int i=0;i<res.length;i++) {
            Assert.assertEquals(res[i],actual[i]);
        }
    }
    @Test
    public void test2() {
        int[] res = new int[]{11,8,5,4,3,4};
        int[] actual = sol.minOperations("001011");
        for (int i=0;i<res.length;i++) {
            Assert.assertEquals(res[i],actual[i]);
        }
    }
}
