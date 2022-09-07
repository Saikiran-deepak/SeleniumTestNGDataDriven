package utilities;

import java.util.Date;

public class DateUtils {
// to get the test report on tested date	
	public static String getTimeStamp(){
		Date date = new Date();
		System.out.println(date.toString());
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
