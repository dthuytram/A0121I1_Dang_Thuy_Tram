package p12_map_tree.baitap.productManager_LinkedList;

import p12_map_tree.baitap.productManager_ArrayList.Product;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * lhl
 * Editor: 6/7/2021
 */
public class ProductManagerLinkedList {
    Scanner scanner = new Scanner(System.in);
    LinkedList<Product> productLinkedList = new LinkedList<>();

    public ProductManagerLinkedList() {
    }
    public ProductManagerLinkedList(Scanner sc, LinkedList<Product> linkedList) {
        this.scanner = sc;
        this.productLinkedList = linkedList;
    }


    // Thêm 1 product vào đầu danh sách liên kết
    public void addFirstProduct(Product product) {
        productLinkedList.addFirst(product);
    }

    // Thêm 1 product vào cuối danh sách liên kết
    public void addLastProduct(Product product) {
        productLinkedList.addLast(product);
    }

    // Thêm tất cả các phần tử của Collection vào "cuối danh sách" liên kết của Collection hiện tại
    // Với addingList là List được add vào
    public void addAllProduct(ProductManagerLinkedList addingList) {
        productLinkedList.addAll(addingList.productLinkedList);
    }

    // Chèn 1 product vào 1 vị trí index được chọn
    // IllegalArgumentException: " Tham số được sử dụng để gọi phương thức không hợp lệ "
    public void insertProduct(int index, Product product) {
        if (index > productLinkedList.size() - 1 || index < 0) {
            throw new IllegalArgumentException("sai hinh thuc add Product");
        } else {
            productLinkedList.add(index, product);
        }
    }

    // Chèn tất cả các phần tử của Collection  bắt đầu từ vị trí index của Collection hiện tại
    public void insertAllProduct(int index, ProductManagerLinkedList addingList) {
        if (index > productLinkedList.size() - 1 || index < 0) {
            throw new IllegalArgumentException(" sai hinh thuc add Product");
        } else {
            productLinkedList.addAll(index, addingList.productLinkedList);
        }
    }

    // Xóa 1 product
    public void deleteProduct(Product product) {
        if (productLinkedList.contains(product)) {
            productLinkedList.remove(product);
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Xóa 1 product được chỉ định và trả về 1 product đó
    public Product removeProduct(Product product) {
        if (productLinkedList.contains(product)) {
            return productLinkedList.remove(productLinkedList.indexOf(product));
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Xóa 1 product tại vị trí index chỉ định và trả về product đó
    public Product removeProduct(int index) {
        if (index > productLinkedList.size() - 1 || index < 0) {
            throw new IllegalArgumentException();
        } else {
            return productLinkedList.remove(index);
        }
    }

    // Trả về product tại vị trí index trong danh sách
    public Product getProduct(int index) {
        if (index > productLinkedList.size() - 1 || index < 0) {
            throw new IllegalArgumentException();
        } else {
            return productLinkedList.get(index);
        }
    }

    // Trả về product đầu tiên
    public Product getFirstProduct() {
        return productLinkedList.getFirst();
    }

    // Trả về product cuối cùng
    public Product getLastProduct() {
        return productLinkedList.getLast();
    }

    // Tìm kiếm 1 product
    public Product searchProduct() {
        Product product = null;
        String id;
        String name;
        boolean check;
        boolean isExist = false;
        do {
            check = false;
            System.out.println("Tìm product theo ID hay theo tên của product?");
            System.out.println("0. ID \n1. Name of product");
            int choose = scanner.nextInt();
            scanner.skip("\\R");
            switch (choose) {
                case 0: {
                    System.out.println("Nhập ID cần tìm: ");
                    id = scanner.nextLine();
                    System.out.println("id đã nhập: "+ id);
                    for (Product value : productLinkedList) {
                        if (value.getId() == id) {
                            product = value;
                            isExist = true;
                            System.out.printf("product có ID %s có trong danh sách!\n", id);
                            break;
                        }
                    }
                    if (!isExist) {
                        System.out.printf("Không tìm thấy product có ID %s cần tìm!\n", id);
                    }
                    break;
                }
                case 1: {
                    System.out.println("Nhập tên product cần tìm: ");
                    name = scanner.nextLine();
                    for (Product value : productLinkedList) {
                        if (value.getName().equals(name)) {
                            product = value;
                            isExist = true;
                            System.out.printf("product %s có trong danh sách!\n", name);
                            break;
                        }
                    }
                    if (!isExist) {
                        System.out.printf("Không tìm thấy tên product %s cần tìm!\n", name);
                    }
                    break;
                }
                default: {
                    System.out.println("Mời nhập lại");
                    check = true;
                }
            }
        } while (check);
        return product;
    }

    // Tìm kiếm 1 product được chọn
    public void searchProduct(Product product) {
        boolean isExist = false;
        for (int i = 0; i < productLinkedList.size(); ++i) {
            if (productLinkedList.get(i).equals(product)) {
                System.out.println("product cần tìm có trong danh sách, ở vị trí index: " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Không tìm thấy product cần tìm!\n");
        }
    }

    // Sắp xếp ID product theo thứ tự tăng dần
    public void sortProduct() {
        Collections.sort(productLinkedList);
    }

    // Change Info của phần tử được chọn theo index
    public void changeInfoProduct(int index) {
        Product product = productLinkedList.get(index);
        int choice;
        if (index > productLinkedList.size() - 1 || index < 0) {
            throw new IllegalArgumentException();
        } else {
            boolean check;
            do {
                check = false;
                System.out.println("Thông tin muốn sửa: ");
                System.out.println("0. ID \n1. Name product.Product: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 0: {
                        System.out.print("Nhập lại ID của product: ");
                        product.setId(scanner.nextLine());
                        System.out.println("Đã thay đổi thành công!");
                        break;
                    }
                    case 1: {
                        System.out.print("Nhập lại tên của product: ");
                        product.setName(scanner.nextLine());
                        System.out.println("Đã thay đổi thành công!");
                        break;
                    }
                    default: {
                        System.out.println("Nhập sai. Mời nhập lại!");
                        check = true;
                    }
                }
            }while(check);
        }
        System.out.printf("Sau khi thay đổi, product tại index %d có thông tin mới là", index);
        System.out.println(product.toString());
    }

    // Thay đổi thông tin của 1 product được chọn theo tên Object
    public void changeInfoProduct(Product product) {
        boolean check;
        do {
            check = false;
            System.out.println("Bạn muốn sửa thông tin nào?");
            System.out.println("0. ID \n1. Name product.Product");
            int choose = scanner.nextInt();
            switch (choose) {
                case 0: {
                    System.out.print("Nhập lại ID của product.Product: ");
                    product.setId(scanner.nextLine());
                    System.out.println("Đã thay đổi thành công!");
                    break;
                }
                case 1: {
                    System.out.print("Nhập lại tên của product.Product: ");
                    product.setName(scanner.nextLine());
                    System.out.println("Đã thay đổi thành công!");
                    break;
                }
                default: {
                    System.out.println("Nhập sai tính năng. Mời nhập lại!");
                    check = true;
                }
            }
        } while (check);
        System.out.print("Sau khi thay đổi, product có thông tin mới là: ");
        System.out.println(product.toString());
    }

    // In ra thông tin của 1 product
    public void showProduct(Product product) {
        System.out.println(product.toString());
    }

    // In ra thông tin của tất cả product
    public void showAllProduct(ProductManagerLinkedList managerLinkedList) {
        for (Product product : managerLinkedList.productLinkedList) {
            System.out.println(product.toString());
        }
    }
    

}
