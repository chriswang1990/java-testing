package testing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by 1990c on 5/12/2016.
 */
public class DateTesting {

    public static void main(String[] args) {
        Date todayDate = new Date(System.currentTimeMillis());
        SimpleDateFormat testFormate = new SimpleDateFormat("yyyyMMdd");
        System.out.println(testFormate.format(todayDate));
        testFormate.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(testFormate.format(todayDate));

    }
}
