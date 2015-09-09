package thjug;

import org.testng.annotations.Test;

/**
 *
 * @author pasoktummarungsri
 */
public class BahtTextNGTest {

    @Test
    public void testแปลงค่าศูนย์บาท() {
        String expResult = "ศูนย์บาท";
        String result = BahtText.getBath("0");
        assert result.equals(expResult);
    }

    @Test
    public void testแปลงค่าหนึ่งบาท() {
        String expResult = "หนึ่งบาท";
        String result = BahtText.getBath("1");
        assert result.equals(expResult);
    }

    @Test
    public void testแปลงค่าสิบบาท() {
        String expResult = "สิบบาท";
        String result = BahtText.getBath("10");
        assert result.equals(expResult);
    }

    @Test
    public void testแปลงค่ายี่สิบเอ็ดบาท() {
        String expResult = "ยี่สิบเอ็ดบาท";
        String result = BahtText.getBath("21");
        assert result.equals(expResult);
    }

    @Test
    public void testแปลงค่าหนึ่งร้อยบาทยี่สิบห้าสตางค์() {
        String expResult = "หนึ่งร้อยบาทยี่สิบห้าสตางค์";
        String result = BahtText.getBath("100.25");
        assert result.equals(expResult);
    }

}
