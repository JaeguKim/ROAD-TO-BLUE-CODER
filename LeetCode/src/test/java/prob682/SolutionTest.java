package prob682;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        String[] arr = new String[]{"5","2","C","D","+"};
        Assert.assertEquals(30,sol.calPoints(arr));
        arr = new String[]{"5","-2","4","C","D","9","+","+"};
        Assert.assertEquals(27,sol.calPoints(arr));
        arr = new String[]{"1"};
        Assert.assertEquals(1,sol.calPoints(arr));
    }
}
