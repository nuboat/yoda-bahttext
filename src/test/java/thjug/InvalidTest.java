package thjug;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InvalidTest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void input_is_null_should_thrown_numberformat_exception() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("ข้อมูลเป็นค่า null (Null Value)");
        BahtText.getBath(null);
    }

    @Test
    public void input_is_empty_after_filter_out_input_should_thrown_numberformat_exception() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("ข้อมูลเป็นค่าว่าง (Blank Value)");
        BahtText.getBath(", ");
    }

    @Test
    public void input_is_not_valid_after_filter_out_input_should_thrown_numberformat_exception() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("ข้อมูลมีตัวอักขระ (Alphabet Value)");
        BahtText.getBath("ABC");
    }

    @Test
    public void have_multiple_dot_should_thrown_numberformat_exception() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("ทศนิยมมากกว่า 1 ตัว");
        BahtText.getBath("1.1.1.1");
    }

}
