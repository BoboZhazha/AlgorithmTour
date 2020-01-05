import javax.swing.*;

public class QuickSort {
    public static void main(String[] args) {
        // sort();
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);


    }

    private static void sort(Comparable[] arr, int l, int r) {
    //    首先是循环终止条件
        if (l >= r) {
            return;
        }
        int p = partition(arr, l , r);
        sort(arr, l,p-1);
        sort(arr, p + 1, r);
    }


    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];

        int j = l;

        return 0;
    }


    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
