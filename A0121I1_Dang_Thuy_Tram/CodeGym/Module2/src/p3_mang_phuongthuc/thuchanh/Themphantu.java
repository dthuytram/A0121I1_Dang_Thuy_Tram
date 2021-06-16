package mang.thuchanh;

import java.util.Scanner;

public class Themphantu {
    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
        int a[]= {1,2,3,4,5};

        int b[]={8,9,10};
        for( int j:b){
            System.out.println(b[j]);
        }
        int []c= new int [10];
        for( int j:c){
            System.out.println(c[j]);
        }
        int n = a.length;
        int m = b.length;
//        System.out.println("Nhap so x: ");
//        int x = sc.nextInt();
//        System.out.println("Vi tri can them: ");
//        int vt = sc.nextInt();
//        System.out.println("vi tri"+ vt);
//        ThemPhanTu(a,x,vt);
        for(int i= 0; i<(m+n);i++){

            if(i<n){
                c[i] = a[i];
            }
            else c[i] = b[i-n];
            i++;
        }
        for( int j:c){
            System.out.println(c[j]);
        }

    }
    public static void ThemPhanTu(int a[], int x, int vt)
    {
        int n= a.length;
        System.out.println(n);
        if(vt>=0 && vt<=n)
        {

            for(int i=n; i>vt; i--)
            {

                a[i] = a[i-1]; //Dịch các phần tử sang phải 1 vị trí
            }
            a[vt]=x; //Thêm x vào vị trí vt
            n++; //Tăng số phần tử lên 1
        }
        else
        {
            System.out.printf("\nVi tri %d khong hop le.", vt);
        }
        for(int i=0 ; i<n ;i++){
            System.out.println(a[i]);
        }

    }
    public  static  void Gopmang(int a[], int b[], int c[],int n){
        int i= 0;
        while(i<=(a.length+b.length)){
            if(i<n){
                c[i] = a[i];
            }
            else c[i] = b[i-n];
            i++;
        }
        for( int j:c){
            System.out.println(c[j]);
        }
    }
    
}
