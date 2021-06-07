package p9_automatedTesting_TDD.baitap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoChuyenChuTest {

    @Test
    @DisplayName("Test add 9000000")
    public void convert() {
        int num = 9000000;
        String expected = "chin trieu ";

        String result = SoChuyenChu.convert(num);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test add 1200")
    public void convert1() {
        int num = 1200;
        String expected = "mot ngan hai tram";

        String result = SoChuyenChu.convert(num);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test add 3921")
    public void convert2() {
        int num = 3921;
        String expected = "ba ngan chin tram hai muoi mot";

        String result = SoChuyenChu.convert(num);
        assertEquals(expected, result);
    }

}