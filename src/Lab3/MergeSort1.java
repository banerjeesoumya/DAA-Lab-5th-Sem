package Lab3;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {24, 18, 38, 43, 14, 40, 1, 54};
        time(arr);
    }

    public static void merge(int s, int mid, int e, int[] arr) {
        int[] merge = new int[e - s + 1];
        int i = s, j = mid + 1, k = 0;

        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                merge[k++] = arr[i++];
            } else {
                merge[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            merge[k++] = arr[i++];
        }
        while (j <= e) {
            merge[k++] = arr[j++];
        }
        for (int p = 0; p < merge.length; p++) {
            arr[s + p] = merge[p];
        }
    }

    public static  void mergesort(int s,int e,int[] arr){
        if (s >= e) {
            return;
        }
        int mid = s + (e - s) / 4;
//        int mid2 = 3 * (s + (e - s)) / 4;

        mergesort(s, mid, arr);

        mergesort(mid + 1, e, arr);
        merge(s, mid, e, arr);
    }

    public static void time(int[] arr){
        long startTime = System.nanoTime();
        mergesort(0, arr.length - 1, arr);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000000.0;
        System.out.println(Arrays.toString(arr));
        System.out.println("Time : " + duration + " seconds" );
    }
}
