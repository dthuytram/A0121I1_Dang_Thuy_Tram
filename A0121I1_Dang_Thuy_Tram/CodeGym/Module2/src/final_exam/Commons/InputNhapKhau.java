package final_exam.Service;

import final_exam.Commons.ReadWriteFile;
import final_exam.Commons.Validator;
import final_exam.Model.SPNhapKhau;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhapKhauService {
    private Validator regex;
    private Scanner sc;
    private ReadWriteFile readWriteFile;
    private String NHAPKHAU_PATH ="D:/Java/A0121I1-NguyenThiNga/Module_2/module02/src/final_exam/data/NhapKhau.csv";
    private List<SPNhapKhau> nhapKhauList;
    private CommonService commonService;
    public NhapKhauService(){
        regex = new Validator();
        sc = new Scanner(System.in);
        readWriteFile = new ReadWriteFile();
        nhapKhauList = new ArrayList<>();
        commonService = new CommonService();
        getAllNhapKhau();
    }
    public List<SPNhapKhau> getAllNhapKhau(){
        String[] nhapKhauListLine = new String[0];
        nhapKhauListLine = readWriteFile.readFile(NHAPKHAU_PATH).split("\n");
        for(int i =0;i<nhapKhauListLine.length;i++){
            String [] tTinhNK = nhapKhauListLine[i].split(",");
            nhapKhauList.add(new SPNhapKhau(tTinhNK[0],tTinhNK[1],tTinhNK[2],tTinhNK[3],tTinhNK[4],tTinhNK[5],tTinhNK[6],tTinhNK[7],tTinhNK[8]));
        }
        return nhapKhauList;
    }
    public void view(){
        nhapKhauList.forEach(x-> System.out.println(x.toString()));
    }
    public List<SPNhapKhau> getNhapKhauList(){
        return nhapKhauList;
    }
    public void inputNewNhapKhau(){

        System.out.println("-------------------------------------------------");
        System.out.println("Thêm sản phẩm nhập khẩu Nhập Khẩu  : ");
        SPNhapKhau newNhapKhau = (SPNhapKhau) commonService.inputSanPham(1);
        String giaNhapKhau;
        String tinhThanhnhap;
        String thueNhapKhau;
        System.out.println("Nhap gia nhap khau");
        giaNhapKhau=sc.nextLine();
        while(!regex.validateNumber(giaNhapKhau)){
            System.out.println("Please, Try again!");
            giaNhapKhau =  (sc.nextLine());
        };
        System.out.println("Nhap tinh thành nhập");
        tinhThanhnhap = sc.nextLine();
        System.out.println("Nhập thuế nhập khẩu");
        thueNhapKhau= sc.nextLine();
        while(!regex.validateNumber(thueNhapKhau)){
            System.out.println("Please, Try again!");
            thueNhapKhau =  (sc.nextLine());
        };
        newNhapKhau.setGiaNhapKhau(giaNhapKhau);
        newNhapKhau.setTinhThanhNhap(tinhThanhnhap);
        newNhapKhau.setThueNhapKhau(thueNhapKhau);
        newNhapKhau.setId(nhapKhauList.size()+1+"");
        readWriteFile.writeFile(NHAPKHAU_PATH,newNhapKhau.toString(),true);

    }
    public void updateData(){
        String data ="";
        for(int i = 0;i<nhapKhauList.size();i++){
            nhapKhauList.get(i).setId((i+1)+"");
            data+=nhapKhauList.get(i).toString()+"\n";
        }
        readWriteFile.writeFile(NHAPKHAU_PATH,data,false);
    }
    public  void searchNhapKhau(){
        List<SPNhapKhau> ListResult = new ArrayList<>();
        System.out.println("Input key you want to search ");
        String key = sc.nextLine();
        for(SPNhapKhau nhapkhau:nhapKhauList){
            if(nhapkhau.getMasp().contains(key)){
                ListResult.add(nhapkhau);
            }
        }
        ListResult.forEach(x-> System.out.println(x.toString()));
    }
    public void deleteNhapKhau(){
        System.out.println("NHAP Ma san pham can xoa");
        String maSP = sc.nextLine();
        for(int i =0;i<nhapKhauList.size();i++){
            if(nhapKhauList.get(i).getMasp().equals(maSP)){
                System.out.println("Co san pham");
                System.out.println("yes or no");
                String option = sc.nextLine();
                if(option.equals("yes")){
                    nhapKhauList.remove(i);
                    updateData();
                    view();
                }
            }
        }
    }
}
