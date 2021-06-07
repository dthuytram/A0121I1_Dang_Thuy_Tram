package p2_vongLap.thuchanh;

import java.util.Scanner;

public class Nguyento {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("New num:");
        int num = sc.nextInt();
        if(checkPrime(num)) System.out.println("is Prime");
        else System.out.println("not Prime");
    }
    public static boolean checkPrime(int num){
        int i=2;
        boolean check= true;
        while (i <= Math.sqrt(num)) {
            if (num % i == 0) {
                check = false;
                break;
            }
            i++;
        }
        if(check) return true;
        else return false;

    }
}
