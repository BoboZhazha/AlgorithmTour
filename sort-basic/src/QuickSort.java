public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 3, 45, 6, 7};

        sort(arr, 0, arr.length - 1);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }


    // 选一个数组中的基准数(一般最左边),然后开始从两边开始检索,先从右边检索比基础数小的,再从左边找比基准数大的
    // 找到了就停下,然后交换这两个数
    private static void sort(int[] arr, int l, int r) {
        //    首先是循环终止条件
        if (l > r) {
            return;
        }
        //   定义基准, 或者叫枢纽
        int base = arr[l];
        // 定义变量,指向左边
        int i = l;
        // 定义变量,指向右边
        int j = r;

        while (i != j) {
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }

            swap(arr,i,j);
        }

        // 走到这里说明 i和j相遇, 那么把基准数和i的位置互换
        arr[l] = arr[i];
        arr[i] = base;

        sort(arr, l, i - 1);

        sort(arr, j + 1, r);

    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}