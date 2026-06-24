public class Test {
    public static void main(String[] args) {
        Logger l1 = Logger.getLoggerInstance();
        Logger l2 = Logger.getLoggerInstance();
        if(l1==l2) {
            System.out.println("Singleton Pattern Achieved - Both objects point to the same & single instance of class Logger");
        }
    }
}
