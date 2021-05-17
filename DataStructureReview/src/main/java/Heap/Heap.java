package Heap;

public class Heap {

    private int[] arr;
    private int idx = 0;
    private boolean isMaxHeap;

    public Heap(int N, boolean isMaxHeap) {
        arr = new int[N];
        this.isMaxHeap = isMaxHeap;
    }

    private boolean compare(int n1,int n2) {
        if (isMaxHeap) return n1 < n2;
        else return n1 > n2;
    }

    public void insert(int num) {
        int currentIdx = idx;
        while (currentIdx != 0 && compare(arr[currentIdx/2],num)) {
            arr[currentIdx] = arr[currentIdx/2];
            currentIdx /= 2;
        }
        arr[currentIdx] = num;
        idx++;
    }

    public int pop() throws Exception {
        if (idx <= 0) throw new Exception("heap is empty!");
        int result = arr[0];
        int num = arr[idx-1];
        int currentIdx = 0;
        while (2*currentIdx+1 < idx) {
            int smallerOrBigger;
            if (2*currentIdx+2 < idx && compare(arr[2*currentIdx+1],arr[2*currentIdx+2])) smallerOrBigger = 2*currentIdx+2;
            else smallerOrBigger = 2*currentIdx+1;
            if (compare(num,arr[smallerOrBigger])) arr[currentIdx] = arr[smallerOrBigger];
            else break;
            currentIdx = smallerOrBigger;
        }
        arr[currentIdx] = num;
        idx--;
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] input = {1,2,3,4,5,50,10,20,40000};
        Heap heap = new Heap(input.length,true);
        for (int num : input) {
            heap.insert(num);
        }
        for (int i=0;i<input.length;i++) {
            System.out.println(heap.pop());
        }
        System.out.println();
        heap.isMaxHeap = false;
        for (int num : input) {
            heap.insert(num);
        }
        for (int i=0;i<input.length;i++) {
            System.out.println(heap.pop());
        }
    }
}
