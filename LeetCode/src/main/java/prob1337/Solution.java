package prob1337;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        return IntStream.range(0,mat.length).mapToObj(i->new int[]{i, Arrays.stream(mat[i]).sum()}).sorted(Comparator.comparingInt(a -> a[1])).limit(k).mapToInt(a->a[0]).toArray();
    }
}
