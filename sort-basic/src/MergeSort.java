
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        sort(arr);
        SortTestHelper.testSort("MergeSort", arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归
    private static void sort(Comparable[] arr, int l, int r) {
        // 首先处理边界情况
        if (l >= r)
            return;

        int mid = (l+r)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr, l, mid, r);

    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        // 需要一个临时空间,将arr[lo, hi]复制到aux[low,hi], 然后再归并回arr[]
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化,i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l;
        int j = mid + 1;

        //1,2,3,5,   6,7,8,9
        // 开始归并
        for (int k = l; k <= r; k++) {

            // 左半边用尽
            if (i > mid) {
                arr[k] = aux[j-l];
                j++;
            } else if (j > r) { // 右半边用尽
                arr[k] = aux[i-l];
                i++;
            } else if (aux[i-l].compareTo(aux[j-l]) < 0) { //左半边当前元素小于右半边元素, 取左半边
                arr[k] = aux[i-l];
                i++;
            //左半边当前元素大于等于右半边元素, 取右半边
            } else {
                arr[k] = aux[j-l];
                j++;
            }
        }



    }
}
