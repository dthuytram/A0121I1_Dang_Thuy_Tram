package p9_automatedTesting_TDD.baitap;

import java.text.DecimalFormat;

public class SoChuyenChu {

    private static final String[] tensNames = {
            "",
            " muoi",
            " hai muoi",
            " ba muoi",
            " bon muoi",
            " nam muoi",
            " sau muoi",
            " bay muoi",
            " tam muoi ",
            " chin muoi "
    };

    private static final String[] numNames = {
            "",
            " mot",
            " hai",
            " ba",
            " bon",
            " nam",
            " sau",
            " bay",
            " tam",
            " chin",
            " muoi",
            " muoi mot",
            " muoi hai",
            " muoi ba",
            " muoi bon",
            " muoi lam",
            " muoi sau",
            " muoi bay",
            " muoi tam",
            " muoi chin"
    };

    private SoChuyenChu() {
    }

    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
//                System.out.println(number);
            soFar = numNames[number % 100];
//                System.out.println("soFar"+ soFar);
            number /= 100;
//                System.out.println("number"+ number);
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " tram" + soFar;
    }


    public static String convert(long number) {
        // 0 to 999 999 999 999
        if (number == 0) {
            return "khong";
        }

        String snumber = Long.toString(number);

        // pad with "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(3, 6));
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions)
                        + " ti ";
                break;
            default:
                tradBillions = convertLessThanOneThousand(billions)
                        + " ti ";
        }
        String result = tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = convertLessThanOneThousand(millions)
                        + " trieu ";
                break;
            default:
                tradMillions = convertLessThanOneThousand(millions)
                        + " trieu ";
        }
        result = result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "mot ngan ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                        + " ngan ";
        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    /**
     * testing
     *
     * @param args
     */
//    public static void main(String[] args) {
//
//            System.out.println("*** " + SoChuyenChu.convert(3421));


//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(1));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(16));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(100));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(118));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(200));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(219));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(800));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(801));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(1316));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(1000000));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(2000000));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(3000200));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(700000));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(9000000));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(9001000));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(123456789));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(2147483647));
//            System.out.println("*** " + gioithieuJava.NumberConvert.convert(3000000010L));

//
//    }
}

