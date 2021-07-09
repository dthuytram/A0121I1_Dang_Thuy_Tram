package final_exam.Service;

import final_exam.Commons.ReadWriteFile;
import final_exam.Commons.Validator;
import final_exam.Model.SPXuatKhau;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XuatKhauService {
    private Validator regex;
    private Scanner sc;
    private ReadWriteFile readWriteFile;
    private String XUATKHAU_PATH ="D:/Java/A0121I1-NguyenThiNga/Module_2/module02/src/final_exam/data/XuatKhau.csv";
    private List<SPXuatKhau> xuatkhauList;
    private CommonService commonService;
    public XuatKhauService(){
        regex = new Validator();
        sc = new Scanner(System.in);
        readWriteFile = new ReadWriteFile();
        xuatkhauList = new ArrayList<>();
        commonService = new CommonService();
        getAllXuatKhau();
    }
    public List<SPXuatKhau> getAllXuatKhau(){
        String[] nhapKhauListLine = new String[0];
        nhapKhauListLine = readWriteFile.readFile(XUATKHAU_PATH).split("\n");
        for(int i =0;i<nhapKhauListLine.length;i++){
            String [] tTinhNK = nhapKhauListLine[i].split(",");
            xuatkhauList.add(new SPXuatKhau(tTinhNK[0],tTinhNK[1],tTinhNK[2],tTinhNK[3],tTinhNK[4],tTinhNK[5],tTinhNK[6],tTinhNK[7]));
        }
        return xuatkhauList;
    }
    public void view(){
        xuatkhauList.forEach(x-> System.out.println(x.toString()));
    }
    public List<SPXuatKhau> getXuatkhauList(){
        return xuatkhauList;
    }
    public void updateData(){
        String data ="";
        for(int i = 0;i<xuatkhauList.size();i++){
            xuatkhauList.get(i).setId((i+1)+"");
            data+=xuatkhauList.get(i).toString()+"\n";
        }
        readWriteFile.writeFile(XUATKHAU_PATH,data,false);
    }
    public void inputNewXuatKhau(){

        System.out.println("-------------------------------------------------");
        System.out.println("Thêm sản phẩm nhập khẩu Nhập Khẩu  : ");
        SPXuatKhau newXuatKhau = (SPXuatKhau) commonService.inputSanPham(2);
        String giaXuatKhau;
        String quocGia;
        String thueNhapKhau;

        System.out.println("Nhap gia xuat khau");
        giaXuatKhau=sc.nextLine();
        while(!regex.validateNumber(giaXuatKhau)){
            System.out.println("Please, Try again!");
            giaXuatKhau =  (sc.nextLine());
        };

        System.out.println("Nhap quoc gia san pham");
        quocGia = sc.nextLine();
        newXuatKhau.setGiaXuatKhau(giaXuatKhau);
        newXuatKhau.setQuocGia(quocGia);
        newXuatKhau.setId(xuatkhauList.size()+1+"");
        readWriteFile.writeFile(XUATKHAU_PATH,newXuatKhau.toString(),true);

    }
    public  void searchXuatKhau(){
        List<SPXuatKhau> ListResult = new ArrayList<>();
        System.out.println("Input key you want to search ");
        String key = sc.nextLine();
        for(SPXuatKhau nhapkhau:xuatkhauList){
            if(nhapkhau.getMasp().contains(key)){
                ListResult.add(nhapkhau);
            }
        }
        ListResult.forEach(x-> System.out.println(x.toString()));
    }
    public void deleteXuatKhau(){
        System.out.println("NHAP Ma san pham can xoa");
        String maSP = sc.nextLine();
        for(int i =0;i<xuatkhauList.size();i++){
            if(xuatkhauList.get(i).getMasp().equals(maSP)){

                System.out.println("Co san pham");
                System.out.println("yes or no");
                String option = sc.nextLine();
                if(option.equals("yes")){
                    xuatkhauList.remove(i);
                    updateData();
                    System.out.println("Danh sach sau khi xoa");
                    view();
                }
            }
        }
    }
}
