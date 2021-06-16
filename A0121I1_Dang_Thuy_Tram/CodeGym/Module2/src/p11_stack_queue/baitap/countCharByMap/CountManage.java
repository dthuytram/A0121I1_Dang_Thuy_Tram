package p11_stack_queue.baitap.countCharByMap;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CountManage {
    String str;

    public CountManage(String str) {
        this.str = str;
    }

    public TreeMap<String,Integer> countWord(){
        TreeMap<String,Integer> wordMap = new TreeMap<>();
        StringTokenizer words = new StringTokenizer(str, " ,;:.",false);
        while (words.hasMoreTokens()){
            String word = words.nextToken().trim();
            wordMap.merge(word,1,Integer::sum);
        }
        return wordMap;
    }

    public void displayMap(){
        TreeMap<String, Integer> wordMap = countWord();
        for (Map.Entry<String, Integer> word : wordMap.entrySet()) {
            System.out.println(word.getKey() + ": " + word.getValue());
        }
    }
}
