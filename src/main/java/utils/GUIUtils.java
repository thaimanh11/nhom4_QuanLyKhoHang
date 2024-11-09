
package utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GUIUtils {
    public static String getDateFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
    
    public static String getTimestampFormat(Timestamp timestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        return formatter.format(timestamp);
    }
    
}
