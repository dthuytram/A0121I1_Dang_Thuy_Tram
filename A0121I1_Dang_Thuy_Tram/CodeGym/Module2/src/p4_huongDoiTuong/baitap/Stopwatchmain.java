package huongdoituong.baitap;

import java.util.*;

public class Stopwatchmain {

    public static void main(String[] args) {
        int i;
        int[] ar1 = new int[100000];
        for(i = 0; i <  ar1.length; i++) {
            ar1[i] = ((int)(Math.random() * 100000));

        }
        Stopwatch st = new Stopwatch();
        Arrays.sort(ar1);
        st.stop();
        System.out.println(st.getElapsedTime());
    }

}
