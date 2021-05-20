package MergeSort;

import java.util.Arrays;

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

    public static void iterativeSort(int[] arr) {
        int s = 1;
        int[] extra = new int[2*arr.length];
        while (s < arr.length) {
            mergePass(arr,extra,arr.length-1,s);
            s*=2;
            mergePass(extra,arr,arr.length-1,s);
            s*=2;
        }
    }

    public static int rmergeSort(int[] arr, int[] link, int left, int right) {
        if (left >= right) return left;
        int mid = (left+right)/2;
        return listMerge(arr,link,rmergeSort(arr,link,left,mid),rmergeSort(arr,link,mid+1,right));
    }

    public static int listMerge(int[] arr, int[] link, int start1, int start2) {
        int last1, last2, lastResult = 0;
        for (last1 = start1, last2 = start2; last1 != 0 && last2 != 0; ) {
            if (arr[last1] <= arr[last2]) {
                link[lastResult] = last1;
                lastResult = last1; last1 = link[last1];
            }
            else {
                link[lastResult] = last2;
                lastResult = last2; last2 = link[last2];
            }
        }
        if (last1 == 0) link[lastResult] = last2;
        else link[lastResult] = last1;
        return link[0];
    }

    public static void main(String[] args) {
        int[] num = {5,4,3,2,1,2,3,4,5,100,99,11};
        MergeSort.iterativeSort(num);
        for (int i=0;i<num.length;i++) System.out.println(num[i]);
        System.out.println();
        int[] num2 = {-1,5,4,3,2,1,2,3,4,5,100,99,11};
        int[] link = new int[num2.length];
        int start = MergeSort.rmergeSort(num2,link,1,num2.length-1);
        for (int i=0;i<link.length;i++) System.out.println(link[i]);
        System.out.println();
        int cur = start;
        while (cur != 0) {
            System.out.println(num2[cur]);
            cur = link[cur];
        }
    }
}
