package arrayList.thuchanh;
import java.util.*;
public class IteratorDemo {
    public static void main(String[] args) {
//        Taoj list

        List <Integer> listIntegers = new ArrayList<>();
        listIntegers.add(1);
        listIntegers.add(2);
        listIntegers.add(3);
        listIntegers.add(4);
        listIntegers.add(5);

        /** iterator: thay thế for
        Mục đích: để duyệt qua các phần tử trong tập hợp
        Công thức tạo:
         Iterator<Integer> iterator = listIntegers.iterator();
         trong đó:
            listIntegers: List dc tạo trước khi tạo iterator
         **/

        Iterator<Integer> iterator = listIntegers.iterator();
        /**
         * In ra phần tử đầu tiên
         */
//        System.out.println(iterator.next());
        /**
         * Duyệt tất cả phần tử Iterator = pthuc hasNext()
         * Muốn lấy phần tử ra = phthuc next()
         */
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        /**
         * Xóa phân tử = phthuc remove()
         */
//        while(iterator.hasNext()) {
//            Integer i = iterator.next();
//            if(i < 3) {
//                iterator.remove();
//            }
//        }
//        System.out.println(listIntegers);
        while(iterator.hasNext()){
            System.out.printf("%5d", iterator.next());
        }



    }
}