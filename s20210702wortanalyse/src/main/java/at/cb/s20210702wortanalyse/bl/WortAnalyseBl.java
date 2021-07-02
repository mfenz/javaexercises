package at.cb.s20210702wortanalyse.bl;

import at.cb.s20210702wortanalyse.pdf.PdfReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class WortAnalyseBl {
    private String urlDokumentA;

    private String textDokumentA;

    public WortAnalyseBl(String urlDokumentA){
        this.urlDokumentA = urlDokumentA;
    }

    public void init() throws IOException {
        // Text für Dokument A laden
        InputStream inputStream = new URL(urlDokumentA).openStream();
        String text = PdfReader.readPdf(inputStream);
        inputStream.close();

        // Sonderzeichen aus Text löschen
        textDokumentA = replaceSpecialChars(text);
    }

    /**
     * Entfernt alle Sonderzeichen aus dem übergebenen String
     * @param text String mit Sonderzeichen
     * @return String (Text) ohne Sonderzeichen
     */
    private String replaceSpecialChars(String text){
        String[] special = {".", ",", "(", ")", "-", ":", "?",
                "!", "\n", "\r", ";", "@", "$", "\"", "'", "%", "&"};
        for(String s : special){
            text = text.replace(s, "");
        }
        return text;
    }

    public Set<String> textToSet(String text){
        // String anhand der Leerzeichen in einzelne Wörter aufteilen
        String[] split = text.split(" ");

        Set<String> set = new TreeSet<>(Arrays.asList(split));
        return set;
    }

    public void printDocumentInfo(){
        // Set für Document A
        Set<String> wordsDocA = textToSet(textDokumentA);

        // Ausgabe der Anzahl an verschiedenen Wörtern
        System.out.printf("Anzahl der verschiedenen Wörter: %d%n", wordsDocA.size());

        System.out.println("Wörter im Dokument:");
        for(String word : wordsDocA){
            System.out.println(word);
        }
    }
}
