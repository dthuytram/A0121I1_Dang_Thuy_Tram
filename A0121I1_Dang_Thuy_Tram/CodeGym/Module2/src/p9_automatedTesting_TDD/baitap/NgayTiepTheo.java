package p9_automatedTesting_TDD.baitap;

public class NgayTiepTheo {
    public static boolean namNhuan(int year) {
        boolean isDivideBy400 = year % 400 == 0;
        boolean isDivideBy100And4 = (year % 100 == 0) && (year % 4 == 0);
        return (isDivideBy400 || isDivideBy100And4);
    }

    public static int ngayTrongThang(int month, int year) {
        int day;
        if (month < 1 && month > 12) day = -1; // khong dung dinh dang
        else {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    day = 31;
                    break;
                }
                case 4:
                case 6:
                case 9:
                case 11: {
                    day = 30;
                    break;
                }
                default: {
                    day = getDayFebruary(year);
                    break;
                }
            }
        }
        return day;
    }

    public static String ngayTiepTheo(int ngayNhapVao, int thang, int nam) {
        int ngayTrongThang = ngayTrongThang(thang, nam);
        // truong hop sai
        if (ngayTrongThang == -1 || ngayNhapVao < 1 || ngayNhapVao > ngayTrongThang)
            return "NO";
        else
        {
            if (ngayNhapVao < ngayTrongThang)
                ngayNhapVao++;
            else if (thang != 12)
            {
                ngayNhapVao = 1;
                thang++;
            }
            else
            {
                ngayNhapVao = thang = 1;
                nam++;
            }
        }
        return ngayNhapVao + " " + thang + " "+ nam + " ";
    }

    public static int getDayFebruary(int year) {
        int day;
        if (!namNhuan(year))
            day = 28;
        else
            day = 29;
        return day;
    }


}
