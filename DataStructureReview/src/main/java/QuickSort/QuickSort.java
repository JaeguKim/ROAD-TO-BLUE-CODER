package QuickSort;

public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            sortThree(arr, left, right);
            partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    private static void sortThree(int[] arr, int i, int j) {
        int mid = (i + j) / 2;
        if (arr[i] > arr[mid]) swap(arr, i, mid);
        if (arr[mid] > arr[j]) swap(arr, j, mid);
        if (arr[i] > arr[mid]) swap(arr, i, mid);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void partition(int[] arr, int left, int right) {
        int pivot = (left + right) / 2;
        while (left <= right) {
            while (arr[pivot] > arr[left]) left++;
            while (arr[pivot] < arr[right]) right--;
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {5, 4, 3, 2, 1,6,7,8,100};
        QuickSort.quickSort(input, 0, input.length - 1);
        for (int num : input) {
            System.out.println(num);
        }
    }
}
