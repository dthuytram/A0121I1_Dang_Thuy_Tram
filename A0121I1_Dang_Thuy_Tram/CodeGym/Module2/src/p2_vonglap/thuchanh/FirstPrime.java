package vonglap.thuchanh;

import java.util.Scanner;

public class FirstPrime {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        checkPrime(n);
    }
    public static void checkPrime(int n){
        boolean[] isPrime = new boolean[n+1]; // khoi tao mang boolean
        for( int i=0;i<=n;i++){
            isPrime[i]= true;
        }
        isPrime[0]= false;
        isPrime[1]= false;
        for( int i=2;i<=Math.sqrt(n);i++){
            if(isPrime[i] ==true){
                for(int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }System.out.println("So nguyen to tu 1 den "+ n +"la: " );
        for( int i=0;i<=n;i++){
            if(isPrime[i]== true) System.out.print(" "+ i);
        }
    }
}
