package 일일공옮기기;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution sol = new Solution();

    @Test
    public void test1() {
        String[] ans = {"1101","100110110","0110110111"};
        String[] s = {"1110","100111100","0111111010"};
        String[] actual = sol.solution(s);
        for (int i=0;i<actual.length;i++) {
            Assert.assertEquals(ans[i],actual[i]);
        }

    }
}
