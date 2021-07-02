package at.cb.s20210702wortanalyse.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;

public class PdfReader {
    public static String readPdf(InputStream is) throws IOException {

        try (PDDocument document = PDDocument.load(is))
        {
            AccessPermission ap = document.getCurrentAccessPermission();
            if (!ap.canExtractContent())
            {
                throw new IOException("You do not have permission to extract text");
            }

            PDFTextStripper stripper = new PDFTextStripper();

            // This example uses sorting, but in some cases it is more useful to switch it off,
            // e.g. in some files with columns where the PDF content stream respects the
            // column order.
            stripper.setSortByPosition(true);

            StringBuilder textBuilder = new StringBuilder();

            for (int p = 1; p <= document.getNumberOfPages(); ++p)
            {
                // Set the page interval to extract. If you don't, then all pages would be extracted.
                stripper.setStartPage(p);
                stripper.setEndPage(p);

                // let the magic happen
                String text = stripper.getText(document);
                // Text zum String-Builder hinzufügen
                textBuilder.append(text);

//                // do some nice output with a header
//                String pageStr = String.format("page %d:", p);
//                System.out.println(pageStr);
//                for (int i = 0; i < pageStr.length(); ++i)
//                {
//                    System.out.print("-");
//                }
//                System.out.println();
//                System.out.println(text.trim());
//                System.out.println();

                // If the extracted text is empty or gibberish, please try extracting text
                // with Adobe Reader first before asking for help. Also read the FAQ
                // on the website:
                // https://pdfbox.apache.org/2.0/faq.html#text-extraction
            }
            return textBuilder.toString();
        }
    }
}
