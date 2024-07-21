import java.util.Arrays;

public class rightRotate {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        rightRotate obj = new rightRotate();
        int[] ans = obj.ROTATE_RIGHT(arr, 0, 5);
        System.out.println(Arrays.toString(ans));
    }

    public int[] ROTATE_RIGHT(int[] arr, int d, int k) {
        int[] ans = new int[arr.length];
        for (int i = d; i < k; i ++) {
            ans[(i + 1) % k] = arr[i];
        }
        for (int i = k; i < arr.length; i ++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}
