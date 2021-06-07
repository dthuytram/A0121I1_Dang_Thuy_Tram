package vonglap.thuchanh;

import java.util.Scanner;

public class Loaihinh {

    public static void main(String[] args) {
        int choice = -1;
        java.util.Scanner input = new java.util.Scanner(System.in);

        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square triangle");
            System.out.println("3. Draw  isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            Scanner sc1= new Scanner(System.in);

            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                    System.out.println("a= ");
                    int a=sc1.nextInt();
                    System.out.println("b= ");
                    int b=  sc1.nextInt();
                    for( int i=1;i<=a;i++){
                        for( int j=1;j<=b;j++){
                            System.out.print(" * ");
                        }
                        System.out.print("\n");
                    }

                    break;
                case 2:
                    System.out.println("Draw the square triangle");
//                    System.out.println("top-left");
//                    Scanner sc = new Scanner(System.in);
//                    System.out.println("Nhap chieu cao");
//                    int h = sc.nextInt();
//                    for( int i=h ; i>=1 ; i--){
//                        for( int j=1 ; j<=i ; j++){
//                            System.out.print(" * ");
//                        }
//                        System.out.print("\n");
//                    }
                    // bottom-left
//                    System.out.println("top-right");
//                    Scanner scs = new Scanner(System.in);
//                    System.out.println("Nhap chieu cao");
//                    int hs = scs.nextInt();
//                    for( int i=1; i<=hs ; i++){
//                        for( int j=1 ; j<=i ; j++){
//                            System.out.print(" * ");
//                        }
//                        System.out.print("\n");
//                    }
                    // top-right
//                    System.out.println("top-right");
//                    Scanner scs = new Scanner(System.in);
//                    System.out.println("Nhap chieu cao");
//                    int h = scs.nextInt();
//                    for( int i=1; i<=h ; i++){
//
//                        for( int j=1; j<=h; j++){
//
//                            if(j<i) System.out.print("   ");
//                            else System.out.print(" * ");
//                        }
//                        System.out.print("\n");
//                    }
                    // bottom-right
                    System.out.println("Nhap h:");
                    a= sc1.nextInt();
                    for(int i=1;i<=a;i++){
                        for( int j=1;j<=a;j++){
//                            System.out.println(j+" "+a);

                            if(j>(a-i))System.out.print(" * ");
                            else System.out.print("   ");
                        }
                        System.out.print("\n");
                    }

                    break;
                case 3:
                    System.out.println("Draw isosceles triangle");
                    a= sc1.nextInt();
                    for(int i=1;i<=a;i++){
                    for( int j=1; j<=a-i;j++) {
                        System.out.print("   ");
                    }
                        for(int j=1;j<=2*i-1;j++) {
                            System.out.print(" * ");
                        }
                        System.out.print("\n");
                    }

                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
