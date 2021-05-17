package MergeSort;

public class MergeSort {

    private static void merge(int[] initList, int[] mergedList, int i, int m, int n) {
        int j,k,t;
        j = m+1;
        k = i;
        while (i <= m && j <= n) {
            if (initList[i] < initList[j]) mergedList[k++] = initList[i++];
            else mergedList[k++] = initList[j++];
        }
        if (i > m) for (t = j; t <= n; t++) mergedList[t] = initList[t];
        else for (t = i; t <= m; t++) mergedList[k++] = initList[i];
    }

    private static void mergePass(int[] initList, int[] mergedList, int n, int s) {
        int i,j;
        for (i=0;i<=n-2*s;i+=2*s) merge(initList,mergedList,i,i+s-1,i+2*s-1);
        if (i+s-1 < n) merge(initList,mergedList,i,i+s-1,n);
        else for (j=i;j<=n;j++) mergedList[j] = initList[j];
    }

    public static void sort(int[] arr) {
        int s = 1;
        int[] extra = new int[2*arr.length];
        while (s < arr.length) {
            mergePass(arr,extra,arr.length-1,s);
            s*=2;
            mergePass(extra,arr,arr.length-1,s);
            s*=2;
        }
    }

    public static void main(String[] args) {
        int[] num = {5,4,3,2,1,2,3,4,5,100,99,11};
        MergeSort.sort(num);
        for (int i=0;i<num.length;i++) System.out.println(num[i]);
    }
}
