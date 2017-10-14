package in.norbor.yoda;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *  @author Peerapat A, Sep 26, 2017
 */
public class BahtTextTest {

    @Test
    public void toText_methods_produce_same_result() {
        final String expResult = "หนึ่งร้อยบาทสิบสตางค์";
        final String inputString = "100.1";
        final double inputDouble = 100.1;

        final String resultFromString = BahtText.toText(inputString);
        final String resultFromDouble = BahtText.toText(inputDouble);

        assert expResult.equals(resultFromDouble);
        assert resultFromDouble.equals(resultFromString);
        assert expResult.equals(resultFromString);
    }

    @Test
    public void แปลงค่าศูนย์บาท() {
        final String expResult = "ศูนย์บาท";
        final String result = BahtText.toText("0");

        assertEquals(expResult, result);
    }

    @Test
    public void แปลงค่าหนึ่งบาท() {
        final String expResult = "หนึ่งบาทถ้วน";
        final String result = BahtText.toText("1");

        assertEquals(expResult, result);
    }

    @Test
    public void แปลงค่าสิบบาท() {
        final String expResult = "สิบบาทถ้วน";
        final String result = BahtText.toText("10");

        assertEquals(expResult, result);
    }

    @Test
    public void แปลงค่ายี่สิบเอ็ดบาท() {
        final String expResult = "ยี่สิบเอ็ดบาทถ้วน";
        final String result = BahtText.toText("21");

        assertEquals(expResult, result);
    }

    @Test
    public void แปลงค่าหนึ่งหมื่นสองพันสองร้อยหนึ่งล้านห้าแสนแปดหมื่นสี่พันเจ็ดร้อยหกสิบเอ็ดบาทสามสิบเก้าสตางค์() {
        final String expResult = "หนึ่งหมื่นสองพันสองร้อยหนึ่งล้านห้าแสนแปดหมื่นสี่พันเจ็ดร้อยหกสิบเอ็ดบาทสามสิบเก้าสตางค์";
        final String result = BahtText.toText("12,201,584,761.39");

        assertEquals(expResult, result);
    }

    @Test
    public void แปลงค่าหนึ่งร้อยบาทยี่สิบห้าสตางค์() {
        final String expResult = "หนึ่งร้อยบาทยี่สิบห้าสตางค์";
        final String result = BahtText.toText("100.25");

        assertEquals(expResult, result);
    }

    @Test
    public void แปลงค่าหนึ่งล้านบาท() {
        final String expResult = "หนึ่งล้านบาทถ้วน";
        final String result = BahtText.toText("1,000,000");

        assertEquals(expResult, result);
    }

    @Test
    public void ค่าหลังจุดทศนิยมมากกว่าสองหลักจะถูกตัดทิ้ง() {
        final String expResult = "หนึ่งร้อยบาทสิบสองสตางค์";
        final String result = BahtText.toText("100.125");

        assertEquals(expResult, result);
    }

    @Test
    public void ค่าหลังจุดทศนิยมน้อยกว่าสองหลักจะเพิ่มเลขศูนย์ต่อท้าย() {
        final String expResult = "หนึ่งร้อยบาทสิบสตางค์";
        final String result = BahtText.toText("100.1");

        assertEquals(expResult, result);
    }

    @Test
    public void แก้ไขข้อมูลที่มีเฉพาะจุดเท่านั้น() {
        final String expResult = "ศูนย์บาท";
        final String result = BahtText.toText(".");

        assertEquals(expResult, result);
    }

    @Test
    public void ล้านล้านบาท() {
        final String expResult = "หนึ่งล้านล้านบาทถ้วน";
        final String result = BahtText.toText("1,000,000,000,000");

        assertEquals(expResult, result);
    }

}
