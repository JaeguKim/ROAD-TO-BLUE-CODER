package 퇴사;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Assert.assertEquals(45,Main.solution(7,new int[]{3,5,1,1,2,4,2},new int[]{10,20,10,20,15,40,200}));
        Assert.assertEquals(55,Main.solution(10,new int[]{1,1,1,1,1,1,1,1,1,1},new int[]{1,2,3,4,5,6,7,8,9,10}));
        Assert.assertEquals(20,Main.solution(10,new int[]{5,5,5,5,5,5,5,5,5,5},new int[]{10,9,8,7,6,10,9,8,7,6}));
        Assert.assertEquals(90,Main.solution(10,new int[]{5,4,3,2,1,1,2,3,4,5},new int[]{50,40,30,20,10,10,20,30,40,50}));
    }
}
