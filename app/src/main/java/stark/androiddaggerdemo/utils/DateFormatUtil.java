package stark.androiddaggerdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jihongwen on 2017/6/30.
 */

public class DateFormatUtil {

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm", Locale.getDefault());

    public static String getFormatDate(long timeMillis) {
        return FORMAT.format(new Date(timeMillis));
    }

    public static long parseFormatDate(String formatDate) {
        try {
            return FORMAT.parse(formatDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
