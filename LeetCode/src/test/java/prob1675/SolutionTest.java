package prob1675;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution test = new Solution();
        Assert.assertEquals(1,test.minimumDeviation(new int[]{1,2,3,4}));
        Assert.assertEquals(3,test.minimumDeviation(new int[]{4,1,5,20,3}));
        Assert.assertEquals(3,test.minimumDeviation(new int[]{2,10,8}));
    }
}
