package volume1.chapter11.log;

import java.util.logging.Logger;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("log.test1");
		logger.info("info");
		logger.config("config");
		logger.fine("fine");
		logger.finer("finer");
	}

}
