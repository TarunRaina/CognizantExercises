public class Logger {
    private static Logger loggerInstance = new Logger();
    private Logger() {
        //this is a private constructor
    }
    public static Logger getLoggerInstance() {
        return loggerInstance;
    }
}
