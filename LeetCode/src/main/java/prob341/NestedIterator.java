package prob341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int idx;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        idx = 0;
        for (NestedInteger ni : nestedList) {
            flatten(ni);
        }
    }

    private void flatten(NestedInteger ni) {
        if (ni.isInteger()) {
            list.add(ni.getInteger());
            return;
        }
        for (NestedInteger item : ni.getList()) {
            flatten(item);
        }
    }

    @Override
    public Integer next() {
        return list.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < list.size();
    }
}