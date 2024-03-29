package CountingSort;

// TIME COMPLEXITY : O(n+k) where n is the number of elements in input array and k is the range of input
// Auixiliary Space : O(n+k)
public class CountingSort {
    void sort(char arr[]) {
        int n = arr.length;
        char output[] = new char[n];
        int count[] = new int[256];
        for (int i=0;i<n;++i) ++count[arr[i]];
        for (int i=1;i<count.length;++i) count[i] += count[i-1];
        for (int i=n-1;i>=0;i--) {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }
        for (int i=0;i<n;++i) arr[i] = output[i];
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        char arr[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's' };
        cs.sort(arr);
        for (int i=0;i<arr.length;i++) System.out.print(arr[i]);
    }
}
