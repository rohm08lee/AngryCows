import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter("angry.out");

        int N = sc.nextInt();
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);

        int max = 0;
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            int h = i+1, l = i-1;
            int t = 1;
            int curr = 1;
            boolean leftGoing = true, rightGoing = true;
            while(leftGoing || rightGoing){
                int count = 0;
                while(rightGoing && h < N && data[h] - data[h-1-count] <= t){
                    h++;
                    curr++;
                    count ++;
                }
                if(count == 0){rightGoing = false;}
                count = 0;
                while(leftGoing && l >= 0 && data[l+1+count] - data[l] <= t){
                    l--;
                    curr++;
                    count++;
                }
                if(count == 0){leftGoing = false;}
                t++;
            }

            max = Math.max(curr, max);
        }
        pw.println(max);
        pw.close();
    }
}
