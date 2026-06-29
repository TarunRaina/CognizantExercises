import factories.*;
import documents.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("creating a factory object");
        DocumentFactory factory = new WordDocumentFactory();
        Document wordDoc = factory.createDocument();
        System.out.println("Word document obj functions");
        wordDoc.open();
        wordDoc.read();
        wordDoc.close();

        System.out.println("pdf document obj functions");
        factory = new PdfDocumentFactory();
        Document pdfDoc = factory.createDocument();
        pdfDoc.open();
        pdfDoc.read();
        pdfDoc.close();

        System.out.println("excel document obj functions");
        factory = new ExcelDocumentFactory();
        Document excelDoc = factory.createDocument();
        excelDoc.open();
        excelDoc.read();
        excelDoc.close();
    }
}