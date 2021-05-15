package huongdoituong.thuchanh;

import java.util.Scanner;

public class Bachai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap a:");
        double a = sc.nextDouble();
        System.out.println("Nhap b:");
        double b = sc.nextDouble();
        System.out.println("Nhap c:");
        double c = sc. nextDouble();
        Phuongtrinhbachai pt = new Phuongtrinhbachai(a,b,c);
        double r1 = pt.getRoot1(a,b,c);
        double r2 = pt.getRoot2(a,b,c);
        System.out.println(pt.getDiscriminal(a,b,c));
        if(pt.getDiscriminal(a,b,c)>0) System.out.println("delta=" + pt.getDiscriminal(a,b,c)+" pt co hai no:"+ r1 +" va "+ r2);
        else if (pt.getDiscriminal(a,b,c) == 0) System.out.println("pt co 1 no"+ r1);
        else System.out.println(" pt vo no");

    }
}
