package service;

import bean.DichVu;
import bean.ThongTinTiecCuoi;
import repository.ITiecCuoiRepository;
import repository.TiecCuoiRepository;

import java.util.List;

public class TiecCuoiService implements ITiecCuoiService{
    private ITiecCuoiRepository repositoryUser = new TiecCuoiRepository();

    @Override
    public void createThongtin(ThongTinTiecCuoi thongtinTiecCuoi) {
        repositoryUser.createThongtin(thongtinTiecCuoi);
    }

    @Override
    public void update(ThongTinTiecCuoi thongtinTiecCuoi,int id) {
        repositoryUser.update(thongtinTiecCuoi,id);
    }

    @Override
    public List<ThongTinTiecCuoi> thongtinList() {
        return repositoryUser.thongtinList();
    }

    @Override
    public boolean delete(int id) {
        return repositoryUser.delete(id);
    }

    @Override
    public ThongTinTiecCuoi selectById(int id) {
        return repositoryUser.selectById(id);
    }

//    @Override
//    public ThongTinTiecCuoi searchById(int id) {
//        return null;
//    }

    @Override
    public List<DichVu> dichVuList() {
        return repositoryUser.dichVuList();
    }

    @Override
    public DichVu selectByIdDichVu(int id) {
        return repositoryUser.selectByIdDicVu(id);
    }
}
