package p9_automatedTesting_TDD.baitap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhanLoaiTamGiacTest {
    @Test
    @DisplayName("Testing add isTamGiac")
    public void isTamGiac() {
        int a = 0;
        int b = 1;
        int c = 1;
        String expected = "NO";

        String result = PhanLoaiTamGiac.getLoaiTamGiac(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing add isTamGiac1")
    public void isTamGiac1() {
        int a = -1;
        int b = 2;
        int c = 1;
        String expected = "NO";

        String result = PhanLoaiTamGiac.getLoaiTamGiac(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing add isTamGiac2")
    public void isTamGiac2() {
        int a = 8;
        int b = 2;
        int c = 3;
        String expected = "NO";

        String result = PhanLoaiTamGiac.getLoaiTamGiac(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing add tamGiacThuong")
    public void tamGiacThuong() {
        int a = 3;
        int b = 4;
        int c = 5;
        String expected = "Vuong";

        String result = PhanLoaiTamGiac.getLoaiTamGiac(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing add can")
    public void can() {
        int a = 2;
        int b = 2;
        int c = 3;
        String expected = "Can";

        String result = PhanLoaiTamGiac.getLoaiTamGiac(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing add deu")
    public void deu() {
        int a = 2;
        int b = 2;
        int c = 2;
        String expected = "Deu";

        String result = PhanLoaiTamGiac.getLoaiTamGiac(a, b, c);
        assertEquals(expected, result);
    }



}