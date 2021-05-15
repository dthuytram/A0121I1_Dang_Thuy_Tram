package huongdoituong.thuchanh;

import java.util.Scanner;

public class Retangle_1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the width:");
        double width = sc.nextInt();
        System.out.println("Enter the height");
        double height = sc.nextInt();
        Retangle r = new Retangle(width, height);
        System.out.println("Retangle: "+ r.display());
    }



}
