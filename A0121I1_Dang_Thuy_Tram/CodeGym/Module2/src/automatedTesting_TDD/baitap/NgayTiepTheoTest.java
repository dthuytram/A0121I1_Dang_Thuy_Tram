package automatedTesting_TDD.baitap;

import automatedTesting_TDD.thuchanh.calculateApplication.src.SimpleCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NgayTiepTheoTest {

    @Test
    @DisplayName("Testing add 28/2/2020")
    public void dayFebruary() {
        int day = 28;
        int month = 2;
        int year = 2020;
        String expected = 1 + " " + 3 + " "+ 2020 + " ";

        String result = NgayTiepTheo.ngayTiepTheo(day, month, year);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing add 29/2/2020")
    public void dayFebruary1() {
        int day = 29;
        int month = 2;
        int year = 2020;
        String expected = "NO";

        String result = NgayTiepTheo.ngayTiepTheo(day, month, year);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing add 29/2/2000")
    public void dayFebruary2() {
        int day = 29;
        int month = 2;
        int year = 2000;
        String expected = 1 + " " + 3 + " "+ 2000 + " ";

        String result = NgayTiepTheo.ngayTiepTheo(day, month, year);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing add 31/12/2000")
    public void dayDecember() {
        int day = 31;
        int month = 12;
        int year = 2000;
        String expected = 1 + " " + 1 + " "+ 2001 + " ";

        String result = NgayTiepTheo.ngayTiepTheo(day, month, year);
        assertEquals(expected, result);
    }

}