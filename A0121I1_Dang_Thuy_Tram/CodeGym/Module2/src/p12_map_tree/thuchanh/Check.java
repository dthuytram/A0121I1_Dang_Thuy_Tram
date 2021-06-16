package p12_map_tree.thuchanh;

import java.util.Collection;
import java.util.HashMap;

public class Check {
    public static void main(String[] args) {
        // k sap xep,
        // Linked: các phần tử có liên kết -> chậm
        // Sắp xếp theo key, sắp xếp theo mình quy định
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("1", "Nam");
        stringStringHashMap.put("2", "Ngan");
        stringStringHashMap.put(null, "Vuong");
        stringStringHashMap.put("2", "Nga");

//        Set<String> Strings = stringStringHashMap.keySet();
//        for (String key : Strings) {
//            System.out.println("key: " + key +"| Value: " +stringStringHashMap.get(key));
//        }

        // Entry: giống 1 list
//        Set<Entry<String, String>> entry= stringStringHashMap.entrySet();
//        for(Entry e:entry){
//            System.out.println("key: " + e.getKey() +"| Value: " +e.getValue());
//        }

        //In ra list, k in dc key
        Collection<String> stringList = stringStringHashMap.values();
        for (String value : stringList) {
            System.out.println("value: " + value);
        }
    }
}
