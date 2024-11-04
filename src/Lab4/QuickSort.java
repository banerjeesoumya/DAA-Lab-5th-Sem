package Lab4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// TC - Best Case :- O(nlogn), Average Case :- O(nlogn), Worst Case :- O(n^2)

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = i;
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
        System.out.println("Original array: " + Arrays.toString(arr));
        time(arr);
        System.out.println("Average case values: ");
        System.out.println("Original array: " + Arrays.toString(arr3));
        time(arr3);
        System.out.println("Worst case values: ");
        System.out.println("Original array: " + Arrays.toString(arr2));
        time(arr2);
    }


    public static void quicksort(int[] arr, int s, int e) {
        if (s < e) {
            int q = quick(arr, s, e);
            quicksort(arr, s, q - 1);
            quicksort(arr, q + 1, e);
        }
    }

    public static int quick(int[] arr, int s, int e) {
        int i = s;
        int j = e;
        int key = arr[s];
        while (i < j) {
            while (arr[i] <= key && i <= e - 1) {
                i++;
            }
            while (arr[j] > key && j >= i - 1) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, s, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

    public static void time(int arr[]) {
        long startTime = System.nanoTime();
        quicksort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Time Taken: " + duration);
    }

}
