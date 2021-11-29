package at.cb.s20211122wortanalyse.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;

public class PdfReader {
    public static String readPdf(InputStream is) throws IOException {
        // PDF öffnen
        try (PDDocument document = PDDocument.load(is)){
            // Manche PDFs haben keine Berechtigung um den Text zu extrahieren
            if(!document.getCurrentAccessPermission().canExtractContent()){
                throw new IOException("No permission to extract content");
            }

            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);

            StringBuilder pages = new StringBuilder();

            // Für jede Seite des PDF-Dokuments den Text extrahieren
            for(int p = 1; p <= document.getNumberOfPages(); p++){
                // stripper auf die jeweilige Seite setzen
                stripper.setStartPage(p);
                stripper.setEndPage(p);

                // Text der Seite herausholen
                String text = stripper.getText(document);

                // Text der Seite zum StringBuilder hinzufügen
                pages.append(text);
            }
            return pages.toString();
        }
    }
}
