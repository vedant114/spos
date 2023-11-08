import java.util.Scanner;
public class banker {
    private int need[][], allocate[][], max[][], avail[][], np, nr;

    private void input() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        np=sc.nextInt();
        System.out.print("Enter the number of resources: ");
        nr=sc.nextInt();
        need=new int[np][nr];
        allocate=new int[np][nr];
        max=new int[np][nr];
        avail=new int[np][nr];

        System.out.println("Enter allocation matrix: ");
        for(int i=0; i<np; i++) {
            for(int j=0; j<nr; j++) {
                allocate[i][j]=sc.nextInt();
            }
        }

        System.out.println("Enter max matrix: ");
        for(int i=0; i<np; i++) {
            for(int j=0; j<nr; j++) {
                max[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter available matrix: ");
        for(int i=0; i<nr; i++) {
            avail[0][i]=sc.nextInt();
        }

        sc.close();
    }

    private int[][] calc_need() {
        for(int i=0; i<np; i++) {
            for(int j=0; j<nr; j++) {
                need[i][j]=max[i][j]-allocate[i][j];
            }
        }
        return need;
    }

    private boolean check(int n) {
        for(int i=0; i<nr; i++) {
            if(avail[0][i]<need[n][i]) {
                return false;
            }
        }
        return true;
    }

    public void isSafe() {
        input();
        calc_need();
        boolean done[]=new boolean[np];
        int k=0;
        while(k<np) {
            boolean allocated=false;
            for(int i=0; i<np; i++) {
                if(!done[i] && check(i)) {
                    for(int j=0; j<nr; j++) {
                        avail[0][j]=avail[0][j]-need[i][j]+max[i][j];
                    }
                    System.out.println("Allocated process: "+i);
                    allocated=done[i]=true;
                    k++;
                }
            }
            if(!allocated) {
                break;
            }
        }
        if(k==np) {
            System.out.println("Safely Allocated!");
        }
        else {
            System.out.println("All processes can't be allocated safely!");
        }
    }

    public static void main(String[] args) {
        new banker().isSafe();
    }
}
