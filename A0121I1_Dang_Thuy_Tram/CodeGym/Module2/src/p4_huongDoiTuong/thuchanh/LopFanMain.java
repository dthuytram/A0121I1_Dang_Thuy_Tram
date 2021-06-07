package p4_huongDoiTuong.thuchanh;

public class LopFanMain {
    public static void main(String[] args) {
        huongdoituong.thuchanh.XaydunglopFan lopfan = new huongdoituong.thuchanh.XaydunglopFan(huongdoituong.thuchanh.XaydunglopFan.FAST,true,10,"yellow");
        huongdoituong.thuchanh.XaydunglopFan lopfan1 = new huongdoituong.thuchanh.XaydunglopFan(huongdoituong.thuchanh.XaydunglopFan.SLOW,false,5,"blue");
        System.out.println(lopfan.toString());
        System.out.println(lopfan1.toString());

    }
}
