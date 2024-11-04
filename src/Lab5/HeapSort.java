package Lab5;

import java.util.Arrays;

// TC - O(nlogn) for all cases

public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {41, 35, 17, 21, 79, 84, 71, 5, 23};
        heapSort(arr);
        System.out.println("After Sorting ");
        System.out.println(Arrays.toString(arr));
        buildMaxHeap(arr);
        arr = insert(arr, 0);

        int max = extractMax(arr);
        System.out.println("Extracted max: " + max);
        System.out.println("New root after extraction: " + arr[0]);
    }

    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }
    public static int left(int i) {
        return 2 * i + 1;
    }
    public static int right(int i) {
        return 2 * i + 2;
    }
    public static int parent(int i) {
        return (i - 1) / 2;
    }
    public static void buildMaxHeap(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }
    public static int[] insert(int arr[], int key) {
        int newarr[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        newarr[arr.length] = key;
        int i = newarr.length - 1;
        while (i != 0 && newarr[parent(i)] < newarr[i]) {
            int temp = newarr[i];
            newarr[i] = newarr[parent(i)];
            newarr[parent(i)] = temp;
            i = parent(i);
        }
        return newarr;
    }
    public static int extractMax(int arr[]) {
        if (arr.length < 1) {
            throw new RuntimeException("Heap underflow");
        }
        int max = arr[0];
        arr[0] = arr[arr.length - 1];
        heapify(arr, 0, arr.length - 1);

        return max;
    }

    public static void heapify(int arr[], int i, int size) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < size && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < size && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, size);
        }
    }
}