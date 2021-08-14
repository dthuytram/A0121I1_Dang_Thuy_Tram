package model;

public class Calculator {
    public double calculator(double first , double second ,String openrator) throws Exception {
        if(openrator.equals("+")){
            return  first +second;
        }else if(openrator.equals("-")){
            return first - second;
        }else if(openrator.equals("*")){
            return first * second;
        }else if(openrator.equals("/")){
            if(second==0) {
                throw new RuntimeException("Can't divide by zero");
            }
            return first/second;
        }
        return 0;

    }
}
