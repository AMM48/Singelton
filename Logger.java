
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Logger {
  static DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
  static String currentDateTimeString = LocalDateTime.now().format(myFormatter);
  private final static String logFile = currentDateTimeString + ".txt";
  private static PrintWriter writer;
  private static Logger log;
  
  private Logger() {}
  
  public static Logger getInstance() {
    try {
      if(log == null) {
    	  log = new Logger();
    	  FileWriter fw = new FileWriter(logFile);
          writer = new PrintWriter(fw, true); 
      }
      return log;
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    return log;
  }
  public void info (String message) {
    writer.println("INFO: " + message);
  }
  public void error (String message) {
    writer.println("Error: " + message);
  }
}