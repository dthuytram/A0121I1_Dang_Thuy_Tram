package p12_mapTree.baitap.demoClassFromA_LinhDoan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    static List<Product> productList;
    static Scanner sc = new Scanner(System.in);

    /**
     * Lưu ý (Bài học):
     * Static nên dùng ở đâu? có class k
     * +++Chú ý: Tìm kiếm gần đúng ( nếu nhập vào chữ a -> thì xuất ra 2 cái có chữ a )
     *
     */
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "iphone", 100, "abc"));
        productList.add(new Product(2, "samsung", 700, "abc"));
        productList.add(new Product(3, "sony", 650, "abc"));
        productList.add(new Product(4, "macbook", 140, "abc"));
        productList.add(new Product(5, "google", 234, "abc"));
    }

    public static void menu() {
        int choice = -1;
        do {
            System.out.println("Please enter your choice: " +
                    "\n 1. Show all product" +
                    "\n 2. Add new product" +
                    "\n 3. Edit product" +
                    "\n 4. Search product" +
                    "\n 5. Delete product" +
                    "\n 6. Exit");
            choice = sc.nextInt();
            // su dung moi thu nextline de bat enter
            sc.skip("\\R");
            switch (choice) {
                case 1:
                    displayProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (true);
    }

    public static void displayProduct() {
        for (Product product :
                productList) {
            System.out.println(product);
        }
    }

    public static void addProduct() {
        int id = -1;
        if (productList.isEmpty()) {
            id = 1;
        } else {
            id = productList.get(productList.size() - 1).getId() + 1;

        }
        //id tự tăng
        System.out.println("Please enter name: ");
        String name = sc.nextLine();
        System.out.println("Please enter price: ");
        double price = sc.nextDouble();
        sc.skip("\\R");
        System.out.println("Please enter description: ");
        String decription = sc.nextLine();
        Product product = new Product(id, name, price, decription);
        productList.add(product);
    }

    public static void deleteProduct() {
        System.out.println("Please enter id product: ");
        int id = sc.nextInt();
        sc.skip("\\R");   // tranh bi enter mat du lieu
        // skip này dùng cho khi sc.nextInt và nextDouble
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.remove(i);
                break;
            }
        }
    }

}
