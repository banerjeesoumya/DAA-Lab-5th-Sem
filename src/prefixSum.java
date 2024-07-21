import java.util.Arrays;

public class prefixSum {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        prefixSum obj = new prefixSum();
        int[] ans = obj.solution(arr);
        System.out.println(Arrays.toString(ans));
    }

    public int[] solution(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        return prefixSum;
    }
}
