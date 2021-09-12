package repository;

import bean.DichVu;
import bean.ThongTinTiecCuoi;
import connect.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiecCuoiRepository implements ITiecCuoiRepository {
    public static final String INSERT_INTO = "insert into king_restaurant (" +
            "ngaytochuc,tencodau,tenchure," +
            "soluongban,dongia,dichvudikem,tiennodatcoc,\n" +
            "tiennothanhtoan,ngaydatcoc,ngaythanhtoan,ghichu,trangthai)\n" +
            "values(?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_THONGTIN = "update thongtintieccuoi\n" +
            "set ngaytochuc=?,tencodau=?,tenchure=?,soluongban=?,dongia=?,dichvudikem=?,tiennodatcoc=?,tiennothanhtoan=?,ngaydatcoc=?,ngaythanhtoan=?,ghichu=?,trangthai=?\n" +
            "where id =?";

    @Override
    public void createThongtin(ThongTinTiecCuoi thongtinTiecCuoi) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(INSERT_INTO);
            statement.setString(1, thongtinTiecCuoi.getNgayToChuc());
            statement.setString(2, thongtinTiecCuoi.getTenCoDau());
            statement.setString(3, thongtinTiecCuoi.getTenChuRe());
            statement.setInt(4, thongtinTiecCuoi.getSoLuongBan());
            statement.setInt(5, thongtinTiecCuoi.getDonGia());
            statement.setInt(6, thongtinTiecCuoi.getDichVuDiKem());
            statement.setInt(7, thongtinTiecCuoi.getTenNoDatCoc());
            statement.setInt(8, thongtinTiecCuoi.getTienNoThanhToan());
            statement.setString(9, thongtinTiecCuoi.getNgayDatCoc());
            statement.setString(10, thongtinTiecCuoi.getNgayThanhToan());
            statement.setString(11, thongtinTiecCuoi.getGhiChu());
            statement.setString(12, thongtinTiecCuoi.getTrangThai());
            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();
    }

    @Override
    public void update(ThongTinTiecCuoi thongtinTiecCuoi, int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareCall(UPDATE_THONGTIN);
            statement.setString(1, thongtinTiecCuoi.getNgayToChuc());
            statement.setString(2, thongtinTiecCuoi.getTenCoDau());
            statement.setString(3, thongtinTiecCuoi.getTenChuRe());
            statement.setInt(4, thongtinTiecCuoi.getSoLuongBan());
            statement.setInt(5, thongtinTiecCuoi.getDonGia());
            statement.setInt(6, thongtinTiecCuoi.getDichVuDiKem());
            statement.setInt(7, thongtinTiecCuoi.getTenNoDatCoc());
            statement.setInt(8, thongtinTiecCuoi.getTienNoThanhToan());
            statement.setString(9, thongtinTiecCuoi.getNgayDatCoc());
            statement.setString(10, thongtinTiecCuoi.getNgayThanhToan());
            statement.setString(11, thongtinTiecCuoi.getGhiChu());
            statement.setString(12, thongtinTiecCuoi.getTrangThai());
            statement.setInt(13, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.close();
    }

    @Override
    public List<ThongTinTiecCuoi> thongtinList() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ThongTinTiecCuoi> thongtinTiecCuois = new ArrayList<>();

        try {
            statement = connection.prepareCall("SELECT * FROM thongtintieccuoi;");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ngayToChuc = resultSet.getString("ngaytochuc");
                String tenCoDau = resultSet.getString("tencodau");
                String tenChuRe = resultSet.getString("tenchure");
                int soLuongBan = resultSet.getInt("soluongban");
                int donGia = resultSet.getInt("dongia");
                int dichVuDiKem = resultSet.getInt("dichvudikem");
                int tenNoDatCoc = resultSet.getInt("tiennodatcoc");
                int tienNoThanhToan = resultSet.getInt("tiennothanhtoan");
                String ngayDatCoc = resultSet.getString("ngaydatcoc");
                String ngayThanhToan = resultSet.getString("ngaythanhtoan");
                String ghiChu = resultSet.getString("ghichu");
                String trangThai = resultSet.getString("trangthai");
                int id = resultSet.getInt("id");
                thongtinTiecCuois.add(new ThongTinTiecCuoi(id, ngayToChuc, tenCoDau, tenChuRe, soLuongBan, donGia, dichVuDiKem, tenNoDatCoc, tienNoThanhToan, ngayDatCoc, ngayThanhToan, ghiChu, trangThai));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.close();
        return thongtinTiecCuois;
    }

    @Override
    public boolean delete(int id){
    boolean rowDel=false;
    Connection  connection= DBConnection.getConnection();
    PreparedStatement statement=null;
        try {
        statement = connection.prepareStatement("delete from thongtintieccuoi where id= ? ");
        statement.setInt(1, id);
        rowDel=   statement.executeUpdate()>1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
            DBConnection.close();
            return rowDel;

        }

    @Override
    public ThongTinTiecCuoi selectById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ThongTinTiecCuoi thongtinTiecCuoi= null;

        try {
            statement = connection.prepareCall("SELECT * FROM thongtintieccuoi where id=?;");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ngayToChuc = resultSet.getString("ngaytochuc");
                String tenCoDau = resultSet.getString("tencodau");
                String tenChuRe = resultSet.getString("tenchure");
                int soLuongBan = resultSet.getInt("soluongban");
                int donGia = resultSet.getInt("dongia");
                int dichVuDiKem = resultSet.getInt("dichvudikem");
                int tenNoDatCoc = resultSet.getInt("tiennodatcoc");
                int tienNoThanhToan = resultSet.getInt("tiennothanhtoan");
                String ngayDatCoc = resultSet.getString("ngaydatcoc");
                String ngayThanhToan = resultSet.getString("ngaythanhtoan");
                String ghiChu = resultSet.getString("ghichu");
                String trangThai = resultSet.getString("trangthai");
                thongtinTiecCuoi = new ThongTinTiecCuoi(id, ngayToChuc, tenCoDau, tenChuRe, soLuongBan, donGia, dichVuDiKem, tenNoDatCoc, tienNoThanhToan, ngayDatCoc,
                                                         ngayThanhToan, ghiChu, trangThai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.close();
        return thongtinTiecCuoi;

    }

//    @Override
//    public ThongTinTiecCuoi searchById(int id) {
//        return null;
//    }

    @Override
    public List<DichVu> dichVuList() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<DichVu> dichVus = new ArrayList<>();

        try {
            statement = connection.prepareCall("SELECT * FROM dichvu;");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String tenDichVu = resultSet.getString("ten_dichvu");
                int don_gia = resultSet.getInt("don_gia");

                int id = resultSet.getInt("id_dichvudikem");
                dichVus.add(new DichVu(id, tenDichVu, don_gia));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();


        return dichVus;
    }

    @Override
    public DichVu selectByIdDicVu(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DichVu dichVu= null;

        try {
            statement = connection.prepareCall("SELECT * FROM dichvu where id_dichvudikem =?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String tenDichVu = resultSet.getString("ten_dichvu");
                int don_gia = resultSet.getInt("don_gia");
                dichVu = new DichVu(id,tenDichVu,don_gia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        DBConnection.close();
        return dichVu;
    }
}


