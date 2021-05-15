package mang.thuchanh;

import java.util.Scanner;

public class Timgiatritrongmang {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap so luong can nhap ");
        int num = sc.nextInt();
        String [] students = new String [num];
        for( int i=0; i < students.length;i++){
            System.out.printf("Nhap phan tu thu %d:",(i+1));
            students[i] = sc.next();
        }
        System.out.println("Nhap chuoi can tim:");
        String x = sc.next();
        System.out.println(" Vi tri tim thay:" + checkVitri(x,students));
    }
    public static int checkVitri(String x, String students[]) {
        for (int i = 0; i < students.length; i++) {
            if(students[i].equals(x)){
                return i;
            }

        }
        return -1;
    }
}
