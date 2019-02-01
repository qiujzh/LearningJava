package utils;

import org.apache.commons.lang.StringEscapeUtils;

public class UnicodeTools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = StringEscapeUtils.unescapeCsv("thenorthface\u5b98\u65b9\u65d7\u8230");
		System.out.println(str);
	}
}
