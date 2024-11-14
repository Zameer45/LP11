import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        
        int wtime[], btime[], rtime[], num, quantum, total = 0;
        
        wtime = new int[10];
        btime = new int[10];
        rtime = new int[10];
        
        System.out.print("Enter number of processes (MAX 10): ");
        num = s.nextInt();

        System.out.print("Enter burst times:\n");
        for (int i = 0; i < num; i++) {
            System.out.print("P[" + (i + 1) + "]: ");
            btime[i] = s.nextInt();
            rtime[i] = btime[i];  // remaining time initially set to burst time
            wtime[i] = 0;
        }

        System.out.print("\nEnter quantum: ");
        quantum = s.nextInt();

        int rp = num;  // remaining processes
        int i = 0;
        int time = 0;

        System.out.print("0");  // initial time

        while (rp != 0) {
            if (rtime[i] > quantum) {
                rtime[i] -= quantum;
                System.out.print(" | P[" + (i + 1) + "] | ");
                time += quantum;
                System.out.print(time);
            } else if (rtime[i] <= quantum && rtime[i] > 0) {
                time += rtime[i];
                rtime[i] = 0;
                System.out.print(" | P[" + (i + 1) + "] | ");
                rp--;  // process completed
                System.out.print(time);
            }
            i++;
            if (i == num) {
                i = 0;
            }
        }

        s.close();
    }
}
