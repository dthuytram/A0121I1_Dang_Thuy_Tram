package abab.examRevision.bai1_mxduy.commons;

import abab.examRevision.bai1_mxduy.models.KhachHang;

import java.util.Comparator;

public class CustomerComparator implements Comparator<KhachHang> {
    @Override
    public int compare(KhachHang customer1, KhachHang customer2) {
        int result = customer1.getTenKhachHang().compareTo(customer2.getTenKhachHang());
        if (result == 0) {
            return customer1.getNgaySinh().compareTo(customer2.getNgaySinh());
        } else {
            return result;
        }
    }
}