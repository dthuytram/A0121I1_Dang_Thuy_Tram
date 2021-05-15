package access_modifier.thuchanh;

public class Simple {
    public static void main(String[] args) {
        Access_modifier obj = new Access_modifier();
        System.out.println(obj.data);
        obj.msg();
        //default: k dung bat ki modifier nao -> mac dinh
        //co the truy cap trong package, han che hon protectes va public


        // protected: trog vaf ngoai package, nhung chi thong qua ke thua

    }
}
