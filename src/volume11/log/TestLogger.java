package Volume1.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestLogger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("testlogger");
		logger.setLevel(Level.INFO);
		logger.warning(TestLogger.class.getName()+"  "+TestLogger.class.getMethods()[0].getName());
	}

}
