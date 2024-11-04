package Lab7;

import java.util.Arrays;
import java.util.Scanner;

public class Job_Sequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of jobs:");
        n = sc.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the job " + (i + 1) + " deadline and profit respectively:");
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(i + 1, deadline, profit);
        }
        int[] ans = solution(jobs, n);
        System.out.println("Maximum Profit: " + ans[0]);
        System.out.println("Number of Jobs performed: " + ans[1]);
    }

    public static int[] solution(Job[] arr, int n) {
        // Sort jobs in descending order of profit
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        // Determine the maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxDeadline) {
                maxDeadline = arr[i].deadline;
            }
        }
        int[] res = new int[maxDeadline + 1];
        Arrays.fill(res, -1);

        int maxProfit = 0, count = 0;
        for (int i = 0; i < n; i++) {



            for (int j = arr[i].deadline; j > 0; j--) {
                if (res[j] == -1) {
                    res[j] = i;
                    maxProfit += arr[i].profit;
                    count++;
                    break;  
                }
            }
        }
        return new int[]{maxProfit, count};
    }
}

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
