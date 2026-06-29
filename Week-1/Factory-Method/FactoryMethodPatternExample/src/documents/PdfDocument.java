package documents;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opened a pdf Document");
    }

    public void close() {
        System.out.println("Closed the pdf Document");
    }

    public void read() {
        System.out.println("Read the pdf document");
    }
}