package utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParsUtils {

    public static double parseStringToDouble(String str) {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        double value = 0;
        try {
            value = format.parse(str).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }
}
