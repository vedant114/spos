import java.io.*;
public class optimal {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int frames, pointer=0, hit=0, fault=0, ref_len;
        boolean isFull=false;
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
        System.out.println("Enter the reference string: ");
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
                if(isFull) {
                    int index[]=new int[frames];
                    boolean index_flag[]=new boolean[frames];
                    for(int j=i+1; j<ref_len; j++) {
                        for(int k=0; k<frames; k++) {
                            if((reference[j]==buffer[k]) && (index_flag[k]==false)) {
                                index[k]=j;
                                index_flag[k]=true;
                                break;
                            }
                        }
                    }
                    int max=index[0];
                    pointer=0;
                    if(max==0) {
                        max=200;
                    }
                    for(int j=0; j<frames; j++) {
                        if(index[j]==0) {
                            index[j]=200;
                        }
                        if(index[j]>max) {
                            max=index[j];
                            pointer=j;
                        }
                    }
                }
                buffer[pointer]=reference[i];
                fault++;
                if(!isFull) {
                    pointer++;
                    if(pointer==frames) {
                        pointer=0;
                        isFull=true;
                    }
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
        System.out.println("Number of page faults: "+fault);
    }
}