package _casestudy_.commons;

import _casestudy_.model.Services;

import java.util.List;

public class ServiceValidator {
    private static String regex = "";
    public static boolean checkVillaId(String str){
        regex = "^SVVL-[\\d]{4}$";
        if(!str.matches(regex)) System.out.println("SVXX-YYYY, với YYYY là các số từ 0-9, XX là:\n" +
                "Nếu là Villa thì XX sẽ là VL\n");
        return str.matches(regex) ;
    }

    public static boolean checkHouseId(String str){
        regex = "^SVHO-[\\d]{4}$";
        if(!str.matches(regex)) System.out.println("SVXX-YYYY, với YYYY là các số từ 0-9, XX là:\n" +
                "Nếu là House thì XX sẽ là HO\n");
        return str.matches(regex);
    }

    public static boolean checkRoomId(String str){
        regex = "^SVRO-[\\d]{4}$";
        if(!str.matches(regex)) System.out.println("SVXX-YYYY, với YYYY là các số từ 0-9, XX là:\n" +
                "Nếu là Room thì XX sẽ là RO\n");
        return str.matches(regex);
    }

    public static boolean checkDuplicateId(String str, List<Services> list){
        for (Services services : list){
            if (services.getId().equals(str)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkServiceName(String str){
        regex = "^[A-Z][a-z]{0,}([\\s][A-Z][a-z]{0,})*$";
        if(!str.matches(regex)) System.out.println("Tên dịch vụ phải viết hoa ký tự đầu, " +
                "các ký tự sau là ký tự bình thường\n");
        return str.matches(regex);
    }

    public static boolean checkArea(String area){
        double areaNumber;
        try {
            areaNumber = Double.parseDouble(area);

            return areaNumber > 30;

        } catch (Exception e){
            return false;
        }
    }

    public static boolean checkRate(String rate){
        double rateNumber;
        try {
            rateNumber = Double.parseDouble(rate);
            return rateNumber > 0;

        } catch (Exception e){
            return false;
        }
    }

    public static boolean checkRentType(String type){
        regex = "^Year|Month|Week|Day$";
        return type.matches(regex);
    }

    public static boolean checkMaxCapacity(String capacity){
        int capacityNumber;
        try {
            capacityNumber = Integer.parseInt(capacity);
            return capacityNumber > 0 && capacityNumber < 20;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean checkCompService(String service){
        regex = "^Massage|Karaoke|Food|Drink|Car$";
        return service.matches(regex);
    }

    public static boolean checkFloor(String floor){
        int floorNumber;
        try {
            floorNumber = Integer.parseInt(floor);
            return floorNumber > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
