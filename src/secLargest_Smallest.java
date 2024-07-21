import java.util.Arrays;

public class secLargest_Smallest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        secLargest_Smallest obj = new secLargest_Smallest();
        int[] ans = obj.solution(arr);
        System.out.println(Arrays.toString(ans));
    }

    public int[] solution(int[] arr) {
        int l = Integer.MIN_VALUE, sl = Integer.MIN_VALUE;
        int s = Integer.MAX_VALUE, sm = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > l) {
                sl = l;
                l = arr[i];
            }
            if (arr[i] >  sl && arr[i] != l) {
                sl = arr[i];
            }
            if (arr[i] < s) {
                sm = s;
                s = arr[i];
            }
            if (arr[i] < sm && arr[i] != s) {
                sm = arr[i];
            }
        }
        return new int[]{sm, sl};
    }
}
