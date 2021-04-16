package 프로그래밍2;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testRight() {
        Solution sol = new Solution();
        Assert.assertEquals(true,sol.isRight("[](){}"));
    }

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(3,sol.solution("[](){}"));
        Assert.assertEquals(2,sol.solution("}]()[{"));
        Assert.assertEquals(0,sol.solution("[)(]"));
        Assert.assertEquals(0,sol.solution("}}}"));

    }
}
