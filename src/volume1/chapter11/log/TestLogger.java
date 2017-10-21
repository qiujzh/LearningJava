package volume1.chapter11.log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestLogger {
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-mm-dd");
	private static final String LOG_FOLDER_NAME = "myLogs";
	private static final String LOG_FILE_SUFFIX = ".log";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = setLoggerHander(Logger.getLogger("log.logger"), Level.CONFIG);
		logger.fine("FINE");
		logger.config("CONFIG");
	}
	public static String getLogFilePath(){
		StringBuffer logFilePath = new StringBuffer();
		logFilePath.append(System.getProperty("user.home"));
		logFilePath.append(File.separator);
		logFilePath.append(LOG_FOLDER_NAME);
		File log_folder_file = new File(logFilePath.toString());
		if(!log_folder_file.exists()){
			log_folder_file.mkdir();
		}
		logFilePath.append(File.separator);
		logFilePath.append(SDF.format(new Date()));
		logFilePath.append(LOG_FILE_SUFFIX);
		System.out.println(logFilePath.toString());
		return logFilePath.toString();
	}
	public static Logger setLoggerHander(Logger logger,Level level){
		try {
			FileHandler fileHandler = new FileHandler(getLogFilePath(),true);
//			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			logger.setLevel(level);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			logger.severe(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.severe(e.getMessage());
		}
		return logger;
	}
	
}
