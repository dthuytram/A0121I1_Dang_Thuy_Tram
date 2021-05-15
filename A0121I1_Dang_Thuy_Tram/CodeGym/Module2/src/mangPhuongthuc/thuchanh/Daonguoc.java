package mang.thuchanh;

import java.util.Scanner;

public class Daonguoc {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap so luong cua mang");
        int num = sc.nextInt();
        int[] n= new int[num];
        int[] m= new int[num];
        for( int i=0; i< n.length; i++){
            System.out.printf("Phan tu thu %d la:",i+1);
            n[i] = sc.nextInt();
            int j = n.length-1 - i;
            m[j]= n[i];

        }
//        for(int i:n){
//            System.out.println(i);
//        }
        for(int j:m){
            System.out.print(j+" ");
        }

    }
}
