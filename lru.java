import java.util.*;

public class lru {
    int p[], n, fr[], m, fs[], index, k, l, flag1 = 0, flag2 = 0, pf = 0, i, j;
    Scanner src = new Scanner(System.in);

    void read() {
        System.out.print("Enter page table size: ");
        n = src.nextInt();
        p = new int[n];
        System.out.print("Enter the elements in page table: ");
        for (int i = 0; i < n; i++)
            p[i] = src.nextInt();

        System.out.print("Enter page frame size: ");
        m = src.nextInt();
        fr = new int[m];
        fs = new int[m];
    }

    void display() {
        System.out.println();
        for (i = 0; i < m; i++) {
            if (fr[i] == -1)
                System.out.print("[ ]");
            else
                System.out.print("[" + fr[i] + "]");
        }
        System.out.println();
        System.out.println();
    }

    void lrualgo() {
        for (i = 0; i < m; i++) {
            fr[i] = -1;
        }
        for (j = 0; j < n; j++) {
            flag1 = 0;
            flag2 = 0;
            for (i = 0; i < m; i++) {
                if (fr[i] == p[j]) {
                    flag1 = 1;
                    flag2 = 1;
                    break;
                }
            }
            if (flag1 == 0) {
                for (i = 0; i < m; i++) {
                    if (fr[i] == -1) {
                        fr[i] = p[j];
                        flag2 = 1;
                        break;
                    }
                }
            }
            if (flag2 == 0) {
                for (i = 0; i < m; i++) {
                    fs[i] = 0;
                }
                for (k = j - 1, l = 1; l <= m - 1; l++, k--) {
                    for (i = 0; i < m; i++) {
                        if (fr[i] == p[k]) {
                            fs[i] = 1;
                            break;
                        }
                    }
                }
                index = 0;
                for (i = 1; i < m; i++) {
                    if (fs[i] < fs[index]) {
                        index = i;
                    }
                }
                fr[index] = p[j];
                pf++;
            }
            System.out.print("Page: " + p[j]);
            display();
        }
        System.out.println("\nNumber of Page faults: " + pf);
    }

    public static void main(String args[]) {
        lru obj = new lru();
        obj.read();
        obj.lrualgo();
    }
}
