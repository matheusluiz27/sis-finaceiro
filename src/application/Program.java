package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ParseException {
//		Date d1 = new Date();
//		Date d2 = new Date(12312334);
//		long dif = d1.getTime() + d2.getTime();
//		
//		System.out.println(dif);
//		Date d3 = new Date(dif);
//		System.out.println(d3.toString());
//		
//		String myString = DateFormat.getDateInstance().format(new Date());
//		System.out.println(myString);
//		
//		DateFormat df = DateFormat.getDateInstance();
//		System.out.println(df.DAY_OF_WEEK_IN_MONTH_FIELD);
//		
//		Calendar c1 = Calendar.getInstance();
//		
//		System.out.println(c1.get(Calendar.YEAR));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		Date d = sdf.parse("12/03/1999 21:12");
		System.out.println(d);
		System.out.println(sdf.format(d));
		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		System.out.println(c.get(Calendar.MONTH)+1);
		
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
	}

}
