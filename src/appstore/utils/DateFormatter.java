package appstore.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter
{

	public static String format(Date date, String pattern)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	
}
