package model;

public class Loai {
    private String id_loai;
    private String ten_loai;

    public Loai(String id_loai) {
        this.id_loai = id_loai;
    }

    public Loai(String id_loai, String ten_loai) {
        this.id_loai = id_loai;
        this.ten_loai = ten_loai;
    }

    public String getId_loai() {
        return id_loai;
    }

    public void setId_loai(String id_loai) {
        this.id_loai = id_loai;
    }

    public String getTen_loai() {
        return ten_loai;
    }

    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }
}
