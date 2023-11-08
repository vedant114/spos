import java.util.*;
public class fcfs {
    public static void main(String[] args) {
        int n, sum=0;
        float total_tt=0, total_waiting=0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of processes you want to execute: ");
        n=sc.nextInt();
        int arrival[]=new int[n];
        int cpu[]=new int[n];
        int finish[]=new int[n];
        int turntt[]=new int[n];
        int wait[]=new int[n];
        int process[]=new int[n];

        for(int i=0; i<n; i++) {
            System.out.print("Enter the arrival time of "+(i+1)+" process: ");
            arrival[i]=sc.nextInt();
            System.out.print("Enter CPU time of "+(i+1)+" process: ");
            cpu[i]=sc.nextInt();
            process[i]=i+1;
        }
        for(int i=0; i<n; i++) {
            sum+=cpu[i];
            finish[i]=sum;
        }
        for(int i=0; i<n; i++) {
            turntt[i]=finish[i]-arrival[i];
            total_tt+=turntt[i];
            wait[i]=turntt[i]-cpu[i];
            total_waiting+=wait[i];
        }
        System.out.println("\nProcess\t\tAT\tCPU_T");
        for(int i=0; i<n; i++) {
            System.out.println(process[i]+"\t\t"+arrival[i]+"\t"+cpu[i]);
        }
        System.out.println("Total turnaround time is: "+(total_tt/n));
        System.out.println("Total waiting time is: "+(total_waiting/n));
        sc.close();
    }
}
