package volume1.chapter11.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("java.util.logging.config.file", "logging.properties");
		
		Logger logger = Logger.getLogger("log.test");
//		for(int i=0;i<=8;i++){
//			logger.setLevel(Level.OFF);
			logger.warning("warning");
			logger.info("info");
			logger.config("config");
			logger.fine("fine");
			logger.log(Level.FINER, "finer");
//		}
	}
}
