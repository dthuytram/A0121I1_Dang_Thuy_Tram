package keThua.baitap;


import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập màu của tam giác ");
        String color=scanner.nextLine();
        System.out.println("nhập độ dài tam giác \n nhập a: ");
        int a=scanner.nextInt();
        System.out.println("nhập b: ");
        int b=scanner.nextInt();
        System.out.println("nhập c: ");
        int c=scanner.nextInt();

        Triangle triangle =new Triangle(color,a,b,c);
        System.out.println(triangle.toString());


    }
}