package thjug;


import org.junit.Test;

public class BahtTextNGTest {

    @Test
    public void แปลงค่าศูนย์บาท() {
        String expResult = "ศูนย์บาท";
        String result = BahtText.getBath("0");
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่าหนึ่งบาท() {
        String expResult = "หนึ่งบาท";
        String result = BahtText.getBath("1");
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่าสิบบาท() {
        String expResult = "สิบบาท";
        String result = BahtText.getBath("10");
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่ายี่สิบเอ็ดบาท() {
        String expResult = "ยี่สิบเอ็ดบาท";
        String result = BahtText.getBath("21");
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่าหนึ่งร้อยบาทยี่สิบห้าสตางค์() {
        String expResult = "หนึ่งร้อยบาทยี่สิบห้าสตางค์";
        String result = BahtText.getBath("100.25");
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่าหนึ่งล้านบาท() {
        String expResult = "หนึ่งล้านบาท";
        String result = BahtText.getBath("1,000,000");
        assert result.equals(expResult);
    }

    @Test
    public void ค่าหลังจุดทศนิยมมากกว่าสองหลักจะถูกตัดทิ้ง() {
        String expResult = "หนึ่งร้อยบาทสิบสองสตางค์";
        String result = BahtText.getBath("100.125");
        assert result.equals(expResult);
    }

    @Test
    public void ค่าหลังจุดทศนิยมน้อยกว่าสองหลักจะเพิ่มเลขศูนย์ต่อท้าย() {
        String expResult = "หนึ่งร้อยบาทสิบสตางค์";
        String result = BahtText.getBath("100.1");
        assert result.equals(expResult);
    }

    @Test
    public void แก้ไขข้อมูลที่มีเฉพาะจุดเท่านั้น() {
        String expResult = "ศูนย์บาท";
        String result = BahtText.getBath(".");
        assert result.equals(expResult);
    }

    @Test
    public void ล้านล้านบาท() {
        String expResult = "หนึ่งล้านล้านบาท";
        String result = BahtText.getBath("1,000,000,000,000");
        assert result.equals(expResult);
    }

}