package p8_cleanCodeRefactoring.thuchanh.refactoring;
//
public class FizzBuzz {
    public static String fizzBuzz(int number){
        int isFuzz = number % 3;
        int isBizz = number % 5;
        if(isFuzz == 0 && isBizz == 0)
            return "FizzBuzz";

        if(isFuzz == 0)
            return "Fizz";

        if(isBizz == 0)
            return "Buzz";

        return number + "";
    }
}