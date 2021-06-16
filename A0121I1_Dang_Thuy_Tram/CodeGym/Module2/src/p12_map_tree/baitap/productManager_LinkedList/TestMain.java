package p12_map_tree.baitap.productManager_LinkedList;

import p12_map_tree.baitap.productManager_ArrayList.Product;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Product product1 = new Product("howw", "102200389",13000.0F);
        Product product2 = new Product("abc", "102200345",13000.0F);
        Product product3 = new Product("chung ta","102200450", 460000.12220F);
        Product product4 = new Product("kpop","302298310", 6700000.01444F);
        Product product5 = new Product("header","240122400", 9870000.023F);
        Product product6 = new Product("money","583829510", 7200000.0F);
        Product product7 = new Product("tonkey","742957139", 7800000.0F);
        Product product8 = new Product("Opppo A12","493952031", 280000.01F);
        Product product9 = new Product("Xiaomi Note 10", "240012977", 1850000.0F);
        Product product10 = new Product("Huawei P30 Pro", "692502539", 24500000.0999F);


        ProductManagerLinkedList linkedlist1 = new ProductManagerLinkedList();
        ProductManagerLinkedList linkedlist2 = new ProductManagerLinkedList();
        ProductManagerLinkedList linkedlist3 = new ProductManagerLinkedList();
        ProductManagerLinkedList linkedlist4 = new ProductManagerLinkedList();

        System.out.println("\nSử dụng phương thức showProduct: showProduct1");
        linkedlist1.showProduct(product1);

        System.out.println("Thêm đầu dsach product1: ");
        linkedlist1.addFirstProduct(product1);
        System.out.println("Thêm cuối dsach product2,3,4,5: ");
        linkedlist1.addLastProduct(product2);
        linkedlist1.addLastProduct(product3);
        linkedlist1.addLastProduct(product4);
        linkedlist1.addLastProduct(product5);
        System.out.println("Sử dụng phương thức showAllProduct: ");
        linkedlist1.showAllProduct(linkedlist1);

        linkedlist2.addFirstProduct(product6);
        System.out.println("\nThêm các product 7, 9, 10 vào danh sách: ");
        linkedlist2.addLastProduct(product7);
        linkedlist2.addLastProduct(product9);
        linkedlist2.addLastProduct(product10);
        linkedlist2.showAllProduct(linkedlist2);


        System.out.println("\nThêm phần tử theo index: insertProduct(2, product8)");
        linkedlist2.insertProduct(2, product8);
        System.out.println("Sau khi insert:");
        linkedlist2.showAllProduct(linkedlist2);
        System.out.println("---------------------------------------------------------------------------------");

        /**
         Kiểm tra collectionManager1 và collectionManager2
         */
        System.out.println("Show các phần tử của Collection Manager1");
        linkedlist1.showAllProduct(linkedlist1);

        System.out.println("Show các phần tử của Collection Manager2");
        linkedlist2.showAllProduct(linkedlist2);


        System.out.println(
                "\nAdd tất cả phần tử product ở Collection productManager2 vào Collection productManager1:  ");
        linkedlist1.addAllProduct(linkedlist2);
        System.out.println("Sau khi add Collection productManager2 vào collection productManager1: ");
        linkedlist1.showAllProduct(linkedlist1);
        linkedlist3.addFirstProduct(product3);
        linkedlist3.addLastProduct(product4);
        linkedlist3.addLastProduct(product5);

        System.out.println("Sử dụng phương thức getFirst() với productManager1: ");
        Product getProductFirst = linkedlist1.getFirstProduct();
        System.out.println("Product đầu tiên là " + getProductFirst.toString());

        System.out.println("Sử dụng phương thức getLast() với productManagerLinkedList1: ");
        Product getLastProduct = linkedlist2.getLastProduct();
        System.out.println("Product cuối cùng là " + getLastProduct.toString());

        System.out.println("Sử dụng phương thức getProduct(int index): lấy product tại vị trí index = 4");
        Product getProduct = linkedlist2.getProduct(4);
        System.out.println("Product tại index = 4 là " + getProduct.toString());

        System.out.println("Sử dụng phương thức deleteProduct: delete product4 trong productManager4");
        System.out.println("Trước khi xóa product4: ");
        linkedlist4.showAllProduct(linkedlist4);
        System.out.println("Sau khi xóa product4: ");
        linkedlist4.deleteProduct(product4);
        linkedlist4.showAllProduct(linkedlist4);

        System.out.println("Sử dụng phương thức removeProduct(product.Product product): " +
                "remove product1 trong productManager4");
        System.out.println("Trước khi remove product1: ");
        linkedlist4.showAllProduct(linkedlist4);
        Product receiveProduct1;
        receiveProduct1 = linkedlist4.removeProduct(product1);
        System.out.println("Sau khi remove product1: ");
        linkedlist4.showAllProduct(linkedlist4);
        System.out.print("Product được trả về là: ");
        System.out.print(receiveProduct1);

        linkedlist1.showAllProduct(linkedlist1);
        System.out.println("Sử dụng phương thức searchProduct(): ");
        Product searchProduct = linkedlist1.searchProduct();
        System.out.println("Giá trị trả về là: " + searchProduct.toString());
        System.out.println("Tìm product8 trong productManagerLinkedList1: ");
        linkedlist1.searchProduct(product8);

        System.out.println("Sử dụng phương thức sapXepProduct() với Collection productManager1: ");
        System.out.println("Trước khi sắp xếp ID: ");
        linkedlist1.showAllProduct(linkedlist1);
        System.out.println("Sau khi sắp xếp ID: ");
        linkedlist1.sortProduct();
        linkedlist1.showAllProduct(linkedlist1);


        System.out.println(
                " Thay đổi product3 với Collection productManager1: ");
        linkedlist1.changeInfoProduct(product3);

        System.out.println(
                " Thay doi product tại vị trí index = 5 với Collection productManager1: ");
        linkedlist1.changeInfoProduct(5);
    }
}
