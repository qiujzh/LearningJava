package volume1.chapter11.log;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.logging.SocketHandler;

public class SocketHandlerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale locale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("volume1.chapter11.log.loc",locale);
		System.out.println(bundle.getString("username"));
	}

}
