package prob923;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        int[] arr = new int[]{1,1,2,2,3,3,4,4,5,5};
        Assert.assertEquals(20,sol.threeSumMulti(arr,8));
        arr = new int[]{1,1,2,2,2,2};
        Assert.assertEquals(12,sol.threeSumMulti(arr,5));
        arr = new int[]{0,0,0,0};
        Assert.assertEquals(4,sol.threeSumMulti(arr,0));
    }
}
