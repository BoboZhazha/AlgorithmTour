public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int res = binarySearch(arr,arr.length -1 ,3);
        System.out.println(res);
    }


    public static int binarySearch(int [] arr, int n, int target) {

        // 在数组[l,r]中查找target
        int l = 0;
        int r = n-1;

        while (l <= r) {

            int mid = (l + r)/2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return -1;

    }

}
