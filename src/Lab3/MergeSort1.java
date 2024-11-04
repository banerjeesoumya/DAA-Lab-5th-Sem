package Lab3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// TC - Merge Sort :- All Cases - O(nlogn)

public class MergeSort1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of elements in the array");
        n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            arr1[i] = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            arr2[k++] = i;
        }
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr3[i] = rand.nextInt(1000);
        }

        System.out.println("For the input " + n + " the cases are as follows:");

        System.out.println("Best case values: ");
        System.out.println("Original array: " + Arrays.toString(arr1));
        time(arr1);

        System.out.println("Average case values: ");
        System.out.println("Original array: " + Arrays.toString(arr3));
        time(arr3);

        System.out.println("Worst case values: ");
        System.out.println("Original array: " + Arrays.toString(arr2));
        time(arr2);
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
        for (int p = s; p <=e; p++) {
            arr[p] = merge[p - s];
        }
    }

    public static  void mergesort(int s,int e,int[] arr){
        if (s >= e) {
            return;
        }
        int mid = s + (e - s) / 2;

        mergesort(s, mid, arr);

        mergesort(mid + 1, e, arr);
        merge(s, mid, e, arr);
    }

    public static void time(int[] arr){
        long startTime = System.nanoTime();
        mergesort(0, arr.length - 1, arr);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000000.0;
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Time : " + duration + " seconds" );
    }
}
