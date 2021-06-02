package prob347;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        int[] actual = sol.topKFrequent(new int[]{1,1,2,2,2,3,3,3,3},3);
        int[] ans = {3,2,1};
        for (int i=0;i<3;i++) {
            Assert.assertEquals(ans[i],actual[i]);
        }
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        int[] actual = sol.topKFrequent(new int[]{3,0,1,0},1);
        int[] ans = {0};
        for (int i=0;i<1;i++) {
            Assert.assertEquals(ans[i],actual[i]);
        }
    }

    @Test
    public void test3() {
        Solution sol = new Solution();
        int[] actual = sol.topKFrequent(new int[]{5,3,1,1,1,3,5,73,1},3);
        for (int num : actual) {
            System.out.println(num);
        }
    }
}
