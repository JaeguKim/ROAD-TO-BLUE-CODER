package 가장먼노드;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testDist() {
        Solution sol = new Solution();
        sol.solution(6,new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}});
        int[] res = new int[]{Integer.MAX_VALUE,0,1,1,2,2,2};
        int[] dist = sol.dist;
        for (int i=0;i<dist.length;i++) {
            System.out.println(dist[i]);
             //Assert.assertEquals(res[i],dist[i]);
        }
    }

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(3,sol.solution(6,new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
    }
}
