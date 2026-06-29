package documents;

public class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opened a excel Document");
    }

    public void close() {
        System.out.println("Closed the excel Document");
    }

    public void read() {
        System.out.println("Read the excel document");
    }
}