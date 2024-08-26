package Lab6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the no:of elements");
        n = sc.nextInt();
        Item[] arr = new Item[n];
        int max;
        System.out.println("Enter the maximum capacity");
        max = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight and value for item " + (i + 1) + ":");
            int weight = sc.nextInt();
            int value = sc.nextInt();
            arr[i] = new Item(weight, value);
        }
        double maxValue = getMax(arr, max);
        System.out.println("Maximum Value: " + maxValue);
    }

    public static double getMax(Item[] items, int max) {
        Arrays.sort(items, Comparator.comparingDouble(item -> -(double) item.value / item.weight));
        double tot = 0;
        for (Item item : items) {
            if (max >= item.weight) {
                max = max - item.weight;
                tot = tot + item.value;
            } else {
                tot = tot + (item.value) * ((double) max / item.weight);
                break;
            }
        }
        return tot;
    }
}

class Item {
    int weight, value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
