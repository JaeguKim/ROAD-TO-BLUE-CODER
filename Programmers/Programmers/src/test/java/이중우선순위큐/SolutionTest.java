package 이중우선순위큐;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        int[] res = sol.solution(new String[]{"I 16","D 1"});
        int[] actual = new int[]{0,0};
        Assert.assertTrue(res[0]==actual[0] && res[1]==actual[1]);

        res = sol.solution(new String[]{"I 7","I 5","I -5","D -1"});
        actual = new int[]{7,5};
        Assert.assertTrue(res[0]==actual[0] && res[1]==actual[1]);

    }

}
