package repository;

import bean.DichVu;
import bean.ThongTinTiecCuoi;

import java.util.List;

public interface ITiecCuoiRepository {

    void createThongtin(ThongTinTiecCuoi thongtinTiecCuoi);

    void update(ThongTinTiecCuoi thongtinTiecCuoi,int id);

    List<ThongTinTiecCuoi> thongtinList();

    boolean delete(int id);

    ThongTinTiecCuoi selectById(int id);

//    ThongTinTiecCuoi searchById(int id);
    List<DichVu> dichVuList();

    DichVu selectByIdDicVu(int id);

}
