package mapTree.baitap.arrayList_linkedList;

import mapTree.thuchanh.compareComparable_Comparator.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestMain {
    private static List<Product> lists = new ArrayList<>();
    static Product product;


    public static void addProduct() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ID: ");
        String id = sc.nextLine();
        System.out.println("Nhap name: ");
        String name = sc.nextLine();
        System.out.println("Nhap price: ");
        double price = sc.nextDouble();
        product = new Product(id, name, price);
        lists.add(product);
        System.out.println("add Successfully");
    }

    public static void editProductID(String id) {
        Scanner sc = new Scanner(System.in);

        product = getProductByID(id);
        System.out.println(" EDIT INFORMATION ");
        System.out.println(product.toString());

        System.out.println("ID: " + product.getId());
        System.out.print("Enter new name: ");
        String newName = sc.nextLine();
        product.setName(newName);
        System.out.print("Enter new price: ");
        Double newPrice = sc.nextDouble();
        product.setPrice(newPrice);
    }

    /**
     * Hai Hàm getProductByName & getProductByID
     * chú ý: "Giá trị trả về Product"
     *
     * @param id
     * @return
     */
    public static Product getProductByID(String id) {
        for (Product product : lists) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }


    public static Product getProductByName(String name) {
        for (Product product : lists) {
            if (product.getName().equals(name)) {
                return product;
            }
        }

        return null;
    }

    public static String searchProductByID(String id) {
        for (Product product : lists) {
            if (product.getId().equals(id)) {
                return "Data found:" + product;
            }
        }
        return "No data found";
    }

    public static String searchProductByName(String name) {
        for (Product list : lists) {
            if (list.getName().equals(name)) {

                return "Data found:" + list;
            }
        }
        return "No data found";
    }

    public static boolean deleteProductByID(String id) {
        for (Product product : lists) {
            if (searchProductByID(id) != "No data found") {
                lists.remove(product);
                System.out.println("list**" + lists.toString());
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Product product = new Product("1", "Nuoc hoa", 190000.0F);
        Product product1 = new Product("2", "Sua tam", 100000.0F);
        Product product2 = new Product("3", "Nuoc lau san", 23000.0F);
        Product product3 = new Product("4", "Hanh tay", 47000.0F);
        lists.add(product);
        lists.add(product1);
        lists.add(product2);
        lists.add(product3);
        System.out.println("list: " + lists.toString());
//        System.out.println("\n searchProductByID: " + searchProductByID("Sua tam"));
//        System.out.println("\n searchProductByName: " + searchProductByName("4"));
//        System.out.println("\n deleteproduct: " + deleteProductByID("Nuoc hoa"));
//        System.out.println("list after del: " + lists.toString());
//        Collections.sort(lists);
//        System.out.println("list after sort: " + lists.toString());
//
////      System.out.println("CHECK NAME : " + getProductByName("4"));
//        System.out.println("\n getProductByID:  " + getProductByID("Hanh tay"));
//        System.out.println("\n getProductByName:  " + getProductByName("3"));
//        editProductID("Sua tam");
//        System.out.println("list: "+ lists.toString());
        addProduct();
        System.out.println("list: "+ lists.toString());


    }


}
