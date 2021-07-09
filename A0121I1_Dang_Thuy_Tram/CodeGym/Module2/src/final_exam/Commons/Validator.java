package final_exam.Commons;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private static final String ID_REGEX = "SV(VL|HO|RO)-\\d{4}";
    private static final String NAME_REGEX ="^[A-Z]{1}[a-z]*";
    private static final String DATE_BIRTH_REGEX ="^\\d{2}\\/\\d{2}\\/\\d{4}$";
    private static final String NUMBER_REGEX ="^[1-9]\\d*$";
    private static final String SERVICE_FREE_REGEX ="^massage|karaoke|food|drink|car$";
//    private static final String AREA_POOL_REGEX="^([3-9]\\d|\\d{3,})$";
    private static final String AREA_POOL_REGEX="^([3][0]\\.\\d+)|([3][1-9]\\.?\\d*)|([4-9]\\d\\.?\\d*)|(\\d{3,}\\.?\\d*)$";
    private static final String MAX_PEOPLE="^[1-9]|[1]\\d$";

    private static Pattern pattern;
    private Matcher matcher;

    public boolean validateId(String id){
        pattern=Pattern.compile(ID_REGEX);
        matcher = pattern.matcher(id);
        return matcher.matches();
    }
    public boolean validateName(String name){
        pattern=Pattern.compile(NAME_REGEX);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public boolean validateDayBirth(String date){
        pattern=Pattern.compile(DATE_BIRTH_REGEX);
        matcher = pattern.matcher(date);
        if(!matcher.matches()){
            return false;
        }else {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            return year - Integer.parseInt(date.substring(6, 9)) > 18;
        }
    }
    public boolean validateAreaPool(String areaPool){
        pattern = Pattern.compile(AREA_POOL_REGEX);
        matcher = pattern.matcher(areaPool);
        return matcher.matches();
    }
    public boolean validateRentCost(String rentCost){
        pattern = Pattern.compile(NUMBER_REGEX);
        matcher = pattern.matcher(rentCost);
        return matcher.matches();
    }
    public boolean validateNumber(String number){
        pattern = Pattern.compile(NUMBER_REGEX);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }
    public boolean validateMaxPeople(String maxPeople){
        pattern = Pattern.compile(MAX_PEOPLE);
        matcher = pattern.matcher(maxPeople);
        return matcher.matches();
    }
    public boolean validateFreeService(String freeServices){
        pattern = Pattern.compile(SERVICE_FREE_REGEX);
        matcher = pattern.matcher(freeServices);
        return matcher.matches();
    }
    public boolean validateFloor(String floor){
        pattern = Pattern.compile(NUMBER_REGEX);
        matcher = pattern.matcher(floor);
        return matcher.matches();
    }

}
