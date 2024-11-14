import java.util.Scanner;
class Main{
public static void main(String args[]){
int burst_time[],process[],waiting_time[],tat[],i,j,n,total=0,pos,temp;
float wait_avg, TAT_avg;
Scanner s = new Scanner(System.in);
System.out.print("Enter number of process: ");
n = s.nextInt();
process = new int[n];
burst_time = new int[n];
waiting_time = new int[n];
tat = new int[n];
System.out.println("\nEnter Burst time:");
for(i=0;i<n;i++)
{
System.out.print("\nProcess["+(i+1)+"]: ");
burst_time[i] = s.nextInt();;
process[i]=i+1; //Process Number
}
//First process has 0 waiting time
waiting_time[0]=0;
//calculate waiting time
for(i=1;i<n;i++)
{
waiting_time[i]=0;
for(j=0;j<i;j++)
waiting_time[i]+=burst_time[j];
total+=waiting_time[i];
}
//Calculating Average waiting time
wait_avg=(float)total/n;
total=0;
System.out.println("\nProcess\t Burst Time \tWaiting Time\tTurnaround Time");
for(i=0;i<n;i++)
{
tat[i]=burst_time[i]+waiting_time[i];
total+=tat[i];//Calculating TurnaroundTimetotal+=tat[i];
System.out.println("\n p"+process[i]+"\t\t"+burst_time[i]+"\t\t"+waiting_time[i]+"\t\t "+tat[i]);
}
//Calculation of Average Turnaround Time
TAT_avg=(float)total/n;
System.out.println("\n\nAverage Waiting Time: "+wait_avg);
System.out.println("\nAverage Turnaround Time: "+TAT_avg);
}
}
/* OUTPUT
D:\SPOS>java fcfs
Enter number of process: 4
Enter Burst time:
Process[1]: 3
Process[2]: 5
Process[3]: 2
Process[4]: 10
Process Burst Time Waiting Time Turnaround Time
p1 3 0 3
p2 5 3 8
p3 2 8 10
p4 10 10 20
Average Waiting Time: 5.25
Average Turnaround Time: 10.25
*/