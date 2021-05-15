package mang.thuchanh;

import java.util.Scanner;

public class Xoaphantu {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int []a= {1,2,3,4,5};
        int x = sc.nextInt();
        int n= a.length;
        int vt= Timphantu(a,x);
        System.out.println("So o vi tri:"+vt);
        if(vt!=-1) {
            for(int i=vt; i<=a.length-2;i++){
                a[i]=a[i+1];
            }
            n--;
        }
        else System.out.println("k tim thay");
        System.out.println(" Cac phan tu:" );
        for(int i:a){

            System.out.print(a[i]+" ");
        }
    }
    public static int Timphantu(int a[], int x){
        for( int i:a){
            if(a[i]==x) return i;
        }
        return -1;
    }
}
