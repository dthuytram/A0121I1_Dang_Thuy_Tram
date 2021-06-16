package p10_dsa_list.thuchanh;

import java.util.ArrayList;
import java.util.Arrays;

public class Check {
    public static void main(String[] args) {
//        ArrayList<String> cars = new ArrayList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//        for (int i = 0; i < cars.size(); i++) {
//            System.out.println(cars.get(i)); // lay danh sach du lieu
//        }
//        for (String i: cars){
//            System.out.println(i); // foreach moi thanh phan
//        }
//        List<String> list = new ArrayList<>();
//        list.add ("element 1");
//        list.add ("element 2");
//        list.add ("element 3");
//        list.add ("element 4");
//        List <String> sublist = list.subList(1,3); // subList se tra ve gia tri tu (vi tri 1) den (vi tri 2)
//        for(String i: sublist){
//            System.out.println(i);
//        }
        String[] arr = { "JAVA", "J2EE", "JSP", "SERVLETS" };

        // Array to ArrayList conversion
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));

        // Adding new elements to the converted List
        list.add("C#");
        list.add("PHP");

        // Print list data
        System.out.println(list); // [JAVA, J2EE, JSP, SERVLETS, C#, PHP]
    }
    }

