package prob165;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> makeList(String version) {
        List<Integer> list = new ArrayList<>();
        if (version.contains(".")) {
            for (String s : version.split("\\.")) {
                list.add(Integer.parseInt(s));
            }
        }
        else {
            list.add(Integer.parseInt(version));
        }
        return list;
    }

    public int compareVersion(String version1, String version2) {
        List<Integer> l1 = makeList(version1);
        List<Integer> l2 = makeList(version2);
        int remain = Math.max(l1.size(),l2.size())-l1.size();
        while (remain-- > 0) {
            l1.add(0);
        }
        remain = Math.max(l1.size(),l2.size())-l2.size();
        while (remain-- > 0) {
            l2.add(0);
        }
        for (int i=0; i<l1.size(); ++i) {
            if (l1.get(i) < l2.get(i)) {
                return -1;
            } else if (l1.get(i) > l2.get(i)) {
                return 1;
            }
        }
        return 0;
    }
}
