import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int x, n, awt = 0, atat = 0;
        int p[], pp[], bt[], w[], t[];

        p = new int[10];
        pp = new int[10];
        bt = new int[10];
        w = new int[10];
        t = new int[10];

        // n is number of processes
        // p is process IDs
        // pp is process priority
        // bt is process burst time
        // w is waiting time
        // t is turnaround time

        System.out.print("Enter the number of processes: ");
        n = s.nextInt();

        System.out.print("\nEnter burst time and priority for each process:\n");
        for (int i = 0; i < n; i++) {
            System.out.print("Process[" + (i + 1) + "]: ");
            bt[i] = s.nextInt();
            pp[i] = s.nextInt();
            p[i] = i + 1;
        }

        // Sorting processes based on priority (higher priority first)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pp[i] < pp[j]) {
                    // Swap priorities
                    x = pp[i];
                    pp[i] = pp[j];
                    pp[j] = x;

                    // Swap burst times
                    x = bt[i];
                    bt[i] = bt[j];
                    bt[j] = x;

                    // Swap process IDs
                    x = p[i];
                    p[i] = p[j];
                    p[j] = x;
                }
            }
        }

        // Calculate waiting times and turnaround times
        w[0] = 0;
        t[0] = bt[0];
        atat = t[0];

        for (int i = 1; i < n; i++) {
            w[i] = t[i - 1];
            awt += w[i];
            t[i] = w[i] + bt[i];
            atat += t[i];
        }

        // Display process information
        System.out.print("\nProcess\t\tBurst Time\tWait Time\tTurnaround Time\tPriority\n");
        for (int i = 0; i < n; i++) {
            System.out.print(p[i] + "\t\t" + bt[i] + "\t\t" + w[i] + "\t\t" + t[i] + "\t\t" + pp[i] + "\n");
        }

        // Calculate and display average waiting time and turnaround time
        double averageWaitTime = (double) awt / n;
        double averageTurnaroundTime = (double) atat / n;

        System.out.printf("\nAverage Waiting Time: %.2f", averageWaitTime);
        System.out.printf("\nAverage Turnaround Time: %.2f", averageTurnaroundTime);

        // Close the scanner
        s.close();
    }
}
