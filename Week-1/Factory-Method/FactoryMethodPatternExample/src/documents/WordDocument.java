package documents;

public class WordDocument implements Document {

    public void open() {
        System.out.println("Opened and Word Document");
    }

    public void close() {
        System.out.println("Closed the Word Document");
    }

    public void read() {
        System.out.println("Read the Word document");
    }
}