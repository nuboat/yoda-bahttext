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
        BahtText.toText(null);
    }

    @Test
    public void input_is_empty_after_filter_out_input_should_thrown_numberformat_exception() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("ข้อมูลเป็นค่าว่าง (Blank Value)");
        BahtText.toText(", ");
    }

    @Test
    public void input_is_empty_after_filter_out_whitespaces_input_should_thrown_numberformat_exception() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("ข้อมูลเป็นค่าว่าง (Blank Value)");
        BahtText.toText("\n,  \t\n, ,\f \r \n");
    }

    @Test
    public void input_is_not_valid_after_filter_out_input_should_thrown_numberformat_exception() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("ข้อมูลมีตัวอักขระ (Alphabet Value)");
        BahtText.toText("ABC");
    }

    @Test
    public void have_multiple_dot_should_thrown_numberformat_exception() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("ทศนิยมมากกว่า 1 ตัว");
        BahtText.toText("1.1.1.1");
    }

}
