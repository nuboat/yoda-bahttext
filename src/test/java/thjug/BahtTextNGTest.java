package thjug;

import org.junit.Test;

public class BahtTextNGTest {
    
    @Test
    public void testConstructor() {
        final BahtText b = new BahtText();
        
        assert b != null;
    }

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
        
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่าหนึ่งบาท() {
        final String expResult = "หนึ่งบาท";
        final String result = BahtText.toText("1");
        
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่าสิบบาท() {
        final String expResult = "สิบบาท";
        final String result = BahtText.toText("10");
        
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่ายี่สิบเอ็ดบาท() {
        final String expResult = "ยี่สิบเอ็ดบาท";
        final String result = BahtText.toText("21");
        
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่าหนึ่งหมื่นสองพันสองร้อยหนึ่งล้านห้าแสนแปดหมื่นสี่พันเจ็ดร้อยหกสิบเอ็ดบาทสามสิบเก้าสตางค์() {
        final String expResult = "หนึ่งหมื่นสองพันสองร้อยหนึ่งล้านห้าแสนแปดหมื่นสี่พันเจ็ดร้อยหกสิบเอ็ดบาทสามสิบเก้าสตางค์";
        final String result = BahtText.toText("12,201,584,761.39");
        
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่าหนึ่งร้อยบาทยี่สิบห้าสตางค์() {
        final String expResult = "หนึ่งร้อยบาทยี่สิบห้าสตางค์";
        final String result = BahtText.toText("100.25");
        
        assert result.equals(expResult);
    }

    @Test
    public void แปลงค่าหนึ่งล้านบาท() {
        final String expResult = "หนึ่งล้านบาท";
        final String result = BahtText.toText("1,000,000");
        
        assert result.equals(expResult);
    }

    @Test
    public void ค่าหลังจุดทศนิยมมากกว่าสองหลักจะถูกตัดทิ้ง() {
        final String expResult = "หนึ่งร้อยบาทสิบสองสตางค์";
        final String result = BahtText.toText("100.125");
        
        assert result.equals(expResult);
    }

    @Test
    public void ค่าหลังจุดทศนิยมน้อยกว่าสองหลักจะเพิ่มเลขศูนย์ต่อท้าย() {
        final String expResult = "หนึ่งร้อยบาทสิบสตางค์";
        final String result = BahtText.toText("100.1");
        
        assert result.equals(expResult);
    }

    @Test
    public void แก้ไขข้อมูลที่มีเฉพาะจุดเท่านั้น() {
        final String expResult = "ศูนย์บาท";
        final String result = BahtText.toText(".");
        
        assert result.equals(expResult);
    }

    @Test
    public void ล้านล้านบาท() {
        final String expResult = "หนึ่งล้านล้านบาท";
        final String result = BahtText.toText("1,000,000,000,000");
        
        assert result.equals(expResult);
    }

}