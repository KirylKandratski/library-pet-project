package kandratski.library.util;

import java.util.Date;

public class DateUtils {
    public static boolean isOverdue(Date loanDate, int daysLimit) {
        long currentTime = System.currentTimeMillis();
        long loanTime = loanDate.getTime();
        long daysDifference = (currentTime - loanTime) / (1000 * 60 * 60 * 24);

        return daysDifference > daysLimit;
    }
}
