package thjug;

import java.util.StringTokenizer;

public class BahtText {
    private static final String txtNum[] = {"ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า"};
    private static final String txtWeight[] = {"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน"};

    public static String toText(final double currency) {
        return toText(Double.toString(currency));
    }

    public static String toText(final String currency)
            throws NumberFormatException {
        String number = currency;

        number = cleanString(number);
        number = padZeroIfDotPresented(number);

        validateString(number);

        final StringTokenizer st = new StringTokenizer(number, ".");
        final String beforeDot = st.nextToken();
        String afterDot = (st.hasMoreTokens()) ? st.nextToken() : null; // ทศนิยม

        boolean beforeDotIsZero = isZero(beforeDot); // ดูว่าหน้าทศนิยมเป็น 0 หรือไม่
        boolean afterDotIsZero = (afterDot == null) || isZero(afterDot);

        if (beforeDotIsZero && afterDotIsZero) {
            StringBuilder zero = new StringBuilder(0);
            zero.append("ศูนย์บาท");
            return zero.toString();
        }

        final StringBuilder result = new StringBuilder(0);

        if (!beforeDotIsZero) {
            final String[] beforeDotArr = splitString(beforeDot);
            for (int i = 0; i < beforeDotArr.length; i++) {
                result.append(generateStringNumber(beforeDotArr[i]));
                if (i + 1 < beforeDotArr.length) {
                    result.append("ล้าน");
                }
                else {
                    result.append("บาท");
                }
            }
        }

        if (afterDot != null) {
            if (afterDot.length() > 2) {
                afterDot = afterDot.substring(0, 2);
            }
            if (afterDot.length() == 1) {
                afterDot += "0";
            }

            final String[] afterDotArr = splitString(afterDot);
            for (int i = 0; i < afterDotArr.length; i++) {
                result.append(generateStringNumber(afterDotArr[i]));
            }
            result.append("สตางค์");
        }
        return result.toString();
    }

    private static void validateString(String number) {
        if (number == null) {
            throw new NumberFormatException("ข้อมูลเป็นค่า null (Null Value)");
        }

        if (number.equals("")) {
            throw new NumberFormatException("ข้อมูลเป็นค่าว่าง (Blank Value)");
        }

        if(!number.chars().allMatch(c -> (c >= '0' && c <= '9') || c == '.' )) {
            throw new NumberFormatException("ข้อมูลมีตัวอักขระ (Alphabet Value)");
        }

        if(number.indexOf('.') != number.lastIndexOf('.')) {
            throw new NumberFormatException("ทศนิยมมากกว่า 1 ตัว");
        }
    }

    private static String cleanString(String number) {
        if(number == null)
            return null;

        return number.replaceAll("\\s+|,", "");
    }

    private static String padZeroIfDotPresented(String number) {
        if(number == null)
            return null;

        String resultString = number;

        if(resultString.length() != 0) {
            if (resultString.charAt(0) == '.') {
                resultString = "0" + resultString;
            }

            if (resultString.charAt(resultString.length() - 1) == '.') {
                resultString = resultString + "0";
            }
        }

        return resultString;
    }

    private static boolean isZero(final String number) {
        return number.chars().allMatch(c -> c == '0');
    }

    private static String[] splitString(final String number) {
        final int lengthNumber = number.length();
        final int n = lengthNumber % 6;
        final int sizeArr = (lengthNumber / 6) + (n > 0 ? 1 : 0);

        final String []result = new String[sizeArr];

        int indexString = 0;
        int indexArr = 0;
        if (n > 0) {
            result[indexArr++] = number.substring(indexString, n);
            indexString += n;
        }

        for (int i = indexArr; i < sizeArr; i++) {
            result[indexArr++] = number.substring(indexString, indexString + 6);
            indexString += 6;
        }
        return result;
    }

    private static String generateStringNumber(final String number) {
        final StringBuilder result = new StringBuilder(0);
        final int length = number.length();

        for (int i = 0; i < length; i++) {
            char ch = number.charAt(i);
            if (ch != '0') {
                if (i == (length - 1) && ch == '1' &&
                        (Integer.parseInt(number) % 100 > 10)) {
                    result.append("เอ็ด"); // ดัก เลข 1 ในกรณีที่มากกว่า 10 ให้แสดงเป็น เอ็ด
                } else if (i == (length - 2) && ch == '2') {
                    result.append("ยี่"); // ดักเลข 20 -> ยี่สิบ
                } else if (i == (length - 2) && ch == '1') {
                    result.append(""); // ดักเลข 10 -> สิบ ไม่ใช่ หนึ่งสิบ
                } else {
                    result.append(txtNum[((int) ch) - 48]);
                }
                result.append(txtWeight[length - i - 1]);
            }
        }
        return result.toString();
    }

}