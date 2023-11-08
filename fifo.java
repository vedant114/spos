import java.io.*;
public class fifo {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int frames, pointer=0, hit=0, fault=0, ref_len=0;
        int buffer[], reference[], mem_layout[][];
        System.out.print("Enter the number of frames: ");
        frames=Integer.parseInt(br.readLine());
        System.out.print("Enter the length of reference string: ");
        ref_len=Integer.parseInt(br.readLine());
        reference=new int[ref_len];
        mem_layout=new int[ref_len][frames];
        buffer=new int[frames];
        for(int i=0; i<frames; i++) {
            buffer[i]=-1;
        }
        System.out.println("Enter the Reference string: ");
        for(int i=0; i<ref_len; i++) {
            reference[i]=Integer.parseInt(br.readLine());
        }
        System.out.println();
        for(int i=0; i<ref_len; i++) {
            int search=-1;
            for(int j=0; j<frames; j++) {
                if(buffer[j]==reference[i]) {
                    search=j;
                    hit++;
                    break;
                }
            }
            if(search==-1) {
                buffer[pointer]=reference[i];
                fault++;
                pointer++;
                if(pointer==frames) {
                    pointer=0;
                }
            }
            for(int j=0; j<frames; j++) {
                mem_layout[i][j]=buffer[j];
            }
        }
        for(int i=0; i<frames; i++) {
            for(int j=0; j<ref_len; j++) {
                System.out.printf("%3d", mem_layout[j][i]);
            }
            System.out.println();
        }
        System.out.println("The number of hits: "+hit);
        System.out.println("Hit ratio: "+(float)((float)hit/ref_len));
        System.out.println("The number of faults: "+fault);
    }
}
