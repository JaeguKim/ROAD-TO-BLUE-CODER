package prob284;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int idx;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
         list = new ArrayList<>();
         while (iterator.hasNext()) {
             list.add(iterator.next());
         }
         idx = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(idx);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < list.size();
    }
}
