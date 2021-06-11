package xulyNgoaiLe_Debug.baitap.illegalTriangleException;

import java.util.Scanner;

public class IllegalTriangleException {
    public static void main(String[] args) throws IllegalAccessException  {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        boolean check = (a+b)<c||(b+c)<a||(a+c)<b;
        boolean checkNegative = (a<0) || (b<0) || (c<0);
        if( check || checkNegative){
                throw new IllegalAccessException(" Sai lỗi nhập");

        }
        else System.out.println(a*b*c);
    }
}
